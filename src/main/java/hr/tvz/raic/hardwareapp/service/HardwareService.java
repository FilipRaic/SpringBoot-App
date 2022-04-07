package hr.tvz.raic.hardwareapp.service;

import hr.tvz.raic.hardwareapp.command.HardwareCommand;
import hr.tvz.raic.hardwareapp.dto.HardwareDTO;
import hr.tvz.raic.hardwareapp.enums.HardwareTypeConst;
import hr.tvz.raic.hardwareapp.model.Hardware;
import hr.tvz.raic.hardwareapp.repository.HardwareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HardwareService {
    @Autowired
    private HardwareRepository hardwareRepository;

    public List<HardwareDTO> getAllHardware() {
        List<HardwareDTO> hardwareDTOList = new ArrayList<>();

        for (Hardware hardware : hardwareRepository.findAll()) {
            if (hardware.getType().equals(HardwareTypeConst.OTHER) && hardware.getAmountAvailable() >= 100) {
                hardwareDTOList.add(applyDiscount(hardware));
            } else {
                hardwareDTOList.add(new HardwareDTO(hardware));
            }
        }

        return hardwareDTOList;
    }

    public Optional<HardwareDTO> getHardwareByCode(String hardwareCode) {
        Hardware hardware = hardwareRepository.findByCode(hardwareCode).map(hardware1 -> ResponseEntity.status(HttpStatus.OK).body(hardware1)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build()).getBody();
        if (hardware == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hardware with that code does not exist.");
        }
        if (hardware.getType().equals(HardwareTypeConst.OTHER) && hardware.getAmountAvailable() >= 100) {
            return Optional.of(applyDiscount(hardware));
        }

        return Optional.of(new HardwareDTO(hardware));
    }

    public ResponseEntity<HardwareDTO> create(HardwareCommand hardwareCommand) {
        Hardware newHardware = new Hardware(hardwareCommand);
        for (Hardware hardware : hardwareRepository.findAll()) {
            if (hardware.getCode().equals(newHardware.getCode())) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Hardware code already exists.");
            }
        }
        hardwareRepository.create(newHardware);
        return ResponseEntity.ok(new HardwareDTO(newHardware));
    }

    public HardwareDTO update(String hardwareCode, Double price) {
        Hardware updatedHardware = hardwareRepository.findByCode(hardwareCode).map(hardware1 -> ResponseEntity.status(HttpStatus.OK).body(hardware1)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build()).getBody();
        if (updatedHardware == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hardware with that code does not exist.");
        }
        hardwareRepository.update(hardwareCode, price);
        return new HardwareDTO(updatedHardware);
    }

    public void delete(String hardwareCode) {
        hardwareRepository.delete(hardwareCode);
    }

    public static HardwareDTO applyDiscount(Hardware hardware) {
        return new HardwareDTO(hardware.getName(), hardware.getPrice()*0.75);
    }
}
