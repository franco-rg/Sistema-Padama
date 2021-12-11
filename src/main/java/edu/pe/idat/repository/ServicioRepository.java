package edu.pe.idat.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import edu.pe.idat.model.Servicio;
import edu.pe.idat.model.Categoria;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, String>{
	
	@Query(value = "{call listar_servicio_habilitado()}",nativeQuery = true)
	List<Servicio> listar_servicio();
	
	@Query(value = "{call listar_servicio_TODO()}",nativeQuery = true)
	List<Servicio> listar_todo_servicio();
	
	@Transactional
	@Modifying
	@Query(value ="{call Registrar_Servicio(:idservicioss , :nombreservicios , :descripcions , :estados, :imagens, :precios)}",nativeQuery = true)
	void registrarServicio(
			@Param("idservicioss")String idservicio,
			@Param("nombreservicios")String nombreservicio,
			@Param("descripcions")String descrip,
			@Param("estados")String estado,
			@Param("imagens")String imagen,
			
			@Param("precios")Double precio
			
	);
	
	@Transactional
	@Modifying
	@Query(value ="{call Actualizar_Servicio(:idservicioss , :nombreservicios , :descripcions , :estados, :imagens, :precios)}",nativeQuery = true)
	void actualizarServicio(
			@Param("idservicioss")String idservicio,
			@Param("nombreservicios")String nombreservicio,
			@Param("descripcions")String descrip,
			@Param("estados")String estado,
			@Param("imagens")String imagen,
			
			@Param("precios")Double precio
			
	);
	
	@Transactional
	@Modifying
	@Query(value ="{call Actualizar_Servicio_sinfoto(:idservicioss , :nombreservicios , :descripcions , :estados, :precios)}",nativeQuery = true)
	void actualizarCategoria_sinfoto(
			@Param("idservicioss")String idservicio,
			@Param("nombreservicios")String nombreservicio,
			@Param("descripcions")String descrip,
			@Param("estados")String estado,
			
			@Param("precios")Double precio
			
			
			
	);
	
	@Query(value = "{call generar_id_servicio()}",nativeQuery = true)
	String generarID_Servicio();
	
	
	@Query(value = "{call encontrar_Servicio(:idservicioss)}",nativeQuery = true)
	Servicio listar_servicio_id(@Param("idservicioss") String id);
	
	@Query(value = "{call detalle_reserva_servicio(:id_reserva)}",nativeQuery = true)
	List<Servicio> listar_detalle_reserva_servicios(@Param("id_reserva") String id);
	
	
}
