package hr.tvz.raic.hardwareapp.model;

import hr.tvz.raic.hardwareapp.command.HardwareCommand;
import hr.tvz.raic.hardwareapp.enums.HardwareTypeConst;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Hardware {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    private String name;
    private String code;
    private Double price;
    private HardwareTypeConst type;
    private Integer amountAvailable;

    public Hardware(HardwareCommand hardwareCommand) {
        this.name = hardwareCommand.getName();
        this.code = hardwareCommand.getCode();
        this.price = hardwareCommand.getPrice();
        this.type = HardwareTypeConst.getTypeFromString(hardwareCommand.getType());
        this.amountAvailable = hardwareCommand.getAmount();
    }
}
