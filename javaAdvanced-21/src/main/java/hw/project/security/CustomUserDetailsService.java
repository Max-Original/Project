package hw.project.security;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hw.project.dao.UserRepo;
import hw.project.domain.User;
import hw.project.domain.UserStatus;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Optional<hw.project.domain.User> userOptional = userRepo.findByEmail(email);

		if (userOptional.isPresent()) {
			User user = userOptional.get();
			if(user.getStatus() == UserStatus.ACTIVE) {
			return new CustomUserDetails(user, Collections.singletonList(user.getRole().toString()));
			}
		}
		throw new UsernameNotFoundException("User with this email doesnt exits" + email);
	}

	
	/*
	 * public Boolean loadUserByUserUmail(String email) {
	 * 
	 * Optional<User> findByEmail = userRepo.findByEmail(email);
	 * 
	 * Boolean statment = true;
	 * 
	 * if (findByEmail.isPresent()) {
	 * 
	 * statment = false;
	 * 
	 * }
	 * 
	 * return statment; }
	 */
	 
}
