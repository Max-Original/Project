package hw.domain;

import java.sql.Date;

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
	
	@ManyToOne(targetEntity = hw.domain.User.class)
	@JoinColumn(name = "user_id",referencedColumnName = "id")
	private Integer user_id;
	
	@ManyToOne(targetEntity = hw.domain.Product.class)
	@JoinColumn(name = "product_id", referencedColumnName ="id")
	private Integer product_id;
	
	@Column
	private Date purchase_date;

	public Basket() {
		super();
	}

	public Basket(Integer userId, Integer productId, Date purchaseDate) {
		super();
		this.user_id = userId;
		this.product_id = productId;
		this.purchase_date = purchaseDate;
	}

}
