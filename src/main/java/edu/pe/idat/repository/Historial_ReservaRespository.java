package edu.pe.idat.repository;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.Habitacion;
import edu.pe.idat.model.Historial_Usuario;
import edu.pe.idat.model.Listar_Confirmar_Reserva;
@Repository
public interface Historial_ReservaRespository extends JpaRepository<Historial_Usuario, String>{
	
	@Query(value = "{call listar_reserva_por_username(:usuario)}",nativeQuery = true)
	List<Historial_Usuario> listar_reservas(@Param("usuario")String usernombre);

}