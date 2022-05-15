package hr.tvz.raic.hardwareapp.model;

import hr.tvz.raic.hardwareapp.command.HardwareCommand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hardware")
public class Hardware {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    private String code;
    private String name;
    private String type;
    private Integer amount;
    private Double price;

    public Hardware(HardwareCommand hardwareCommand) {
        this.name = hardwareCommand.getName();
        this.code = hardwareCommand.getCode();
        this.price = hardwareCommand.getPrice();
        this.type = hardwareCommand.getType();
        //this.type = HardwareTypeConst.getTypeFromString(hardwareCommand.getType());
        this.amount = hardwareCommand.getAmount();
    }
}
