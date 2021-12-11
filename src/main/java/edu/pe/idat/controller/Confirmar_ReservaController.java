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
import edu.pe.idat.model.Habitacion;
import edu.pe.idat.model.Listar_Confirmar_Reserva;
import edu.pe.idat.model.Listar_Detalle_Reserva;
import edu.pe.idat.model.Pago;
import edu.pe.idat.model.Categoria;
import edu.pe.idat.model.Temporada;
import edu.pe.idat.repository.Descuento_temporadaXcategoriaRepository;
import edu.pe.idat.service.CategoriaService;
import edu.pe.idat.service.DescuentoService;
import edu.pe.idat.service.Descuento_temporadaXcategoriaService;

import edu.pe.idat.service.Listar_CategoriaxXxTemporadaService;
import edu.pe.idat.service.Listar_Confirmar_ReservaService;
import edu.pe.idat.service.Listar_Detalle_ReservaService;
import edu.pe.idat.service.OperacionesCategoriaxXxTemporadaService;
import edu.pe.idat.service.PagoService;
import edu.pe.idat.service.ServicioService;
import edu.pe.idat.service.TemporadaService;


@Controller
public class Confirmar_ReservaController {
	
	@Autowired
	private Listar_Confirmar_ReservaService service;
	
	@Autowired
	private Listar_Detalle_ReservaService serviced;
	
	@Autowired
	private ServicioService services;
	
	@Autowired
	private PagoService pagoservice;
	
	
	
	@GetMapping("/listar_confirmar_reserva")
	public String listar_confirmar_reserva(Model model) {
		
		model.addAttribute("lista_reserva",service.listar_confirmar_reserva());
		
		return "listar_confirmar_reserva";
					
	}
	
	@GetMapping("/finalizar_hospedaje")
	public String listar_finalizar_reserva(Model model) {
		
		model.addAttribute("lista_reserva",service.listar_confirmar_reserva());
		
		return "finalizar_hospedaje";
					
	}
	
	@GetMapping("/finalizar_hospedaje/detalle_reserva_finalizar/{id}")
	public String detalle_reserva_finalizar(@PathVariable("id")String idre,Model model) {

		model.addAttribute("detalle_reserva_encontrada",serviced.listar_detalle_reserva(idre));
		model.addAttribute("detalle_reserva_servicio_encontrada",services.listar_detalle_reserva_servicio(idre));
		model.addAttribute("pagos",pagoservice.listar_pago_detalle_reserva(idre));
		return "detalle_reserva_finalizar";
	}
	
	
	
	
	@GetMapping("listar_confirmar_reserva/detalle_reserva/{id}")
	public String detalle_reserva(@PathVariable("id")String idre,Model model) {

		model.addAttribute("detalle_reserva_encontrada",serviced.listar_detalle_reserva(idre));
		model.addAttribute("detalle_reserva_servicio_encontrada",services.listar_detalle_reserva_servicio(idre));
		model.addAttribute("pagos",pagoservice.listar_pago_detalle_reserva(idre));
		return "detalle_reserva";
	}
	
	@PostMapping("/confirmar_reserva")
	public String confirmar_reserva(Listar_Detalle_Reserva confir) {
		
		serviced.confirmar_reserva(confir.getIdreserva(), "Confirmado");
		
		
		return "redirect:listar_confirmar_reserva";
		
	}
	
	
	@PostMapping("/finalizar_reserva")
	public String finalizar(Listar_Detalle_Reserva confir) {
		
		serviced.confirmar_reserva(confir.getIdreserva(), "Finalizado");
		
		
		return "redirect:finalizar_hospedaje";
		
	}
	
	@PostMapping("/cancelar_reserva")
	public String cancelar_reserva(Listar_Detalle_Reserva confir) {
		
		serviced.confirmar_reserva(confir.getIdreserva(), "Cancelada");
		
		
		return "redirect:listar_confirmar_reserva";
		
	}
	
	@PostMapping("/cancelar_reserva_finalizar")
	public String cancelar_reserva_finalizar(Listar_Detalle_Reserva confir) {
		
		serviced.confirmar_reserva(confir.getIdreserva(), "Cancelado");
		
		return "redirect:finalizar_hospedaje";
		
	}
	
	
	
	
	
	
}
