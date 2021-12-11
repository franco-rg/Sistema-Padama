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
import edu.pe.idat.model.Listar_Habitacion;
import edu.pe.idat.model.Categoria;
import edu.pe.idat.model.Temporada;
import edu.pe.idat.repository.Descuento_temporadaXcategoriaRepository;
import edu.pe.idat.service.CategoriaService;
import edu.pe.idat.service.DescuentoService;
import edu.pe.idat.service.Descuento_temporadaXcategoriaService;

import edu.pe.idat.service.Listar_CategoriaxXxTemporadaService;
import edu.pe.idat.service.Listar_HabitacionService;
import edu.pe.idat.service.OperacionesCategoriaxXxTemporadaService;
import edu.pe.idat.service.TemporadaService;


@Controller
public class HabitacionesListController {
	
	@Autowired
	private TemporadaService service;
	@Autowired
	private OperacionesCategoriaxXxTemporadaService serviced;
	
	@Autowired
	private CategoriaService servicec;
	
	@Autowired
	private Listar_CategoriaxXxTemporadaService servicect;
	@Autowired
	private DescuentoService servicecd;
	@Autowired
	private Descuento_temporadaXcategoriaService servicecdr;
	
	@Autowired
	private Listar_HabitacionService serviceh;
	
	
	@GetMapping("/habitacion")
	public String frmListarCategoria(Model model) {
		
		
		
		
		List<Temporada> lista_temporada = new ArrayList<Temporada>();
		lista_temporada = service.listar_temporada_h();
		
		String id;
		boolean encontrado;
		
		for (Temporada tempo : lista_temporada) {
			
			
			
				if(LocalDate.now().isAfter(tempo.getFechaini()) && LocalDate.now().isBefore(tempo.getFechafi())) {
					
					id = tempo.getIdtemporada();
					encontrado = true;
					serviced.actualizar_precio_descuento(id);
					
					model.addAttribute("tempo",service.listar_temporada_id(id));
					model.addAttribute("lista",servicect.listar_Categoria_x_Temporada(id));
					model.addAttribute("encontrado",encontrado);
					
					break;
					
					
					
			
				}else {
					encontrado = false;
					serviced.cambiar_precio_base();
					model.addAttribute("lista",servicec.listar_toda_categoria());
					model.addAttribute("encontrado",encontrado);
					
				}
		}
		return "habitacion";
	        
			
			
		
	}
	
	
	
	
	
	@GetMapping("/habitacion/registrarcategoria")
	public String crear(Model model) {
		
		Categoria categoria = new Categoria();
		
		model.addAttribute("categorias",categoria);
		
		
		return "registrarcategoria";
	}
	
	
	@PostMapping("/registrar")
	
	public String crearCategoria(@RequestParam(name="file",required=false) MultipartFile imagen,Categoria categoria) {
		if(!imagen.isEmpty()) {
			Path directorioImagenes= Paths.get("src//main/resources//static/images");
			String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
			
			try {
				byte[] bytesImg = imagen.getBytes();
				Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
				Files.write(rutaCompleta, bytesImg);
				categoria.setFoto(imagen.getOriginalFilename());
				
			} catch (IOException e) {
				 
				e.printStackTrace();
			}
			
			
			
		}
		
		servicec.registrarCategoria(categoria);
		return "redirect:/habitacion";
	}
	
	
	
	
	
	
	
	
	
	@GetMapping("habitacion/actualizar_categoria/{id}")
	public String editar_categoria(@PathVariable("id")String idCate,Model model) {
		
		Categoria cate= servicec.buscar_cate(idCate);
		
		
		model.addAttribute("cate_seleccionado",cate);
	
		
		return "actualizar_categoria";
	}
	
	
	@PostMapping("/actualizar_cate")
	public String actualizar_Categoria_dato(@RequestParam(name="file",required=false) MultipartFile imagen,Categoria cate) {
		
		if(!imagen.isEmpty()) {
			Path directorioImagenes= Paths.get("src//main/resources//static/images");
			String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
			
			try {
				byte[] bytesImg = imagen.getBytes();
				Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
				Files.write(rutaCompleta, bytesImg);
				cate.setFoto(imagen.getOriginalFilename());
				
			} catch (IOException e) {
				 
				e.printStackTrace();
			}
			
			
			
		}
		
		
		
		
		List<Listar_Habitacion> lista_habitacion = new ArrayList<Listar_Habitacion>();
		
		lista_habitacion = serviceh.listar_habi_cate(cate.getIdcategoria());
		Boolean encontrado = false;

		if (cate.getEstado().equals("Deshabilitado")) {

			for (Listar_Habitacion habi : lista_habitacion) {
				
				if (habi.getNomestado().equals("Ocupado") || habi.getNomestado().equals("Reservado")) {

					encontrado = true;
					
					break;

				}

				else {
					encontrado = false;
				}

			}
		
			
		
			
			if (encontrado == false) {
				
				if(imagen.isEmpty()) {
					servicec.actualizarCategoria(cate);
					return "redirect:habitacion";
				}
				else {
					
					servicec.actualizarCategoria_foto(cate);
					return "redirect:habitacion";
				}

			}
			
			else {
				return "redirect:/habitacion";
			}

			
		}

		
		
		
		else {
			if(imagen.isEmpty()) {
				servicec.actualizarCategoria(cate);
				return "redirect:habitacion";
			}
			else {
				
				servicec.actualizarCategoria_foto(cate);
				return "redirect:habitacion";
			}

		}
		
	
		
		
	}
	
	
	@GetMapping("habitacion/actualizar_descuento/{id}")
	public String actualizar(@PathVariable("id")String idHabita,Model model) {
		
		List<Descuento> desc= servicecd.listar_descuento_id(idHabita);
		
		
		model.addAttribute("listado_desc",desc);
	
		
		return "actualizar_descuento";
	}
	
	
	

	@GetMapping("/habitacion/actualizar_descuento/actualizar_descuento/modificar_descuento_categoria/{id}")
	public String pagina_actualizartemp(@PathVariable("id")String idTempo,Model model) {
		
		Descuento_temporadaXcategoria desc= servicecdr.buscar_desc_id(idTempo);
		
		
		model.addAttribute("descu_cate",desc);
	
		
		return "modificar_descuento_categoria";
	}
	
	
	
	@PostMapping("/actualizar_catedesc")
	
	public String actutemp(Descuento_temporadaXcategoria desc) {
		servicecdr.actualizar_descuento(desc);
		String id= desc.getIdcategoria();
		return "redirect:habitacion/actualizar_descuento/"+id;
	}
	
	
	
}

