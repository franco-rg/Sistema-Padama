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
import edu.pe.idat.model.Servicio;
import edu.pe.idat.model.Categoria;
import edu.pe.idat.model.Temporada;
import edu.pe.idat.repository.Descuento_temporadaXcategoriaRepository;
import edu.pe.idat.service.CategoriaService;
import edu.pe.idat.service.DescuentoService;
import edu.pe.idat.service.Descuento_temporadaXcategoriaService;

import edu.pe.idat.service.Listar_CategoriaxXxTemporadaService;
import edu.pe.idat.service.OperacionesCategoriaxXxTemporadaService;
import edu.pe.idat.service.ServicioService;
import edu.pe.idat.service.TemporadaService;


@Controller
public class ServicioController {
	
	@Autowired
	private ServicioService service;
	
	
	@GetMapping("/listar_servicio")
	public String frmListarServicio(Model model) {
		
		
		
		
		
		model.addAttribute("servi",service.listar_todo_servicio());
		
		
		return "listar_servicio";
	        
			
			
		
	}
	
	@GetMapping("/listar_servicio/registrar_servicio")
	public String crear(Model model) {
		
		Servicio servicio = new Servicio();
		
		model.addAttribute("servicio",servicio);
		
		
		return "registrar_servicio";
	}
	
	
	@PostMapping("/registrar_ser")
	
	public String crearServicio(@RequestParam(name="file",required=false) MultipartFile imagen,Servicio servicio) {
		if(!imagen.isEmpty()) {
			Path directorioImagenes= Paths.get("src//main/resources//static/images");
			String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
			
			try {
				byte[] bytesImg = imagen.getBytes();
				Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
				Files.write(rutaCompleta, bytesImg);
				servicio.setImagen(imagen.getOriginalFilename());
				
			} catch (IOException e) {
				 
				e.printStackTrace();
			}
			
			
			
		}
		
		service.registrarServicio(servicio);
		return "redirect:/listar_servicio";
	}
	
	
	
	
	
	
	
	
	
	@GetMapping("listar_servicio/actualizar_servicio/{id}")
	public String editar_servicio(@PathVariable("id")String idser,Model model) {
		
		Servicio ser= service.buscar_servicio(idser);
		
		
		model.addAttribute("ser_seleccionado",ser);
	
		
		return "actualizar_servicio";
	}
	
	
	@PostMapping("/actualizar_ser")
	public String actualizar_servicio_dato(@RequestParam(name="file",required=false) MultipartFile imagen,Servicio ser) {
		
		if(!imagen.isEmpty()) {
			Path directorioImagenes= Paths.get("src//main/resources//static/images");
			String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
			
			try {
				byte[] bytesImg = imagen.getBytes();
				Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
				Files.write(rutaCompleta, bytesImg);
				ser.setImagen(imagen.getOriginalFilename());
				
			} catch (IOException e) {
				 
				e.printStackTrace();
			}
			
			
			
		}
		

		if(imagen.isEmpty()) {
			service.actualizarServicio_sinfoto(ser);
			
		}
		else {
			
			service.actualizarServicio_foto(ser);
		}
		
		
		
		return "redirect:/listar_servicio";
	}
	
	
	
	
	
}