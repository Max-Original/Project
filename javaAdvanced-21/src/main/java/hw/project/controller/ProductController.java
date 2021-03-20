package hw.project.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import hw.project.domain.Product;
import hw.project.service.ProductDTO;
import hw.project.service.ProductService;



@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "addProduct", method = RequestMethod.POST)
	public ModelAndView createProduct(
			@RequestParam String name, 
			@RequestParam String description, 
			@RequestParam Double price, 
			@RequestParam Integer amount,
			@RequestParam MultipartFile image) throws IOException {
	
		if(image.isEmpty()) {
			
		    File uploadFile = new File("src/main/webapp/images/default.jpg");
		    FileInputStream is =  new FileInputStream(uploadFile);
		    MultipartFile multipartFile = new MockMultipartFile("default.jpg", "default.jpg", "image/jpeg", IOUtils.toByteArray(is));
		    
			productService.save(ProductDTO.createEntity(name, description, price, multipartFile, amount));
		}else {
	productService.save(ProductDTO.createEntity(name, description, price, image, amount));
		}
		return new ModelAndView("redirect:/home");
		
	}
	
	 @RequestMapping(value ="/product", method = RequestMethod.GET)
	    public ModelAndView delete(@RequestParam String productId) {

		  productService.delete(new Product(Integer.parseInt(productId.replaceAll("\\s",""))));
		  
		  return new ModelAndView("redirect:/home");
	    }
	
	
	@RequestMapping(value ="/create-product", method = RequestMethod.GET)
    public String createProduct() {
    return "createProduct";
    }
}
