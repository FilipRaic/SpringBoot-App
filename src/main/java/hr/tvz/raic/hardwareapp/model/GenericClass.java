package hr.tvz.raic.hardwareapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class GenericClass implements Serializable {
    private String name;
    private String code;
}
