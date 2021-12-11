package edu.pe.idat.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	public Optional<User> findByUsername(String username);
	
	
	@Query(value = "{call listar_usuario()}",nativeQuery = true)
	List<User> listar_usuario();
}
