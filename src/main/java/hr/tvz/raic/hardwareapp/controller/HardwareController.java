package hr.tvz.raic.hardwareapp.controller;

import hr.tvz.raic.hardwareapp.command.HardwareCommand;
import hr.tvz.raic.hardwareapp.dto.HardwareDTO;
import hr.tvz.raic.hardwareapp.service.HardwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("hardware")
@CrossOrigin(origins = "http://localhost:4200")
public class HardwareController {
    @Autowired
    private HardwareService hardwareService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<HardwareDTO> getHardwareList() {
        return hardwareService.getAllHardware();
    }

    @GetMapping(value = "{code}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public HardwareDTO getHardware(@PathVariable("code") String hardwareCode) {
        return hardwareService.getHardwareByCode(hardwareCode).get().stream().findFirst().get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<HardwareDTO> createHardware(@Valid @RequestBody final HardwareCommand hardwareCommand) {
        return hardwareService.create(hardwareCommand);
    }

    @PutMapping(value = "/{code}")
    @ResponseBody
    public HardwareDTO updateHardware(@PathVariable("code") String hardwareCode, @RequestBody HardwareCommand hardwareCommand) {
        return hardwareService.update(hardwareCode, hardwareCommand);
    }

    @DeleteMapping(value = "{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void deleteHardware(@PathVariable("code") String hardwareCode) {
        hardwareService.delete(hardwareCode);
    }
}
