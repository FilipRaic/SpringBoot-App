package hr.tvz.raic.hardwareapp.repository;

import hr.tvz.raic.hardwareapp.model.Hardware;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface HardwareRepositoryInterface {
    List<Hardware> findAll();
    Optional<List<Hardware>> findByCode(String code);
    void create(Hardware object);
    void update(String code, Double price);
    void delete(String code);
}
