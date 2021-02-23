package hw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hw.dao.ProductRepo;
import hw.domain.Product;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	public Product save(Product product) {
	return productRepo.save(product);
	}
	
	
	public List<Product>  getAllProduct(){
		return productRepo.findAll();
	}	
	
	public Product findById(Integer id) {
		return productRepo.findById(id).get();
	}
}
