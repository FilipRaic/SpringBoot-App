package hr.tvz.raic.hardwareapp.repository;

import hr.tvz.raic.hardwareapp.model.Review;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ReviewRepository implements ReviewRepositoryInterface {

    @Override
    public List<Review> findAll() {
        return null;
    }

    @Override
    public List<Review> findByHardwareCode(String code) {
        return null;
    }

    @Override
    public List<Review> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Review> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Review> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Review entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Review> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Review> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Review> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Review> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Review> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Review> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Review> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Review getOne(Long aLong) {
        return null;
    }

    @Override
    public Review getById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Review> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Review> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Review> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Review> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Review> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Review> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Review, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
