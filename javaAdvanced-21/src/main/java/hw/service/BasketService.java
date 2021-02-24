package hw.service;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;

import hw.dao.BasketRepo;
import hw.domain.Basket;

@Service
public class BasketService {

	private Logger logger = LoggerFactory.getLogger(BasketService.class);
	
	@Autowired
	private BasketRepo basketRepo;
	
	public List<Basket> getAll(){
		logger.info("Get all basket items");
		return basketRepo.findAll();
	}	
	
	public void delete(Basket basket) {
		
		logger.info("Delete basket" + basket );
		basketRepo.delete(basket);
	}
	
	public Basket add(Basket basket) {
		
		logger.info("Save basket" + basket );
		return basketRepo.save(basket);
	}
}
