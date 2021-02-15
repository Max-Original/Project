package hw.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Basket {

	private Long id;
	private Integer userId;
	private Integer productId;
	private Date purchaseDate;

	public Basket() {
		super();
	}

	public Basket(Integer userId, Integer productId, Date purchaseDate) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.purchaseDate = purchaseDate;
	}

}
