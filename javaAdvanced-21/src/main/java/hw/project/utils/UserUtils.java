package hw.project.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import hw.project.domain.User;
import hw.project.service.UserService;

@Component
public class UserUtils {

	@Autowired
	private UserService userService;
	
	public User getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		User UserEmail = userService.findByEmail(currentPrincipalName);
		return UserEmail;
		
	}
	
}
