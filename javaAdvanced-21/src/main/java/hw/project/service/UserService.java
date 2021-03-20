package hw.project.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import hw.project.dao.UserRepo;
import hw.project.domain.User;
import hw.project.domain.UserRole;

@Service
public class UserService {

	private Logger logger = LoggerFactory.getLogger(BasketService.class);
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	
	public void save(User user) {
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword_confirm()));
		user.setRole(UserRole.ROLE_USER);
		userRepo.save(user);
		logger.info("Saved: " + user);
	
	}
	
	public User findByEmail(String email) {
		logger.info("Getting user with an email:" +email);
		return userRepo.findByEmail(email).get();
	}
	
	public List<User> getAllUsers() {
		return userRepo.findAll();
		
	}
	
	public void delete(User user) {
	userRepo.delete(user);
	}
}
