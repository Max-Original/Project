package hw.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
	private Long id;
	private String name;
	private String description;
	private Double price;

	public Product() {
		super();
	}

	public Product(String name, String description, Double price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}

}
