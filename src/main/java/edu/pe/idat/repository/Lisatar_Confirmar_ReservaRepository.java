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
@Repository
public interface Lisatar_Confirmar_ReservaRepository extends JpaRepository<Listar_Confirmar_Reserva, String>{
	
	@Query(value = "{call Listar_Reservas_Confirmar()}",nativeQuery = true)
	List<Listar_Confirmar_Reserva> listar_confirmar_reserva();
	
	
	
}
