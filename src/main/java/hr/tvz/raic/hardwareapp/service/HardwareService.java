package hr.tvz.raic.hardwareapp.service;

import hr.tvz.raic.hardwareapp.command.HardwareCommand;
import hr.tvz.raic.hardwareapp.dto.HardwareDTO;
import hr.tvz.raic.hardwareapp.enums.HardwareTypeConst;
import hr.tvz.raic.hardwareapp.model.Hardware;
import hr.tvz.raic.hardwareapp.repository.HardwareRepository;
import hr.tvz.raic.hardwareapp.repository.JdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HardwareService {
    @Autowired
    private HardwareRepository hardwareRepository;

    @Autowired
    private JdbcRepository jdbcRepository;

    public List<HardwareDTO> getAllHardware() {
        List<HardwareDTO> hardwareDTOList = new ArrayList<>();

        for (Hardware hardware : jdbcRepository.findAll()) {
            hardwareDTOList.add(new HardwareDTO(hardware));
        }

        return hardwareDTOList;
    }

    public Optional<List<HardwareDTO>> getHardwareByCode(String hardwareCode) {
        List<Hardware> hardwareList = jdbcRepository.findByCode(hardwareCode).map(hardware1 -> ResponseEntity.status(HttpStatus.OK).body(hardware1)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build()).getBody();
        if (hardwareList == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hardware with that code does not exist.");
        }

        List<HardwareDTO> dtoList = new ArrayList<>();

        for (Hardware hardware : hardwareList) {
            dtoList.add(new HardwareDTO(hardware));
        }

        return Optional.of(dtoList);
    }

    public ResponseEntity<HardwareDTO> create(HardwareCommand hardwareCommand) {
        if (HardwareTypeConst.getTypeFromString(hardwareCommand.getType()) == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Hardware type is invalid.");
        }

        Hardware newHardware = new Hardware(hardwareCommand);
        for (Hardware hardware : jdbcRepository.findAll()) {
            if (hardware.getCode().equals(newHardware.getCode())) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Hardware code already exists.");
            }
        }
        jdbcRepository.create(newHardware);
        return ResponseEntity.created(URI.create("/hardware")).body(new HardwareDTO(newHardware));
    }

    public HardwareDTO update(String hardwareCode, HardwareCommand newHardware) {
        List<Hardware> updatedHardware = jdbcRepository.findByCode(hardwareCode).get();
        if (updatedHardware == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hardware with that code does not exist.");
        }
        jdbcRepository.update(hardwareCode, newHardware);
        return new HardwareDTO();
    }

    public void delete(String hardwareCode) {
        jdbcRepository.delete(hardwareCode);
    }
}
