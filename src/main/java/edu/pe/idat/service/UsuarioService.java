package edu.pe.idat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.model.User;
import edu.pe.idat.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository userrepos;
	
	public User buscar_usuario(String id) {
		return userrepos.buscar_usuario_id(id);
	}
}
