package hw.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import hw.service.ProductDTO;
import hw.service.ProductService;



@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "addProduct", method = RequestMethod.POST)
	public ModelAndView createProduct(
			@RequestParam String name, 
			@RequestParam String description, 
			@RequestParam Double price, 
			@RequestParam MultipartFile image) throws IOException {
		
	productService.save(ProductDTO.createEntity(name, description, price, image ));
		
		return new ModelAndView("redirect:/home");
		
	}
	
	@RequestMapping(value ="/create-product", method = RequestMethod.GET)
    public String createProduct() {
    return "createProduct";
    }
}
