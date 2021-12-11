package edu.pe.idat.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.pe.idat.repository.UserRepository;
import edu.pe.idat.model.Role;
import edu.pe.idat.model.User;
import proyecto.idat.dto.ChangePasswordForm;
import proyecto.idat.dto.UserRegistration;
import proyecto.idat.dto.UsuarioRegistro;
import proyecto.idat.response.ResultadoResponse.CustomeFieldValidationException;
import proyecto.idat.response.ResultadoResponse.UsernameOrIdNotFound;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public List<User> listar_usuarios() {
		return userRepository.listar_usuario();
	}

	@Override
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User save(UserRegistration registration) {
		User user = new User(registration.getNombre(), registration.getApellidos(), registration.getNum_docu(),
				registration.getTelefono(), registration.getUsername(),
				passwordEncoder.encode(registration.getPassword()), Arrays.asList(new Role("ROLE_USER")));

		return userRepository.save(user);
	}

	@Override
	public User registro(UsuarioRegistro registro) {
		User user = new User(registro.getNombre(), registro.getApellidos(), registro.getNum_docu(),
				registro.getTelefono(), registro.getUsername(),
				passwordEncoder.encode(registro.getPassword()), Arrays.asList(new Role("ROLE_ADMIN")));
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("No existe usuario"));
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}

	/*
	 * public List<User> listar_usuarioA(){ return userRepository.listar_usuarioA();
	 * }
	 */
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(rol -> new SimpleGrantedAuthority(rol.getNombre())).collect(Collectors.toList());
	}

	protected void mapUser(User from, User to) {
		to.setNombre(from.getNombre());
		to.setApellidos(from.getApellidos());
		to.setUsername(from.getUsername());
		to.setNum_docu(from.getNum_docu());
		to.setTelefono(from.getTelefono());
		to.setRoles(from.getRoles());
	}

	@Override
	public User updateUser(User user) throws Exception {
		User toUser = getUserById(user.getId());
		mapUser(user, toUser);
		return userRepository.save(toUser);
	}

	@Override
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public void deleteUser(Long id) throws UsernameOrIdNotFound {
		User user;
		try {
			user = getUserById(id);
			userRepository.delete(user);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public User changePassword(ChangePasswordForm form) throws Exception {
		User user = getUserById(form.getId());

		if (user.getPassword().equals(form.getNewPassword())) {
			throw new Exception("Nuevo debe ser diferente al password actual.");
		}

		if (!form.getNewPassword().equals(form.getConfirmPassword())) {
			throw new Exception("Nuevo Password y Confirm Password no coinciden.");
		}

		String encodePassword = passwordEncoder.encode(form.getNewPassword());
		user.setPassword(encodePassword);
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long id) throws Exception {
		return userRepository.findById(id).orElseThrow(() -> new UsernameOrIdNotFound("El id del usuario no existe"));

	}

	private boolean checkUsernameAvailable(User user) throws Exception {
		Optional<User> userFound = userRepository.findByUsername(user.getUsername());
		if (userFound.isPresent()) {
			throw new CustomeFieldValidationException("Username no disponible", "username");
		}
		return true;
	}

	@Override
	public User createUser(User user) throws Exception {
		if (checkUsernameAvailable(user)) {
			String encodedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
			Arrays.asList(new Role("ROLE_ADMIN"));
			user = userRepository.save(user);
		}
		return user;
	}

}
