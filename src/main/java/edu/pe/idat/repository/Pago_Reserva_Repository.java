package edu.pe.idat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.Pago_Reserva;

@Repository
public interface Pago_Reserva_Repository extends JpaRepository<Pago_Reserva, String>{
	
		
	// BUSCAR SERVICIOS DE CADA RESERVA
	@Query(value = "{call buscar_pago_reserva_id(:idrese)}",nativeQuery = true)
	Pago_Reserva buscar_reserva(@Param("idrese") String idreserva);
	
}

