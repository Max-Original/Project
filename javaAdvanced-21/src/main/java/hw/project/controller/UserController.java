package hw.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import hw.project.domain.User;
import hw.project.service.ProductService;
import hw.project.service.UserService;

@Controller
public class UserController {

	@Autowired
	private ProductService productService;

	@Autowired
	private UserService userService;


	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {

		model.addAttribute("userForm", new User());

		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

	@PostMapping(value = "/")
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "redirect:/login#";
		}
		
		userService.save(userForm);
		
		return "redirect:/home";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView welcome() {

		ModelAndView map = new ModelAndView();
		map.addObject("products", productService.getAllProduct());

		return map;
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)	
	private ModelAndView getallUsers() {
		return getUsers();
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	private ModelAndView delete(@RequestParam String id) {
		userService.delete(new User(Integer.parseInt(id.replaceAll("\\s",""))));	
		return getUsers();
	}
	
	
	
	
	private ModelAndView getUsers() {
		ModelAndView map = new ModelAndView("user");
		map.addObject("users", userService.getAllUsers());
		return map;
	}
	
	
}
