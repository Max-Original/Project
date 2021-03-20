package hw.project.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hw.project.dao.OrderRepo;
import hw.project.domain.Order;



@Service
public class OrderService {

	private Logger logger = LoggerFactory.getLogger(OrderService.class);
	
	@Autowired
	private OrderRepo orderRepo;
	
	public List<Order> getAll(){
		logger.info("returning all Orders from DB");
		return orderRepo.findAll();
	}

public Order add(Order order) {
		
		logger.info("Save basket" + order );
		return orderRepo.save(order);
	}
}
