package edu.pe.idat.service;




import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.model.Descuento;
import edu.pe.idat.model.Descuento_temporadaXcategoria;
import edu.pe.idat.model.Estado_Habitacion;
import edu.pe.idat.model.Habitacion;
import edu.pe.idat.model.Categoria;
import edu.pe.idat.model.ListarCategoriaxXxTemporada;
import edu.pe.idat.model.Temporada;
import edu.pe.idat.model.Listar_Habitacion;
import edu.pe.idat.model.Nivel;
import edu.pe.idat.model.Pago;
import edu.pe.idat.repository.DescuentoRepository;
import edu.pe.idat.repository.Descuento_temporadaXcategoriaRepository;
import edu.pe.idat.repository.EstadoRepository;
import edu.pe.idat.repository.HabitacionRepository;
import edu.pe.idat.repository.CategoriaRepository;
import edu.pe.idat.repository.ListarCategoriaxXxTemporadaRepositoy;
import edu.pe.idat.repository.TemporadaRepository;
import edu.pe.idat.repository.Listar_HabitacionRepository;
import edu.pe.idat.repository.NivelRepository;
import edu.pe.idat.repository.OperacionesCategoriaxXxTemporadaRepository;
import edu.pe.idat.repository.PagoRepository;


@Service
public class PagoService {
	
	
	
	@Autowired
	private PagoRepository repository;

	
	
	public void registrarPago(Double precio, String idreserva, String propietario,String numero_tarjeta, String cv, String vencimiento_mes, String vencimiento_año){
		String IDn = generarID_Pago();
		repository.registrar_pago(IDn, precio, idreserva, propietario, numero_tarjeta, cv, vencimiento_mes, vencimiento_año);		
		
	}
	
  
 	public String generarID_Pago() {
		return repository.generarID_Pago();
	}
 	
 	public void actualizar_pago(String idpago, Double precio){
 		
		repository.actualizar_pago(idpago, precio);		
		
	}
 	
	public List<Pago> listar_pago(String id){
		return repository.listar_pagos_reserva(id);
	}
	
	public List<Pago> listar_pago_detalle_reserva(String id){
		return repository.listar_pagos_detalle_reserva(id);
	}
 	
 	
}
