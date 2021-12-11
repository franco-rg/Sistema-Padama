package edu.pe.idat.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import edu.pe.idat.model.Servicio;
import edu.pe.idat.model.Categoria;
import edu.pe.idat.model.Pago;

@Repository
public interface PagoRepository extends JpaRepository<Pago, String>{
	

	
	@Transactional
	@Modifying
	@Query(value ="{call registrar_pago(:idpagos ,:precios ,:idserv , :propietarios, :numero_tarjetas, :cvvs, :vencimiento_mess, :vencimiento_años)}",nativeQuery = true)
	void registrar_pago(
			@Param("idpagos")String idpago,
			@Param("precios")Double precio,
			@Param("idserv")String idserv,
			@Param("propietarios")String propietar,
			@Param("numero_tarjetas")String num_tar,
			@Param("cvvs")String cv,
			@Param("vencimiento_mess")String v_m,
			@Param("vencimiento_años")String v_a
		
			
	);
	

	
	@Query(value = "{call generar_id_pago()}",nativeQuery = true)
	String generarID_Pago();

	
	@Transactional
	@Modifying
	@Query(value ="{call actualizar_pago(:idpagos ,:precios )}",nativeQuery = true)
	void actualizar_pago(
			@Param("idpagos")String idpago,
			@Param("precios")Double precio
		
		
			
	);
	
	@Query(value = "{call listar_pagos_reserva(:idreservas)}",nativeQuery = true)
	List <Pago> listar_pagos_reserva(@Param("idreservas")String idreservas);

	
	
	@Query(value = "{call listar_pago_x_reserva(:reserva)}",nativeQuery = true)
	List <Pago> listar_pagos_detalle_reserva(@Param("reserva")String idreservas);

}
