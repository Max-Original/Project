package hw.dao;

import java.util.List;

import javax.swing.Spring;

import org.springframework.data.jpa.repository.JpaRepository;

import hw.domain.User;

public interface UserRepo extends JpaRepository<User, Long>{

	List<User> findByEmail(Spring email);
}
