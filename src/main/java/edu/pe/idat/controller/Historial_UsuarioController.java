package edu.pe.idat.controller;





import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import edu.pe.idat.model.Descuento;
import edu.pe.idat.model.Descuento_temporadaXcategoria;
import edu.pe.idat.model.Listar_Detalle_Reserva;
import edu.pe.idat.model.Categoria;
import edu.pe.idat.model.Temporada;
import edu.pe.idat.repository.Descuento_temporadaXcategoriaRepository;
import edu.pe.idat.service.CategoriaService;
import edu.pe.idat.service.DescuentoService;
import edu.pe.idat.service.Descuento_temporadaXcategoriaService;
import edu.pe.idat.service.Historial_UsuarioService;
import edu.pe.idat.service.Listar_CategoriaxXxTemporadaService;
import edu.pe.idat.service.Listar_Confirmar_ReservaService;
import edu.pe.idat.service.Listar_Detalle_ReservaService;
import edu.pe.idat.service.OperacionesCategoriaxXxTemporadaService;
import edu.pe.idat.service.PagoService;
import edu.pe.idat.service.ServicioService;
import edu.pe.idat.service.TemporadaService;


@Controller
public class Historial_UsuarioController {
	
	@Autowired
	private Historial_UsuarioService service;
	
	@Autowired
	private Listar_Confirmar_ReservaService services;
	
	@Autowired
	private Listar_Detalle_ReservaService serviced;
	

	@Autowired
	private PagoService pagoservice;
	
	
	@Autowired
	private ServicioService servicet;
	
	@GetMapping("/historial_usuario")
	public String historial_usuario(Model model,Authentication aut) {
		
		String nombre_usuario = aut.getName();
		
		model.addAttribute("reservas_usuario",service.listar_historial(nombre_usuario));
		
		return "historial_usuario";
		
	}
	
	
	@GetMapping("/historial_usuario/detalle_reserva_usuario/{id}")
	public String detalle_usuario_reserva(@PathVariable("id")String idre,Model model) {
		
		model.addAttribute("detalle_reserva_encontrada",serviced.listar_detalle_reserva(idre));
		model.addAttribute("detalle_reserva_servicio_encontrada",servicet.listar_detalle_reserva_servicio(idre));
		
		Listar_Detalle_Reserva reserva= serviced.listar_detalle_reserva(idre);
		
		model.addAttribute("pagos",pagoservice.listar_pago_detalle_reserva(idre));
		model.addAttribute("idreserva",reserva.getIdreserva());
		
		return "detalle_reserva_usuario";
		
	}
	
	
}