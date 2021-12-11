package edu.pe.idat.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Categoria_Reserva {
	
	@Id
	private String idreserva;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="fechaentrada")
	private LocalDate fechaentrada;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="fechasalida")
	private LocalDate fechasalida;
	
	@Column(name="nombreuser")
	private String nombreuser;
	
	@Column(name="apellidouser")
	private String apellidouser;
	
	@Column(name="correouser")
	private String correouser;
	
	@Column(name="telefonouser")
	private String telefonouser;
	
	@Column(name="idhabitacion")
	private String idhabitacion;
	
	@Column(name="idusuario")
	private Long idusuario;
	
	@Column(name="estado_reserva")
	private String estado_reserva;
	
	@Column(name="noche_reserva")
	private String noche_reserva;

	@Column(name = "categoria")
	private String categoria;

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

	
	

	public String getTelefonouser() {
		return telefonouser;
	}

	public void setTelefonouser(String telefonouser) {
		this.telefonouser = telefonouser;
	}

	public String getIdhabitacion() {
		return idhabitacion;
	}

	public void setIdhabitacion(String idhabitacion) {
		this.idhabitacion = idhabitacion;
	}

	public Long getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}

	public String getEstado_reserva() {
		return estado_reserva;
	}

	public void setEstado_reserva(String estado_reserva) {
		this.estado_reserva = estado_reserva;
	}

	public String getNoche_reserva() {
		return noche_reserva;
	}

	public void setNoche_reserva(String noche_reserva) {
		this.noche_reserva = noche_reserva;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	
	

	public Categoria_Reserva(String idreserva, LocalDate fechaentrada, LocalDate fechasalida, String nombreuser,
			String apellidouser, String correouser, String telefonouser, String idhabitacion, Long idusuario,
			String estado_reserva, String noche_reserva, String categoria) {
		super();
		this.idreserva = idreserva;
		this.fechaentrada = fechaentrada;
		this.fechasalida = fechasalida;
		this.nombreuser = nombreuser;
		this.apellidouser = apellidouser;
		this.correouser = correouser;
		this.telefonouser = telefonouser;
		this.idhabitacion = idhabitacion;
		this.idusuario = idusuario;
		this.estado_reserva = estado_reserva;
		this.noche_reserva = noche_reserva;
		this.categoria = categoria;
	}

	public Categoria_Reserva() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
		
}









