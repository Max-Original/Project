package hw.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hw.domain.User;

public interface UserRepo extends JpaRepository<User, Long>{

	Optional<User> findByEmail(String email);
}
