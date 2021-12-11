package edu.pe.idat.service;




import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import edu.pe.idat.model.Listar_Habitacion;
import edu.pe.idat.repository.Listar_HabitacionRepository;


@Service
public class Listar_HabitacionService {
	
	
	
	@Autowired
	private Listar_HabitacionRepository repository_H;
	
	
	
	
	
	public List<Listar_Habitacion> listar_habitacion(){
		return repository_H.listar_habitacion();
	}
	
	
	
	public List<Listar_Habitacion> listar_habi_cate(String id_cates){
		return repository_H.listar_habi_cate(id_cates);
	}
	
	
	
	public List<Listar_Habitacion> listar_habi_niv(String id_cates){
		return repository_H.listar_habi_nivel(id_cates);
	}
	
	
}


