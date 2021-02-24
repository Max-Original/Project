package hw.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hw.dao.ProductRepo;
import hw.domain.Product;

@Service
public class ProductService {

	private Logger logger = LoggerFactory.getLogger(BasketService.class);
	
	@Autowired
	private ProductRepo productRepo;
	
	public Product save(Product product) {
		logger.info("saved: " + product);
	return productRepo.save(product);
	}
	
	
	public List<Product>  getAllProduct(){
		logger.info("Showing all products");
		return productRepo.findAll();
	}	
	
	public Product findById(Integer id) {
		
		logger.info("Getting product with: " + id);
		return productRepo.findById(id).get();
	}
}
