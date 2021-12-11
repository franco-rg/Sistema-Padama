package edu.pe.idat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Habitacion_ListarCate {
	@Id
	private String idhabitacion;
	
	@Column(name ="categoria")
	private String categoria;
	
	@Column(name="idcategoria")
	private String idcategoria;
	
	@Column(name ="nomestado")
	private String nomestado;
	
	@Column(name ="numpiso")
	private String numpiso;
	
	@Column(name ="preciobase")
	private Double preciobase;
	
	@Column(name ="preciodescuento")
	private Double preciodescuento;

	public String getIdhabitacion() {
		return idhabitacion;
	}

	public void setIdhabitacion(String idhabitacion) {
		this.idhabitacion = idhabitacion;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(String idcategoria) {
		this.idcategoria = idcategoria;
	}

	public String getNomestado() {
		return nomestado;
	}

	public void setNomestado(String nomestado) {
		this.nomestado = nomestado;
	}

	public String getNumpiso() {
		return numpiso;
	}

	public void setNumpiso(String numpiso) {
		this.numpiso = numpiso;
	}

	public Double getPreciobase() {
		return preciobase;
	}

	public void setPreciobase(Double preciobase) {
		this.preciobase = preciobase;
	}

	public Double getPreciodescuento() {
		return preciodescuento;
	}

	public void setPreciodescuento(Double preciodescuento) {
		this.preciodescuento = preciodescuento;
	}
	
	



	}