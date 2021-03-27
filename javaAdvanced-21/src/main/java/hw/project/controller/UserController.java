package hw.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

	@GetMapping(value = { "/", "/login" }) 
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
			return "redirect:/login";
		}
		
		userService.save(userForm);
		
		return "redirect:/home";
	}

	@PostMapping(value = "/editRole")
	public String changeRole(@RequestParam int userId, @RequestParam String role) {

		userService.updateUserRole(userId, role);
		
		return "redirect:/user";
	}
	
	@GetMapping(value = "/home")
	public ModelAndView welcome() {

		ModelAndView map = new ModelAndView();
		map.addObject("products", productService.getAllProduct());

		return map;
	}
	
	@GetMapping(value = "/user")	
	private ModelAndView getallUsers() {
		return getUsers();
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PostMapping(value = "/changeStatus", produces = "application/json")	
	public String changeStatus(@RequestParam(value = "param", required = true) String id) {
		System.out.println("IT WORKSSSSSSSSSSSSSSSSSSSSSSSSSSSSS"+ id);
		return null;
	}
	
	@GetMapping(value = "/remove")
	private ModelAndView delete(@RequestParam String id) {
		userService.delete(new User(Integer.parseInt(id.replaceAll("\\s",""))));	
		return getUsers();
	}
	
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/login") public Boolean
	 * checkEmail(@PathVariable("user_e") String user_e) { Boolean validEmail =
	 * userService.checkByEmail(user_e); return validEmail; }
	 */
	
	private ModelAndView getUsers() {
		ModelAndView map = new ModelAndView("user");
		map.addObject("users", userService.getAllUsers());
		return map;
	}
	
	
}
