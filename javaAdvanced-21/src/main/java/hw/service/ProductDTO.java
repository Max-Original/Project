package hw.service;

import java.io.IOException;
import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

import hw.domain.Product;

public class ProductDTO {

	public static Product createEntity(String name, String description, Double price, MultipartFile image) throws IOException {
		
		Product product = new Product();
		product.setName(name);
		product.setDescription(description);
		product.setPrice(price);
		product.setEncoded_image(Base64.getEncoder().encodeToString(image.getBytes()));
		
		return product;
		
	}
}
