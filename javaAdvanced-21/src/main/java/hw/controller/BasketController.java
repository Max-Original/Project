package hw.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import hw.domain.Basket;
import hw.domain.Product;
import hw.domain.User;
import hw.service.BasketService;
import hw.service.ProductService;
import hw.service.UserService;

@Controller
public class BasketController {

	@Autowired
	private BasketService basketService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	
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
	  
	  private ModelAndView getBasketItems() {
		  ModelAndView map = new ModelAndView("basket");
	    	map.addObject("basketItems",basketService.getAll());
	    	
	        return map; 
		 
	  }


}

