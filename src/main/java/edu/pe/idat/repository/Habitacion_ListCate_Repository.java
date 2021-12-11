package edu.pe.idat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.Habitacion_ListarCate;

@Repository
public interface Habitacion_ListCate_Repository extends JpaRepository<Habitacion_ListarCate, String>{
	

	
	// REPOSITORIO DE HABITACIONES DISPONIBLES POR CATEGORIA
	@Query(value = "{call listar_habitaciones_disponibles_x_cate(:cate)}", nativeQuery = true)
	List<Habitacion_ListarCate> listar_c_h(@Param("cate") String idcategoria);
	
	
	// REPOSITORIO: UBICAR HABITACION
	@Query(value = "{call capturar_habitacion(:habi)}", nativeQuery = true)
	Habitacion_ListarCate ubicar_habi(@Param("habi") String idhabitacion);	
}
