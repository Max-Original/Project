package hw.security;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hw.dao.UserRepo;
import hw.domain.User;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Optional<hw.domain.User> userOptional = userRepo.findByEmail(email);
		
		if(userOptional.isPresent()) {
			User user = userOptional.get();
			return new CustomUserDetails(user, Collections.singletonList(user.getRole().toString()));
		}
		throw new UsernameNotFoundException("User with this email doesnt exits" + email);
	}

	
	
}
