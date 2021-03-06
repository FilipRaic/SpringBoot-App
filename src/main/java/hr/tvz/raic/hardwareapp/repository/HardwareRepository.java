package hr.tvz.raic.hardwareapp.repository;

import hr.tvz.raic.hardwareapp.command.HardwareCommand;
import hr.tvz.raic.hardwareapp.model.Hardware;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class HardwareRepository implements HardwareRepositoryInterface {
//    @UniqueElements
//    private static List<Hardware> hardwareList = new ArrayList<>(Arrays.asList(
//            new Hardware(1L, "Ryzen 5 3500x", "1001", HardwareTypeConst.CPU, 15, 139.0),
//            new Hardware(2L, "Ryzen 5 3600x", "1000", HardwareTypeConst.OTHER, 200, 350.0),
//            new Hardware(3L, "Ryzen 5 5600x", "1002", HardwareTypeConst.OTHER, 10, 750.0),
//            new Hardware(4L, "Intel i9-9900K", "1003", HardwareTypeConst.OTHER, 10, 1200.0)));

    private static final List<Hardware> hardwareList = new ArrayList<>();

    @Override
    public List<Hardware> findAll() {
        return hardwareList;
    }

    @Override
    public Optional<List<Hardware>> findByCode(String hardwareCode) {
        for (Hardware hardware : hardwareList) {
            if (hardware.getCode().equals(hardwareCode)) {
                return Optional.empty();
            }
        }
        return Optional.empty();
    }

    @Override
    public void create(Hardware hardware) {
        hardwareList.add(hardware);
    }

    @Override
    public void update(String hardwareCode, HardwareCommand newHardware) {

    }

    @Override
    public void delete(String hardwareCode) {
        hardwareList.remove(findByCode(hardwareCode).get());
    }

    @Override
    public List<Hardware> findHardwareWithQty() {
        return null;
    }
}
