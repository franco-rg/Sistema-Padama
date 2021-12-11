package edu.pe.idat.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.ListarCategoriaxXxTemporada;
import edu.pe.idat.model.Listar_Confirmar_Reserva;
import edu.pe.idat.model.Listar_Detalle_Reserva;
@Repository
public interface Listar_Detalle_ReservaRepository extends JpaRepository<Listar_Detalle_Reserva, String>{
	
	@Query(value = "{call detalle_reserva_reserva(:id_reserva)}",nativeQuery = true)
	Listar_Detalle_Reserva listar_detalle_reserva(@Param("id_reserva") String id);
	
	@Transactional
	@Modifying
	@Query(value ="{call confirmar_reserva(:idreservas, :estado_reservas)}",nativeQuery = true)
	void actualizar_confirmar_reserva(
			@Param("idreservas")String idreserva,
			@Param("estado_reservas")String estado_reserva
	);
	
	
	
}
