package hr.tvz.raic.hardwareapp.model;

import hr.tvz.raic.hardwareapp.command.HardwareCommand;
import hr.tvz.raic.hardwareapp.enums.HardwareTypeConst;
import lombok.*;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Hardware extends GenericClass {
    private Double price;
    private HardwareTypeConst type;
    private Integer amountAvailable;

    public Hardware(String name, String code, Double price, HardwareTypeConst type, Integer amountAvailable) {
        super(name, code);
        this.price = price;
        this.type = type;
        this.amountAvailable = amountAvailable;
    }

    public Hardware(HardwareCommand hardwareCommand) {
        super(hardwareCommand.getName(), hardwareCommand.getCode());
        this.price = hardwareCommand.getPrice();
        this.type = hardwareCommand.getType();
        this.amountAvailable = hardwareCommand.getAmountAvailable();
    }
}
