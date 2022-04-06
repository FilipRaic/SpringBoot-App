package hr.tvz.raic.hardwareapp.repository;

import hr.tvz.raic.hardwareapp.enums.HardwareTypeConst;
import hr.tvz.raic.hardwareapp.model.Hardware;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class HardwareRepository implements GenericRepository<Hardware> {
    @UniqueElements
    private static List<Hardware> hardwareList = new ArrayList<>(Arrays.asList(
            new Hardware("Ryzen 5 3500x", "1001", 139.0,HardwareTypeConst.CPU, 15),
            new Hardware("Ryzen 5 3600", "1000", 150.0, HardwareTypeConst.OTHER, 200),
            new Hardware("Ryzen 5 5600x", "1002", 350.0, HardwareTypeConst.OTHER, 10)));

    @Override
    public List<Hardware> findAll() {
        return hardwareList;
    }

    @Override
    public Optional<Hardware> findByCode(String hardwareCode) {
        for (Hardware hardware : hardwareList) {
            if (hardware.getCode().equals(hardwareCode)) {
                return Optional.of(hardware);
            }
        }
        return Optional.empty();
    }

    @Override
    public void create(Hardware hardware) {
        hardwareList.add(hardware);
    }

    @Override
    public void update(String hardwareCode, Hardware updatedHardware) {
        for (Hardware hardware : hardwareList) {
            if (hardware.getCode().equals(hardwareCode)) {
                hardware.setName(updatedHardware.getName());
                hardware.setCode(updatedHardware.getCode());
                hardware.setPrice(updatedHardware.getPrice());
                hardware.setType(updatedHardware.getType());
                hardware.setAmountAvailable(updatedHardware.getAmountAvailable());
            }
        }
    }

    @Override
    public void delete(String hardwareCode) {
        hardwareList.remove(findByCode(hardwareCode).get());
    }
}
