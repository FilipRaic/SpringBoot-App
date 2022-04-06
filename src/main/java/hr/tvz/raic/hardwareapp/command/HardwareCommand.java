package hr.tvz.raic.hardwareapp.command;

import hr.tvz.raic.hardwareapp.enums.HardwareTypeConst;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HardwareCommand {
    @NotNull(message = "Name must be enetered.")
    @NotBlank(message = "Name must be enetered.")
    @Length(max = 255, message = "Name can not be longer then 255 characters.")
    private String name;

    @NotNull(message = "Code must be entered.")
    @NotBlank(message = "Code must be entered.")
    @Length(max = 64, message = "Code can not be longer then 64 characters.")
    private String code;

    @NotNull(message = "Price must be entered.")
    @Max(value = 9999999, message = "Price can not be greater then 9999999.")
    @PositiveOrZero(message = "Price must me a positive number.")
    private Double price;

    @NotNull(message = "Type must be entered.")
    private HardwareTypeConst type;

    @NotNull(message = "Amount available must be entered.")
    @Max(value = 9999999, message = "Amount available can not be greater then 9999999.")
    @PositiveOrZero(message = "Amount available must be a positive number.")
    private Integer amountAvailable;
}
