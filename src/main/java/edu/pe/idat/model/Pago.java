package edu.pe.idat.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Pago {
	@Id
	private String idpago;
	
	@Column(name ="precio")
	private Double precio;
	
	@Column(name ="idreserva")
	private String idreserva;
	
	@Column(name ="propietario")
	private String propietario;
	
	@Column(name ="numero_tarjeta")
	private String numero_tarjeta;
	
	@Column(name ="cvv")
	private String cvv;
	
	@Column(name ="vencimiento_mes")
	private String vencimiento_mes;
	
	@Column(name ="año_vencimiento")
	private String año_vencimiento;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name ="fecha_pago")
	private LocalDate fecha_pago;

	public String getIdpago() {
		return idpago;
	}

	public void setIdpago(String idpago) {
		this.idpago = idpago;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getIdreserva() {
		return idreserva;
	}

	public void setIdreserva(String idreserva) {
		this.idreserva = idreserva;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public String getNumero_tarjeta() {
		return numero_tarjeta;
	}

	public void setNumero_tarjeta(String numero_tarjeta) {
		this.numero_tarjeta = numero_tarjeta;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getVencimiento_mes() {
		return vencimiento_mes;
	}

	public void setVencimiento_mes(String vencimiento_mes) {
		this.vencimiento_mes = vencimiento_mes;
	}

	public String getAño_vencimiento() {
		return año_vencimiento;
	}

	public void setAño_vencimiento(String año_vencimiento) {
		this.año_vencimiento = año_vencimiento;
	}

	public LocalDate getFecha_pago() {
		return fecha_pago;
	}

	public void setFecha_pago(LocalDate fecha_pago) {
		this.fecha_pago = fecha_pago;
	}

	public Pago(String idpago, Double precio, String idreserva, String propietario, String numero_tarjeta, String cvv,
			String vencimiento_mes, String año_vencimiento) {
		super();
		this.idpago = idpago;
		this.precio = precio;
		this.idreserva = idreserva;
		this.propietario = propietario;
		this.numero_tarjeta = numero_tarjeta;
		this.cvv = cvv;
		this.vencimiento_mes = vencimiento_mes;
		this.año_vencimiento = año_vencimiento;
	}

	public Pago(String idpago, Double precio, String propietario, String numero_tarjeta, String cvv,
			String vencimiento_mes, String año_vencimiento) {
		super();
		this.idpago = idpago;
		this.precio = precio;
		this.propietario = propietario;
		this.numero_tarjeta = numero_tarjeta;
		this.cvv = cvv;
		this.vencimiento_mes = vencimiento_mes;
		this.año_vencimiento = año_vencimiento;
	}

	public Pago() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
	
	
	
	
}