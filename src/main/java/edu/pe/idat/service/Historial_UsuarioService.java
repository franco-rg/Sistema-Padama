package edu.pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.model.Habitacion;
import edu.pe.idat.model.Historial_Usuario;
import edu.pe.idat.repository.HabitacionRepository;
import edu.pe.idat.repository.Historial_ReservaRespository;

@Service
public class Historial_UsuarioService {

	
	
	@Autowired
	private Historial_ReservaRespository repository_HCRUD;
		
	public List<Historial_Usuario>  listar_historial(String usernombre) {
		
		return repository_HCRUD.listar_reservas(usernombre);
		
	}
	
	
	
	
	
}
