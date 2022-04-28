package hr.tvz.raic.hardwareapp.repository;

import hr.tvz.raic.hardwareapp.model.GenericClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface GenericRepository<T extends GenericClass> extends CrudRepository<T, Long> {
    List<T> findAll();
    Optional<T> findByCode(String code);
    void create(T object);
    void update(String code, Double price);
    void delete(String code);
}
