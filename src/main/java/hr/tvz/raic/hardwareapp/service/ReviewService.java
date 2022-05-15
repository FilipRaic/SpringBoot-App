package hr.tvz.raic.hardwareapp.service;

import hr.tvz.raic.hardwareapp.model.Hardware;
import hr.tvz.raic.hardwareapp.model.Review;
import hr.tvz.raic.hardwareapp.repository.JdbcRepository;
import hr.tvz.raic.hardwareapp.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private JdbcRepository jdbcRepository;

    public List<Review> getAllReviews() {
        return (List<Review>) reviewRepository.findAll();
    }

    public List<Review> getReviewsByHardwareCode(String hardwareCode) {
        Hardware hardware = jdbcRepository.findByCode(hardwareCode).get().stream().findFirst().get();
        return (List<Review>) reviewRepository.findByHardware(hardware);
    }

    public Review getReviewByText(String text) {
        return (Review) reviewRepository.findReviewByTitle(text);
    }
}
