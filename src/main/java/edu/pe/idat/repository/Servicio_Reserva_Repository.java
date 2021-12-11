package edu.pe.idat.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.Categoria_Reserva;
import edu.pe.idat.model.Servicio_Reserva;

@Repository
public interface Servicio_Reserva_Repository extends JpaRepository<Servicio_Reserva, String>{
	
		
	// BUSCAR SERVICIOS DE CADA RESERVA
	@Query(value = "{call buscar_servicios_x_reservas(:idrese)}",nativeQuery = true)
	List<Servicio_Reserva> buscar_reserva(@Param("idrese") String idreserva);
	
}

