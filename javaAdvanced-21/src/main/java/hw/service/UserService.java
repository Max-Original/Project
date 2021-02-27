package hw.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import hw.dao.UserRepo;
import hw.domain.User;
import hw.domain.UserRole;

@Service
public class UserService {

	private Logger logger = LoggerFactory.getLogger(BasketService.class);
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	
	public void save(User user) {
		
		logger.info("Saved: " + user);
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setPassword(bCryptPasswordEncoder.encode(user.getPasswordConfirm()));
		user.setRole(UserRole.ROLE_USER);
		userRepo.save(user);
	}
	
	public User findByEmail(String email) {
		logger.info("Getting user with an email:" +email);
		return userRepo.findByEmail(email).get();
	}
}
