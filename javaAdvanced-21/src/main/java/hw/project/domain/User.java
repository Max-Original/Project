package hw.project.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Table(name = "user")
@Data
@AllArgsConstructor

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private String passwordConfirm;
	
	@Enumerated(EnumType.STRING)
	private UserRole role;
	
	
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
	
	public User(User user) {
		this.id = user.id;
		this.email = user.email;
		this.firstName = user.firstName;
		this.lastName = user.lastName;
		this.role = user.role;
		this.password = user.password;
	}
	
}
