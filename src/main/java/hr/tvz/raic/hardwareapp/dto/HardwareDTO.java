package hr.tvz.raic.hardwareapp.dto;

import hr.tvz.raic.hardwareapp.model.Hardware;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class HardwareDTO extends GenericDTO {
    private Double price;

    public HardwareDTO(Hardware hardware) {
        super(hardware.getCode(), hardware.getName());
        this.price = hardware.getPrice();
    }

    public HardwareDTO(@NonNull String code, @NonNull String name, Double price) {
        super(code, name);
        this.price = price;
    }
}
