package edu.pe.idat.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Listar_Detalle_Reserva {
	
	@Id
	private String idreserva;
	
	@Column(name ="nombreuser")
	private String nombreuser;
	
	@Column(name ="apellidouser")
	private String apellidouser;
	
	@Column(name ="correouser")
	private String correouser;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name ="fechaentrada")
	private LocalDate fechaentrada;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name ="fechasalida")
	private LocalDate fechasalida;
	
	
	
	@Column(name ="noche_reserva")
	private int noche_reserva;
	
	@Column(name ="idhabitacion")
	private String idhabitacion;
	
	@Column(name ="numpiso")
	private String numpiso;
	
	@Column(name ="idcategoria")
	private String idcategoria;
	
	
	@Column(name ="categoria")
	private String categoria;
	
	@Column(name ="preciobase")
	private String preciobase;
	
	@Column(name ="preciodescuento")
	private String preciodescuento;


	@Column(name ="estado_reserva")
	private String estado_reserva;
	
	
	

	public String getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(String idcategoria) {
		this.idcategoria = idcategoria;
	}

	public String getIdreserva() {
		return idreserva;
	}

	public void setIdreserva(String idreserva) {
		this.idreserva = idreserva;
	}

	public String getNombreuser() {
		return nombreuser;
	}

	public void setNombreuser(String nombreuser) {
		this.nombreuser = nombreuser;
	}

	public String getApellidouser() {
		return apellidouser;
	}

	public void setApellidouser(String apellidouser) {
		this.apellidouser = apellidouser;
	}

	public String getCorreouser() {
		return correouser;
	}

	public void setCorreouser(String correouser) {
		this.correouser = correouser;
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

	public int getNoche_reserva() {
		return noche_reserva;
	}

	public void setNoche_reserva(int noche_reserva) {
		this.noche_reserva = noche_reserva;
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getPreciobase() {
		return preciobase;
	}

	public void setPreciobase(String preciobase) {
		this.preciobase = preciobase;
	}

	public String getPreciodescuento() {
		return preciodescuento;
	}

	public void setPreciodescuento(String preciodescuento) {
		this.preciodescuento = preciodescuento;
	}



	public String getEstado_reserva() {
		return estado_reserva;
	}

	public void setEstado_reserva(String estado_reserva) {
		this.estado_reserva = estado_reserva;
	}

	public Listar_Detalle_Reserva(String idreserva, String estado_reserva) {
		super();
		this.idreserva = idreserva;
		this.estado_reserva = estado_reserva;
	}

	public Listar_Detalle_Reserva() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	

}