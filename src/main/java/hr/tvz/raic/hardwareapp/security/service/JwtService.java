package hr.tvz.raic.hardwareapp.security.service;

import hr.tvz.raic.hardwareapp.security.domain.User;

public interface JwtService {

    boolean authenticate(String token);

    String createJwt(User user);

}
