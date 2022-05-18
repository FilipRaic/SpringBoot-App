package hr.tvz.raic.hardwareapp.controller;

import hr.tvz.raic.hardwareapp.model.Review;
import hr.tvz.raic.hardwareapp.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("review")
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping(value = "{code}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Review> getHardware(@PathVariable("code") String hardwareCode) {
        return reviewService.getReviewsByHardwareCode(hardwareCode);
    }

    @GetMapping(value = "/byText/{title}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Review getReview(@PathVariable("title") String title) {
        return reviewService.getReviewByText(title);
    }
}
