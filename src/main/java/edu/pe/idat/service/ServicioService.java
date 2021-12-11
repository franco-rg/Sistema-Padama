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
import edu.pe.idat.model.Servicio;
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
import edu.pe.idat.repository.ServicioRepository;


@Service
public class ServicioService {
	
	@Autowired
	private ServicioRepository repository;
	
	
	public List<Servicio> listar_servicio(){
		return repository.listar_servicio();
	}
	
	public List<Servicio> listar_todo_servicio(){
		return repository.listar_todo_servicio();
	}
	
	
	public String generarID() {
		return repository.generarID_Servicio();
	}
	
	
	
	
	public void registrarServicio(Servicio servicio){
		String IDServicio = generarID();
		repository.registrarServicio(IDServicio,servicio.getNombreservicio() ,servicio.getDescripcion(),servicio.getEstado(),servicio.getImagen(),servicio.getPrecio());
		
		
	}
	
	
	
	
	

	
	public void actualizarServicio_foto(Servicio  servicio){
		
		
		

		repository.actualizarServicio(servicio.getIdservicios(),servicio.getNombreservicio(),servicio.getDescripcion(),servicio.getEstado(),servicio.getImagen(),servicio.getPrecio());
		
		
		
	}
	
	public void actualizarServicio_sinfoto(Servicio servicio){
		
		
		

		repository.actualizarCategoria_sinfoto(servicio.getIdservicios(),servicio.getNombreservicio(),servicio.getDescripcion(),servicio.getEstado(),servicio.getPrecio());
		
		
		
	}
	
	
	public Servicio buscar_servicio(String id){
		return repository.listar_servicio_id(id);
	}
	
	
	
	
	
	public String generarID_Servicio() {
		return repository.generarID_Servicio();
	}
	
	public List<Servicio> listar_detalle_reserva_servicio(String id){
		return repository.listar_detalle_reserva_servicios(id);

	}

	
	
	
}
