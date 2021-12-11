package edu.pe.idat.repository;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.Reservas;
import edu.pe.idat.model.Temporada;

@Repository
public interface ReservaRepository extends JpaRepository<Reservas, String>{
	
	@Query(value="{call listar_reserva}",nativeQuery = true)
	List<Reservas> listar_reserva();
	
	@Transactional
	@Modifying
	@Query(value ="{call registrar_reserva(:idrese, :fechaent, :fechasal, :nomuser, :apeuser, :correouser, :fonouser, :idhabi, :idusu, :statusrese, :noche_rese)}",nativeQuery = true)
	void registrarReserva(
			@Param("idrese") String idreserva,
			@Param("fechaent") LocalDate fechaentrada,
			@Param("fechasal") LocalDate fechasalida,
			@Param("nomuser") String nombreuser,
			@Param("apeuser") String apellidouser,
			@Param("correouser") String correouser,
			@Param("fonouser") String telefonouser,
			@Param("idhabi") String idhabitacion,
			@Param("idusu") Long idusuario,
			@Param("statusrese") String estado_reserva,
			@Param("noche_rese") String noche_reserva);
	
	
	// ACTUALIZAR RESERVA 
	@Transactional
	@Modifying
	@Query(value ="{call actualizar_reserva(:idrese, :fechaent, :fechasal, :nomuser, :apeuser, :correouser, :fonouser, :idhabi, :idusu, :statusrese, :noche_rese)}", nativeQuery = true)
	void actualizarReserva(
			@Param("idrese") String idreserva,
			@Param("fechaent") LocalDate fechaentrada,
			@Param("fechasal") LocalDate fechasalida,
			@Param("nomuser") String nombreuser,
			@Param("apeuser") String apellidouser,
			@Param("correouser") String correouser,
			@Param("fonouser") String telefonouser,
			@Param("idhabi") String idhabitacion,
			@Param("idusu") Long idusuario,
			@Param("statusrese") String estado_reserva,
			@Param("noche_rese") String noche_reserva);
			
	
	@Query(value = "{call Generar_ID_Reserva()}",nativeQuery = true)
	String generarID_Reserva();
	
	// BUSCAR RESERVA
	@Query(value = "{call buscar_reserva_id(:idrese)}",nativeQuery = true)
	Reservas buscar_reserva(@Param("idrese") String idreserva);
	
		
}

