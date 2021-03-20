package hw.project.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	
	@Column
	private String email;
	
	@Column
	private String first_name;
	
	@Column

	private String last_name;
	
	@Column
	private String password;
	
	@Column
	private String password_confirm;
	
	@Enumerated(EnumType.STRING)
	private UserRole role;
	
	
	public User() {
		super();
	}
	
	
	
	public User(String email, String first_name, String last_name, String password, UserRole role) {
		super();
		this.email = email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.password = password;
		this.role = role;
	}


	public User(User user) {
		super();
		this.id = user.id;
		this.email = user.email;
		this.first_name = user.first_name;
		this.last_name = user.last_name;
		this.password = user.password;
		this.role = user.role;
	}



	public User(Integer id) {
		super();
		this.id = id;
	}
	



}
