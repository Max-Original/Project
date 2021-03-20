package hw.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hw.project.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public ModelAndView getAllOrders() {

		return getOrders();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	private ModelAndView getOrders() {
		ModelAndView map = new ModelAndView("order");
		map.addObject("orders", orderService.getAll());
		return map;
	}
}
