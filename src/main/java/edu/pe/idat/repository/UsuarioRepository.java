package edu.pe.idat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import edu.pe.idat.model.User;

@Repository
public interface UsuarioRepository extends JpaRepository<User, Integer>{
	
	@Query(value="{call listar_usuario}",nativeQuery = true)
	List<User> listar_usuario();
	
	@Query(value = "{call buscar_usuario_por_id(:iduser)}", nativeQuery = true)
	User buscar_usuario_id(@Param("iduser") String id);
}
