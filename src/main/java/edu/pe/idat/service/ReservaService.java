package edu.pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.model.Categoria;
import edu.pe.idat.model.Habitacion;
import edu.pe.idat.model.Reservas;
import edu.pe.idat.model.Temporada;
import edu.pe.idat.repository.ReservaRepository;

@Service
public class ReservaService {
	
	@Autowired
	private ReservaRepository reposReservaRepository;
	
	public List<Reservas> listar_Reservas(){
		return reposReservaRepository.listar_reserva();
	}
	
	public void registrarReserva(Reservas reserva, String id, Long idusuario){
		
		reposReservaRepository.registrarReserva(id, reserva.getFechaentrada(), reserva.getFechasalida(), reserva.getNombreuser(), reserva.getApellidouser(), reserva.getCorreouser(), reserva.getTelefonouser(), reserva.getIdhabitacion(), idusuario, "No confirmado" , reserva.getNoche_reserva());
	}
	
	public String generarID_Rese() {
		return reposReservaRepository.generarID_Reserva();
	}
		
	
	// ACTUALIZAR RESERVA
	public void actualizarReserva(Reservas reservas,String id){
		reposReservaRepository.actualizarReserva(reservas.getIdreserva(), reservas.getFechaentrada(), reservas.getFechasalida(), reservas.getNombreuser(), reservas.getApellidouser(), reservas.getCorreouser(), reservas.getTelefonouser(), id, reservas.getIdusuario(), "No confirmado", reservas.getNoche_reserva());
	}
	
	public void actualizarReserva_sin_habitacion(Reservas reservas){
		reposReservaRepository.actualizarReserva(reservas.getIdreserva(), reservas.getFechaentrada(), reservas.getFechasalida(), reservas.getNombreuser(), reservas.getApellidouser(), reservas.getCorreouser(), reservas.getTelefonouser(), reservas.getIdhabitacion(), reservas.getIdusuario(), "No confirmado", reservas.getNoche_reserva());
	}
	
	// BUSCAR RESERVA
	public Reservas buscar_reserva(String idrese){
		return reposReservaRepository.buscar_reserva(idrese);
	}
	
	
}
