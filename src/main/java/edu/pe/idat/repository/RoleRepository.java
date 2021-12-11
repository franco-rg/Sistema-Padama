package edu.pe.idat.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

	 //Role findByName(String nombre);
	
	 //Role findByname(String role);
	
	/*@Query(value ="{call listar_rol()}",nativeQuery=true)
	List<Rol>listar_rol();*/
	
	


}
