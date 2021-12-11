package edu.pe.idat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.model.Servicio_Reserva;
import edu.pe.idat.repository.Servicio_Reserva_Repository;

@Service
public class Servicio_Reserva_Service {
	
	@Autowired
	private Servicio_Reserva_Repository repositorio;

	// BUSCAR RESERVA
	public List<Servicio_Reserva> buscar_reserva_servicio(String idrese){
		
		List<Servicio_Reserva> lista_temporada = new ArrayList<Servicio_Reserva>();
		lista_temporada = repositorio.buscar_reserva(idrese);
		
		for (Servicio_Reserva tempo : lista_temporada) {
			System.out.println(tempo.getNombreservicio());
		}
		
		
		return repositorio.buscar_reserva(idrese);
	}
	
	
}
