package hr.tvz.raic.hardwareapp.repository;

import hr.tvz.raic.hardwareapp.command.HardwareCommand;
import hr.tvz.raic.hardwareapp.model.Hardware;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HardwareRepositoryInterface {
    List<Hardware> findAll();
    Optional<List<Hardware>> findByCode(String code);
    void create(Hardware object);
    void update(String code, HardwareCommand newHardware);
    void delete(String code);
    List<Hardware> findHardwareWithQty();
}
