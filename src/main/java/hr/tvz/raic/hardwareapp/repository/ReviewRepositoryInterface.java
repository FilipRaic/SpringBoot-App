package hr.tvz.raic.hardwareapp.repository;

import hr.tvz.raic.hardwareapp.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepositoryInterface extends JpaRepository<Review, Long> {
    List<Review> findByHardwareCode(String code);
}
