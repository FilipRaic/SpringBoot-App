package hr.tvz.raic.hardwareapp.repository;

import hr.tvz.raic.hardwareapp.model.Hardware;
import hr.tvz.raic.hardwareapp.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByHardware(Hardware hardware);
    Review findReviewByTitle(String text);
}
