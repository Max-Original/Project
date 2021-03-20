package hw.project.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import hw.project.domain.Basket;
import hw.project.domain.Order;
import hw.project.domain.Product;
import hw.project.domain.User;
import hw.project.service.BasketService;
import hw.project.service.OrderService;
import hw.project.service.ProductService;
import hw.project.service.UserService;

@Controller
public class BasketController {

	@Autowired
	private BasketService basketService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderService orderService;
	
	  @RequestMapping(value ="/baskets", method = RequestMethod.GET)
	    public ModelAndView getAllItems() {
	    	
	    	return getBasketItems();
	    }
	  
	  @RequestMapping(value ="/basket", method = RequestMethod.POST)
	    public ModelAndView create(@RequestParam String productId) {
	    	
		  Product product = productService.findById(Integer.parseInt(productId));
		  
		  Basket basket = new Basket();
		  basket.setProduct(product);
		  basket.setPurchase_date(new Date());
		  
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String userEmail = auth.getName();
			User user = userService.findByEmail(userEmail);
			
			basket.setUser(user);
			
			basketService.add(basket);
			return getBasketItems();
	    }
	  
	  @RequestMapping(value ="/basket", method = RequestMethod.GET)
	    public ModelAndView delete(@RequestParam String id) {

		  basketService.delete(new Basket(Integer.parseInt(id.replaceAll("\\s",""))));
		  
	    	return getBasketItems();
	    }
	  
	  @RequestMapping(value = "/confirm", method = RequestMethod.GET)
	  public ModelAndView confirm(@RequestParam String id) {
		
		  Basket basket = basketService.findById(Integer.parseInt(id.replaceAll("\\s","")));
		 
//		  List<Basket> all = basketService.getAll();
//		 Basket basket = all.get(Integer.parseInt(id));
		 
		  Order order = new Order();
		  order.setProduct(basket.getProduct());
		  order.setUser(basket.getUser());
//		  order.setPurchase_date(new Date());
//		  
		  orderService.add(order);
		  
//		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		  String userEmail = auth.getName();
//		  User user = userService.findByEmail(userEmail);
//			
//		  order.setUser(user);
//		  
//		  orderService.add(order);
		  
		  delete(id);
		  return getBasketItems();
		  
	  }
	  
	  private ModelAndView getBasketItems() {
		  ModelAndView map = new ModelAndView("basket");
	    	map.addObject("basketItems",basketService.getAll());
	    	
	        return map; 
		 
	  }


}

