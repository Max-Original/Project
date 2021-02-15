package hw.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

	private Long id;
	private String email;
	private String firstName;
	private String lastName;
	private UserRole role;
	private String password;
	public User() {
		super();
	}
	public User(String email, String firstName, String lastName, UserRole role, String password) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.password = password;
	}
	
	
}
