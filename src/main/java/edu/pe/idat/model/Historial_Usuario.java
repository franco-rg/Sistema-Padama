package edu.pe.idat.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Historial_Usuario {
	
	@Id
	private String idreserva;

	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name ="fechaentrada")
	private LocalDate fechaentrada;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name ="fechasalida")
	private LocalDate fechasalida;
	
	@Column(name ="idhabitacion")
	private String idhabitacion;
	
	@Column(name ="numpiso")
	private String numpiso;
	
	@Column(name ="noche_reserva")
	private int noche_reserva;
	

	
	@Column(name ="estado_reserva")
	private String estado_reserva;

	public String getIdreserva() {
		return idreserva;
	}

	public void setIdreserva(String idreserva) {
		this.idreserva = idreserva;
	}

	public LocalDate getFechaentrada() {
		return fechaentrada;
	}

	public void setFechaentrada(LocalDate fechaentrada) {
		this.fechaentrada = fechaentrada;
	}

	public LocalDate getFechasalida() {
		return fechasalida;
	}

	public void setFechasalida(LocalDate fechasalida) {
		this.fechasalida = fechasalida;
	}

	public String getIdhabitacion() {
		return idhabitacion;
	}

	public void setIdhabitacion(String idhabitacion) {
		this.idhabitacion = idhabitacion;
	}

	public String getNumpiso() {
		return numpiso;
	}

	public void setNumpiso(String numpiso) {
		this.numpiso = numpiso;
	}

	public int getNoche_reserva() {
		return noche_reserva;
	}

	public void setNoche_reserva(int noche_reserva) {
		this.noche_reserva = noche_reserva;
	}


	public String getEstado_reserva() {
		return estado_reserva;
	}

	public void setEstado_reserva(String estado_reserva) {
		this.estado_reserva = estado_reserva;
	}
	



	
	
	

}