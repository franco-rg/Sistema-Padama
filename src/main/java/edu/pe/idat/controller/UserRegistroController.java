package edu.pe.idat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import proyecto.idat.dto.UserRegistration;
import edu.pe.idat.service.UserService;

@Controller
@RequestMapping("/registro")
public class UserRegistroController {
	private UserService userService;

	public UserRegistroController(UserService userService) {
		super();
		this.userService = userService;
	}

	@ModelAttribute("user")
    public UserRegistration userRegistration() {
        return new UserRegistration();
    }
	
	@GetMapping
	public String showRegistrationForm() {
		return "registro";
	}
	
	@PostMapping()
	public String registerUserAccount(@ModelAttribute("user") UserRegistration registration) {
		userService.save(registration);
		return "index";
	}

}
