package hr.tvz.raic.hardwareapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    private String title;
    private String text;
    private Integer rating;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hardwareId")
    private Hardware hardwares;
}
