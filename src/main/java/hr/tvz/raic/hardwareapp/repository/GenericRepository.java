package hr.tvz.raic.hardwareapp.repository;

import hr.tvz.raic.hardwareapp.model.GenericClass;

import java.util.List;
import java.util.Optional;

public interface GenericRepository<T extends GenericClass> {
    List<T> findAll();
    Optional<T> findByCode(String code);
    void create(T object);
    void update(String code, Double price);
    void delete(String code);
}
