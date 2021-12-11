package edu.pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;

import proyecto.idat.dto.ChangePasswordForm;
import proyecto.idat.dto.UserRegistration;
import proyecto.idat.dto.UsuarioRegistro;
import proyecto.idat.response.ResultadoResponse.UsernameOrIdNotFound;
import edu.pe.idat.model.User;

public interface UserService extends UserDetailsService {
	public User save(UserRegistration registration);
	
	public User registro(UsuarioRegistro registro);
	
	public Iterable<User> getAllUsers();
	
	public User createUser(User user) throws Exception;
	
	public User getUserById(Long id) throws Exception;

	public User updateUser(User user) throws Exception;

	public void deleteUser(Long id) throws UsernameOrIdNotFound;

	public User changePassword(ChangePasswordForm form) throws Exception;
}