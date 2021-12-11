package edu.pe.idat.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.Categoria_Reserva;

@Repository
public interface Categoria_Reserva_Repository extends JpaRepository<Categoria_Reserva, String>{
		
	// BUSCAR RESERVA TOTAL CON CATEGORIA
	@Query(value = "{call buscar_categoria_reserva_id(:idrese)}",nativeQuery = true)
	Categoria_Reserva buscar_reserva(@Param("idrese") String idreserva);
}

