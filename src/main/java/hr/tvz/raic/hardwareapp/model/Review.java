package hr.tvz.raic.hardwareapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Review {
    @Id
    private Long id;
    private String title;
    private String text;
    private Integer rating;
}
