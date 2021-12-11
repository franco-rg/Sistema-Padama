package edu.pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.model.Habitacion_ListarCate;
import edu.pe.idat.repository.Habitacion_ListCate_Repository;

@Service
public class Habitacion_ListCate_Service {

	@Autowired
	private Habitacion_ListCate_Repository habicaterepos;
	

	public List<Habitacion_ListarCate> listar_habitaciones_disponibles_x_cate(String idcate){
		return habicaterepos.listar_c_h(idcate);
	}
	
	public Habitacion_ListarCate ubicar_cate(String habi){
		return habicaterepos.ubicar_habi(habi);
	}
}
