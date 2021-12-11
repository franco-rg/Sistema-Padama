package edu.pe.idat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Servicio_Reserva {
	
	@Id
	private String idr_x_s;
	
	
	@Column(name = "nombreservicio")
	private String nombreservicio;
	
	@Column(name ="precio")
	private Double precio;

	public String getIdr_x_s() {
		return idr_x_s;
	}

	public void setIdr_x_s(String idr_x_s) {
		this.idr_x_s = idr_x_s;
	}

	public String getNombreservicio() {
		return nombreservicio;
	}

	public void setNombreservicio(String nombreservicio) {
		this.nombreservicio = nombreservicio;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	
	
}









