package hw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hw.dao.BasketRepo;
import hw.domain.Basket;

@Service
public class BasketService {

	@Autowired
	private BasketRepo basketRepo;
	
	public List<Basket> getAll(){
		return basketRepo.findAll();
	}	
	
	public void delete(Basket basket) {
		basketRepo.delete(basket);
	}
	
	public Basket add(Basket basket) {
		return basketRepo.save(basket);
	}
}
