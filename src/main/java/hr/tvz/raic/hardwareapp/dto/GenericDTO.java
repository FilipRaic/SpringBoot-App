package hr.tvz.raic.hardwareapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class GenericDTO implements Serializable {
    @NonNull
    private String name;
}
