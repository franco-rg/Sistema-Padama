package edu.pe.idat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.Habitacion;
import edu.pe.idat.model.Listar_Habitacion;
@Repository
public interface Listar_HabitacionRepository extends JpaRepository<Listar_Habitacion, String>{
	@Query(value = "{call listar_habitacion()}",nativeQuery = true)
	List<Listar_Habitacion> listar_habitacion();
	
	@Query(value = "{call listar_habi_cate(:id_cate)}",nativeQuery = true)
	List<Listar_Habitacion> listar_habi_cate(@Param("id_cate")String id_cates);
	
	@Query(value = "{call listar_habi_nivel(:id_cate)}",nativeQuery = true)
	List<Listar_Habitacion> listar_habi_nivel(@Param("id_cate")String id_cates);
	
}

