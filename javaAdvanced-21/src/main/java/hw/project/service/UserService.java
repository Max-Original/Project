package hw.project.service;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import hw.project.dao.UserRepo;
import hw.project.domain.User;
import hw.project.domain.UserRole;
import hw.project.domain.UserStatus;

@Service
public class UserService {

	private Logger logger = LoggerFactory.getLogger(BasketService.class);
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRole(UserRole.ROLE_USER);
		user.setStatus(UserStatus.ACTIVE);
		userRepo.save(user);
		logger.info("Saved: " + user);
	
	}
	
	public void updateUserRole(int id,String role) {
		
		User user = userRepo.findById(id).get();
		role.toUpperCase();
		UserRole changeRole = Enum.valueOf(UserRole.class, role);
		/*
		 * if(role.equalsIgnoreCase("ROLE_ADMIN")) { user.setRole(UserRole.ROLE_ADMIN);
		 * }else { user.setRole(UserRole.ROLE_USER); }
		 */
		user.setRole(changeRole);
		userRepo.save(user);
	
	}
	
	public User findByEmail(String email) {
		logger.info("Getting user with an email:" +email);
		return userRepo.findByEmail(email).get();
	}
	
	/*
	 * public Boolean checkByEmail(String email) { Boolean statment = true; User
	 * user_e = findByEmail(email); if(user_e.getEmail().equalsIgnoreCase(email)) {
	 * statment = false; }; logger.info("Showing statment" + statment); return
	 * statment;
	 * 
	 * }
	 */	
	
	public List<User> getAllUsers() {
		return userRepo.findAll();
		
	}
	
	public void delete(User user) {
	userRepo.delete(user);
	}
}
