package edu.pe.idat.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.pe.idat.model.Categoria;
import edu.pe.idat.model.Categoria_Reserva;
import edu.pe.idat.model.Habitacion;
import edu.pe.idat.model.Habitacion_ListarCate;
import edu.pe.idat.model.Nivel;
import edu.pe.idat.model.Reserva_Servicio;
import edu.pe.idat.model.Reservas;
import edu.pe.idat.model.Servicio;
import edu.pe.idat.model.Servicio_Reserva;
import edu.pe.idat.model.Temporada;
import edu.pe.idat.model.User;
import edu.pe.idat.repository.UsuarioRepository;
import edu.pe.idat.service.CategoriaService;
import edu.pe.idat.service.Categoria_Reserva_Service;
import edu.pe.idat.service.DescuentoService;
import edu.pe.idat.service.Descuento_temporadaXcategoriaService;
import edu.pe.idat.service.HabitacionService;
import edu.pe.idat.service.Habitacion_ListCate_Service;
import edu.pe.idat.service.Listar_CategoriaxXxTemporadaService;
import edu.pe.idat.service.NivelService;
import edu.pe.idat.service.OperacionesCategoriaxXxTemporadaService;
import edu.pe.idat.service.Pago_Reserva_Service;
import edu.pe.idat.service.ReservaService;
import edu.pe.idat.service.Reserva_Servicio_Service;
import edu.pe.idat.service.ServicioService;
import edu.pe.idat.service.Servicio_Reserva_Service;
import edu.pe.idat.service.TemporadaService;
import edu.pe.idat.service.UserService;
import edu.pe.idat.service.UsuarioService;

@Controller
public class ReservaController {

	// Reservation Service
	@Autowired
	private Categoria_Reserva_Service reservaService;
	
	@Autowired
	private Servicio_Reserva_Service servicio_reserva_service;
	
	@Autowired
	private Pago_Reserva_Service pago_reserva_service;


	// FORMULARIO: DETALLE DE RESERVA
	@GetMapping("/historial_usuario/detalle-reserva/{id}")
	public String details_rese(@PathVariable("id") String rese, Model model) {
		
		
		model.addAttribute("reserva", reservaService.buscar_reserva(rese));
		model.addAttribute("listservicios", servicio_reserva_service.buscar_reserva_servicio(rese));
		model.addAttribute("listpago", pago_reserva_service.buscar_reserva(rese));
		
		
		List<Servicio_Reserva> lista_temporada = new ArrayList<Servicio_Reserva>();
		lista_temporada = servicio_reserva_service.buscar_reserva_servicio(rese);
		
		for (Servicio_Reserva tempo : lista_temporada) {
			System.out.println(tempo.getNombreservicio());
		}
		
		System.out.println(rese);
		
		
		return "detalle-reserva";
	}


}
