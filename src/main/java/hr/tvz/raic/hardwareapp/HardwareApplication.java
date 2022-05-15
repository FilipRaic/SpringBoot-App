package hr.tvz.raic.hardwareapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan
public class HardwareApplication {
    public static void main(String[] args) {
        SpringApplication.run(HardwareApplication.class, args);
    }
}
