package edu.pe.idat.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.Reserva_Servicio;
import edu.pe.idat.model.Reservas;

@Repository
public interface Reserva_Servicio_Repository extends JpaRepository<Reserva_Servicio, String>{
	
	@Transactional
	@Modifying
	@Query(value="{call registrar_reserva_x_servicio(:idrese, :idservi)}", nativeQuery = true)
	void registrar_reserva_servicio(
		
		@Param("idrese") String idreserva,
		@Param("idservi") String idservicios);
	
	@Query(value = "{call Generar_ID_Reserva_x_Servicios(:contador)}",nativeQuery = true)
	String generarID_Reservas_x_Servicios(@Param("contador") int contador);
	
	
	
	// LISTAR RESERVA X SERVICIO DEPENDIENDO ID DE RESERVA
	@Query(value="{call listar_rxs_idrese(:id)}",nativeQuery = true)
	List<Reserva_Servicio> listar_rxs_idrese(@Param("id") String id);
	
	
	
	// ACTUALIZAR RESERVA X SERVICIO
	@Transactional
	@Modifying
	@Query(value="{call actualizar_reserva_x_servicio(:idreseservi, :idrese, :idservi)}", nativeQuery = true)
	void actualizar_reserva_servicio(
		@Param("idreseservi") int idr_x_s,
		@Param("idrese") String idreserva,
		@Param("idservi") String idservicios
	);
	
	// ELIMINAR RESERVA X SERVICIO
	@Transactional
	@Modifying
	@Query(value="{call eliminar_reserva_x_servicio(:id)}",nativeQuery = true)
	void eliminar_reserva_servicio(@Param("id") int id);
	

	
	
}
