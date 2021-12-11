package edu.pe.idat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "servicios")
public class Servicio {
	
	@Id
	private String idservicios;
	
	@Column(name ="nombreservicio")
	private String nombreservicio;
	
	@Column(name ="descripcion")
	private String descripcion;
	
	@Column(name ="estado")
	private String estado;
	
	@Column(name ="imagen")
	private String imagen;
	
	@Column(name ="precio")
	private Double precio;

	public String getIdservicios() {
		return idservicios;
	}

	public void setIdservicios(String idservicios) {
		this.idservicios = idservicios;
	}

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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Servicio(String idservicios, String nombreservicio, String descripcion, String estado, String imagen,
			Double precio) {
		super();
		this.idservicios = idservicios;
		this.nombreservicio = nombreservicio;
		this.descripcion = descripcion;
		this.estado = estado;
		this.imagen = imagen;
		this.precio = precio;
	}

	public Servicio(String idservicios, String nombreservicio, String descripcion, String estado, Double precio) {
		super();
		this.idservicios = idservicios;
		this.nombreservicio = nombreservicio;
		this.descripcion = descripcion;
		this.estado = estado;
		this.precio = precio;
	}

	public Servicio(String nombreservicio, String descripcion, String estado, Double precio) {
		super();
		this.nombreservicio = nombreservicio;
		this.descripcion = descripcion;
		this.estado = estado;
		this.precio = precio;
	}

	public Servicio() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	
	

}