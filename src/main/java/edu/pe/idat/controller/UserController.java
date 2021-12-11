package edu.pe.idat.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import edu.pe.idat.model.User;
import edu.pe.idat.repository.RoleRepository;
import edu.pe.idat.service.UserService;
import edu.pe.idat.service.UserServiceImpl;
import proyecto.idat.dto.ChangePasswordForm;
import proyecto.idat.dto.UsuarioRegistro;

@Controller
public class UserController {
	private void baseAttributerForUserForm(Model model, User user) {
		model.addAttribute("user", user);
		model.addAttribute("usuarios", userService.getAllUsers());
		model.addAttribute("roles", roleRepository.findAll());
	}
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@Autowired
	private UserService userService;

	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserServiceImpl userServiceI;

	@GetMapping("/usuarios")
	public String ListarUsuarios(Model model) {

		model.addAttribute("usuarios", userServiceI.listar_usuarios());
		// model.addAttribute("userList", userService.getAllUsers());
		return "usuarios";
	}

	@ModelAttribute("user")
	public UsuarioRegistro usuarioRegistro() {
		return new UsuarioRegistro();
	}

	@GetMapping("/usuario_registro")
	public String RegistrationForm() {
		return "usuario_registro";
	}

	@PostMapping("/usuario_registro")
	public String registerUser(@ModelAttribute("user") UsuarioRegistro registro,Model model) {
		userService.registro(registro);
		model.addAttribute("usuarios", userServiceI.listar_usuarios());
		return "usuarios";
	}

	@GetMapping("/editUser/{id}")
	public String getEditUserForm(Model model, @PathVariable(name = "id") Long id) throws Exception {

		User userToEdit = userService.getUserById(id);
		baseAttributerForUserForm(model, userToEdit);
		model.addAttribute("editMode", "true");

		model.addAttribute("passwordForm", new ChangePasswordForm(id));

		return "registrar_usuario";
	}

	@PostMapping("/editUser")
	public String postEditUserForm(@Validated @ModelAttribute("userForm") User user, BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			baseAttributerForUserForm(model, user);
			model.addAttribute("editMode", "true");
			model.addAttribute("passwordForm", new ChangePasswordForm(user.getId()));
		} else {
			try {
				userService.updateUser(user);
				baseAttributerForUserForm(model, new User());
			} catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				baseAttributerForUserForm(model, user);
				model.addAttribute("editMode", "true");
				model.addAttribute("passwordForm", new ChangePasswordForm(user.getId()));
			}
		}
		model.addAttribute("usuarios", userServiceI.listar_usuarios());
		return "usuarios";

	}

}