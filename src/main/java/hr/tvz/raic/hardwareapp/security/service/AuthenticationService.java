package hr.tvz.raic.hardwareapp.security.service;

import hr.tvz.raic.hardwareapp.security.command.LoginCommand;
import hr.tvz.raic.hardwareapp.security.dto.LoginDTO;

import java.util.Optional;

public interface AuthenticationService {

    Optional<LoginDTO> login(LoginCommand command);

}
