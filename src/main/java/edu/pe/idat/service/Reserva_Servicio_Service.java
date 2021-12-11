package edu.pe.idat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import edu.pe.idat.model.Reserva_Servicio;
import edu.pe.idat.model.Temporada;
import edu.pe.idat.repository.Reserva_Servicio_Repository;

@Service
public class Reserva_Servicio_Service {
	
	@Autowired
	private Reserva_Servicio_Repository rese_servi_repos;
	
	public void registrarReserva_Servicio(Reserva_Servicio reserva_Servicio) {
		
		rese_servi_repos.registrar_reserva_servicio(reserva_Servicio.getIdreserva(), reserva_Servicio.getIdservicios());
	}
	
	public String generarID_Rese_Serv() {
		
		
		
		return "null";
		
		
		
		
		
		
		
	}
	
	
	public List<Reserva_Servicio> listar_rxs_idrese(String id) {
		return rese_servi_repos.listar_rxs_idrese(id);
	}
	
	public void actualizar_reserva_servicio(int idrxs, String idrese, String idserv) {
		rese_servi_repos.actualizar_reserva_servicio(idrxs, idrese, idserv);
	}
	
	public void eliminar_reserva_servicio(int id){
		rese_servi_repos.eliminar_reserva_servicio(id);
	}
	
}
