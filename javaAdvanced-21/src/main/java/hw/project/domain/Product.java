package hw.project.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@Column
	private Integer amount;
	
	@Column
	private Double price;
	

    @Lob
	private String encoded_image;
	
	public Product() {
		super();
	}
	
	public Product(Integer id) {
		this.id = id;
	}

	public Product(String name, String description, Double price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}

}
