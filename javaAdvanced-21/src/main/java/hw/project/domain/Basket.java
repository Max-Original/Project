package hw.project.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "basket")

public class Basket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne(targetEntity = hw.project.domain.User.class)
	@JoinColumn(name = "user_id",referencedColumnName = "id")
	private User user;
	
	@ManyToOne(targetEntity = hw.project.domain.Product.class)
	@JoinColumn(name = "product_id", referencedColumnName ="id")
	private Product product;
	
	@Column
	private Date purchase_date;

	public Basket() {
		super();
	}
	
	public Basket(Integer id) {
		this.id = id;
	}
	

	public Basket(User user, Product product, Date purchaseDate) {
		super();
		this.user = user;
		this.product = product;
		this.purchase_date = purchaseDate;
	}

}
