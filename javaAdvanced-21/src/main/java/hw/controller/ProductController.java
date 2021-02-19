package hw.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import hw.domain.Product;
import hw.service.ProductService;



@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "addProduct", method = RequestMethod.POST)
	public String createProduct(@Valid @ModelAttribute ("product") Product product, BindingResult bindingResult) {
		
	productService.save(product);
		
		return "redirect:home";
		
	}
}
