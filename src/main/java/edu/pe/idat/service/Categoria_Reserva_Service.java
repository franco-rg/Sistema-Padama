package edu.pe.idat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.model.Categoria_Reserva;
import edu.pe.idat.repository.Categoria_Reserva_Repository;

@Service
public class Categoria_Reserva_Service {
	
	@Autowired
	private Categoria_Reserva_Repository repositorio;

	// BUSCAR RESERVA
	public Categoria_Reserva buscar_reserva(String idrese){
		return repositorio.buscar_reserva(idrese);
	}
	
	
}
