package hr.tvz.raic.hardwareapp.dto;

import hr.tvz.raic.hardwareapp.model.Review;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class ReviewDTO {
    private String title;
    private String text;
    private Integer rating;

    public ReviewDTO(Review review) {
        this.title = review.getTitle();
        this.text = review.getText();
        this.rating = review.getRating();
    }
}
