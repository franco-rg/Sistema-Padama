package edu.pe.idat.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.pe.idat.model.Habitacion;
import edu.pe.idat.model.Temporada;
import edu.pe.idat.service.CategoriaService;
import edu.pe.idat.service.EstadoService;
import edu.pe.idat.service.HabitacionService;

import edu.pe.idat.service.Listar_HabitacionService;
import edu.pe.idat.service.NivelService;
@Controller
public class HabitacionesBDController {
	@Autowired
	private HabitacionService service;
	
	@Autowired
	private CategoriaService servicec;
	@Autowired
	private NivelService servicen;
	@Autowired
	private EstadoService servicees;
	@Autowired
	private Listar_HabitacionService servicesh;
	
	@GetMapping("/listar_habitacion")
	public String frmListarHabitacion(Model model) {
		
		
		
		model.addAttribute("lista",servicec.listar_toda_categoria());
		model.addAttribute("lista_h",servicesh.listar_habitacion());
		
		
		return "listar_habitacion";
	        
			
			
		
	}
	
	
	@GetMapping("/listar_habitacion/registrar_habitacion")
	public String crear(Model model) {
		
		Habitacion habi = new Habitacion();
		
		model.addAttribute("habitacion",habi);
		model.addAttribute("categoria",servicec.listar_categoria());
		model.addAttribute("nivel",servicen.listar_nivel_todo());
		model.addAttribute("estado",servicees.listar_estado());
		return "registrar_habitacion";
	}
	
	
	@PostMapping("/registrar_habi")
	public String crearHabitacion(@ModelAttribute Habitacion habitacion) {
		
		service.registrarHabitacion(habitacion);
		return "redirect:/listar_habitacion";
	}
	
	
	@GetMapping("listar_habitacion/actualizar_habitacion/{id}")
	public String editar_habitacion(@PathVariable("id")String idhabi,Model model) {
		
	 Habitacion habitacion = service.ecnontrar_h(idhabi);
		
		
		model.addAttribute("habitacion_encontrada",habitacion);
		
		
		model.addAttribute("categoria",servicec.listar_categoria());
		model.addAttribute("nivel",servicen.listar_nivel());
		model.addAttribute("estado",servicees.listar_estado());
	
		
		return "actualizar_habitacion";
	}
	
	
	@PostMapping("/actualizar_habita")
	public String actualizar_habitacion(@ModelAttribute Habitacion habitacion) {
		
			
			service.actualizarhabita(habitacion);
		
		
		
		
		
		
		
		return "redirect:/listar_habitacion";
	}
	
	
	
}
