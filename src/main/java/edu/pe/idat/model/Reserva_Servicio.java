package edu.pe.idat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Reserva_Servicio {
	@Id
	private int idr_x_s;
	
	@Column(name="idreserva")
	private String idreserva;
	
	@Column(name="idservicios")
	private String idservicios;
	
	@Column(name="nombreservicio")
	private String nombreservicio;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="precio")
	private Double precio;
	
	
	
	
	public String getNombreservicio() {
		return nombreservicio;
	}

	public void setNombreservicio(String nombreservicio) {
		this.nombreservicio = nombreservicio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public int getIdr_x_s() {
		return idr_x_s;
	}

	public void setIdr_x_s(int idr_x_s) {
		this.idr_x_s = idr_x_s;
	}

	public String getIdreserva() {
		return idreserva;
	}

	public void setIdreserva(String idreserva) {
		this.idreserva = idreserva;
	}

	public String getIdservicios() {
		return idservicios;
	}

	public void setIdservicios(String idservicios) {
		this.idservicios = idservicios;
	}

	
	
	

	public Reserva_Servicio(int idr_x_s, String idreserva, String idservicios) {
		super();
		this.idr_x_s = idr_x_s;
		this.idreserva = idreserva;
		this.idservicios = idservicios;
	}

	public Reserva_Servicio(String idreservas, String idservicios) {
		super();
		this.idreserva = idreservas;
		this.idservicios = idservicios;
	}

	public Reserva_Servicio() {
		super();
		// TODO Auto-generated constructor stub
	}

}
