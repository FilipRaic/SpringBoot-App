package hr.tvz.raic.hardwareapp.security.repository;

import hr.tvz.raic.hardwareapp.security.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
