package edu.pe.idat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.model.Pago_Reserva;
import edu.pe.idat.repository.Pago_Reserva_Repository;

@Service
public class Pago_Reserva_Service {
	
	@Autowired
	private Pago_Reserva_Repository repositorio;

	// BUSCAR RESERVA
	public Pago_Reserva buscar_reserva(String idrese){
		return repositorio.buscar_reserva(idrese);
	}
	
	
}
