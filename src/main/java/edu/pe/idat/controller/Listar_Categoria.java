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
import edu.pe.idat.model.Habitacion_ListarCate;
import edu.pe.idat.model.Listar_Detalle_Reserva;
import edu.pe.idat.model.Listar_Habitacion;
import edu.pe.idat.model.Pago;
import edu.pe.idat.model.Reserva_Servicio;
import edu.pe.idat.model.Reservas;
import edu.pe.idat.model.Servicio;
import edu.pe.idat.model.Temporada;
import edu.pe.idat.model.User;
import edu.pe.idat.service.CategoriaService;
import edu.pe.idat.service.DescuentoService;
import edu.pe.idat.service.Descuento_temporadaXcategoriaService;
import edu.pe.idat.service.HabitacionService;
import edu.pe.idat.service.Habitacion_ListCate_Service;
import edu.pe.idat.service.Listar_CategoriaxXxTemporadaService;
import edu.pe.idat.service.Listar_Confirmar_ReservaService;
import edu.pe.idat.service.Listar_Detalle_ReservaService;
import edu.pe.idat.service.NivelService;
import edu.pe.idat.service.OperacionesCategoriaxXxTemporadaService;
import edu.pe.idat.service.PagoService;
import edu.pe.idat.service.ReservaService;
import edu.pe.idat.service.Reserva_Servicio_Service;
import edu.pe.idat.service.ServicioService;
import edu.pe.idat.service.TemporadaService;
import edu.pe.idat.service.UsuarioService;

@Controller
public class Listar_Categoria {

	@Autowired
	private PagoService pagoService;

	// Reservation Service
	@Autowired
	private ReservaService reservaService;

	@Autowired
	private Reserva_Servicio_Service rese_servi_s;

	// User
	@Autowired
	private UsuarioService usuarioService;

	// Room Service
	@Autowired
	private HabitacionService habitacionService;

	// Service
	@Autowired
	private ServicioService servicioService;

	// Nivel
	@Autowired
	private NivelService nivelService;

	@Autowired
	private TemporadaService service;

	@Autowired
	private OperacionesCategoriaxXxTemporadaService serviced;

	@Autowired
	private CategoriaService servicec;

	@Autowired
	private Listar_CategoriaxXxTemporadaService servicect;

	@Autowired
	private Habitacion_ListCate_Service habicateservice;

	@Autowired
	private Listar_Confirmar_ReservaService servic;

	@Autowired
	private Listar_Detalle_ReservaService serv;

	@GetMapping("/categoria_listar")
	public String frmListarCategoria(Model model) {

		List<Temporada> lista_temporada = new ArrayList<Temporada>();
		lista_temporada = service.listar_temporada();

		String id;
		boolean encontrado;

		for (Temporada tempo : lista_temporada) {

			if (LocalDate.now().isAfter(tempo.getFechaini()) && LocalDate.now().isBefore(tempo.getFechafi())) {

				id = tempo.getIdtemporada();
				encontrado = true;
				serviced.actualizar_precio_descuento(id);

				model.addAttribute("tempo", service.listar_temporada_id(id));
				model.addAttribute("lista", servicect.listar_Categoria_x_Temporada(id));
				model.addAttribute("encontrado", encontrado);

				break;

			} else {
				encontrado = false;
				serviced.cambiar_precio_base();
				model.addAttribute("lista", servicec.listar_categoria());
				model.addAttribute("encontrado", encontrado);

			}
		}
		return "categoria_listar";

	}

	// LISTADO DE HABITACIONES DISPONIBLES EN TABLA POR CATEGORIA
	@GetMapping("/categoria_listar/reservar-habitacion/{id}")
	public String reservar_h_c(@PathVariable("id") String cate, Model model) {

		Categoria cates = servicec.buscar_cate(cate);

		model.addAttribute("cate_select", cates);
		model.addAttribute("listhabitacion", habicateservice.listar_habitaciones_disponibles_x_cate(cate));
		return "reservar-habitacion";
	}

	// FORMULARIO DE RESERVA - MUESTREO DE DATOS
	@GetMapping("/categoria_listar/reservar-habitacion/formulario-de-reserva/{id}")
	public String reservar_gen(@PathVariable("id") String idcate, Model model) {

		Habitacion_ListarCate h = habicateservice.ubicar_cate(idcate);

		Reservas rese = new Reservas();
		if (h.getPreciobase() == h.getPreciodescuento()) {
			model.addAttribute("precio", h.getPreciobase());
		} else {
			model.addAttribute("precio", h.getPreciodescuento());
		}

		model.addAttribute("reserva", rese);
		model.addAttribute("ubicar_habi", habicateservice.ubicar_cate(idcate));
		model.addAttribute("listservicio", servicioService.listar_servicio());
		return "formulario-de-reserva";
	}

	@PostMapping("/registrar-reserva")
	public String reservar_post(@ModelAttribute Reservas reservas, @RequestParam(value = "myParam[]") String[] myParams,
			@RequestParam(value = "precio") Double precio, @RequestParam(value = "propietarios") String propietarios,
			@RequestParam(value = "numero_tarjetas") String numero_tarjetas, @RequestParam(value = "cvv") String cvv,
			@RequestParam(value = "vencimiento_mes") String vencimiento_mes,
			@RequestParam(value = "vencimiento_años") String vencimiento_años, Authentication auth) {

		String nombre = auth.getName();
		String rese = reservaService.generarID_Rese();

		User usuario = usuarioService.buscar_usuario(nombre);
		habitacionService.actualizar_hr(reservas.getIdhabitacion(), "01");

		if (myParams.length > 1) {
			reservaService.registrarReserva(reservas, rese, usuario.getId());
			for (String id : myParams) {

				Reserva_Servicio reserva_servi;

				if (id.equals("no_selecciono") == false) {

					reserva_servi = new Reserva_Servicio(rese, id);
					rese_servi_s.registrarReserva_Servicio(reserva_servi);

				}

			}
		} else {
			reservaService.registrarReserva(reservas, rese, usuario.getId());

		}

		pagoService.registrarPago(precio, rese, propietarios, numero_tarjetas, cvv, vencimiento_mes, vencimiento_años);

		return "redirect:/categoria_listar";
	}

	// FORMULARIO DE RESERVA - MUESTREO DE DATOS
	@GetMapping("historial_usuario/detalle_reserva_usuario/formulario-de-actualizacion-reserva/{id}")
	public String reserva_actualizacion(@PathVariable("id") String idcate, Model model) {

		Habitacion_ListarCate h = habicateservice.ubicar_cate(reservaService.buscar_reserva(idcate).getIdhabitacion());

		model.addAttribute("reserva", reservaService.buscar_reserva(idcate));
		model.addAttribute("reserxserv", rese_servi_s.listar_rxs_idrese(idcate));
		model.addAttribute("listservicios", servicioService.listar_servicio());
		model.addAttribute("ubicar_habi",
	    
	    habicateservice.ubicar_cate(reservaService.buscar_reserva(idcate).getIdhabitacion()));

		
		if (h.getPreciobase() == h.getPreciodescuento()) {
			model.addAttribute("precio", h.getPreciobase());
		} else {
			model.addAttribute("precio", h.getPreciodescuento());
		}

		List<Servicio> lista_servicios = new ArrayList<Servicio>();
		lista_servicios = servicioService.listar_servicio();

		List<Servicio> lista_servicios_no_seleccionados = new ArrayList<Servicio>();
		lista_servicios_no_seleccionados = servicioService.listar_servicio();

		List<Reserva_Servicio> lista_reserva_servicio = new ArrayList<Reserva_Servicio>();
		lista_reserva_servicio = rese_servi_s.listar_rxs_idrese(idcate);

		if (lista_reserva_servicio != null) {
			for (Servicio servi : lista_servicios) {

				for (Reserva_Servicio re_se : lista_reserva_servicio) {

					System.out.println();
					if (servi.getIdservicios().equals(re_se.getIdservicios())) {

						System.out.println("El servicio " + servi.getIdservicios()
								+ " ya se encuentra en la tabla reserva x servicio con el id " + re_se.getIdr_x_s());

						servi.setEstado("Eliminar");

					}
				}

			}
			
			double suma = 0.0;
			for (Reserva_Servicio r : lista_reserva_servicio) {

				suma = r.getPrecio() + suma;

			}
			model.addAttribute("listar_r_s", lista_reserva_servicio);
			model.addAttribute("listar_servicios", lista_servicios);
			model.addAttribute("precio_servicios", suma);
		}

		else {
			model.addAttribute("listar_r_s", lista_reserva_servicio);
			model.addAttribute("precio_servicios", 0.0);
		}

		return "formulario-de-actualizacion-reserva";

	}

	@PostMapping("/actualizar-reserva")
	public String actualizar_reserva(@RequestParam(value = "id_habitacion") String id_habitacion,
			@RequestParam(value = "id_habitacion_antigua") String id_habitacion_antigua,
			@RequestParam(value = "myParam[]") String[] myParams, @ModelAttribute Reservas reservas, 
			@RequestParam(value = "precio") Double precio,
			@RequestParam(value = "propietarios") String propietarios,
			@RequestParam(value = "numero_tarjetas") String numero_tarjetas, 
			@RequestParam(value = "cvv") String cvv,
			@RequestParam(value = "vencimiento_mes") String vencimiento_mes,
			@RequestParam(value = "vencimiento_años") String vencimiento_años,
			@RequestParam(value = "devolucion") Double devolucion) {

		System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee" + id_habitacion_antigua);
		habitacionService.actualizar_hr(id_habitacion_antigua, "03");

		String id = id_habitacion;
		System.out.println("2222222222222222222222222222222222222222222222222" + id);
		
		habitacionService.actualizar_hr(id, "01");
		
		List<Servicio> lista_servicios = new ArrayList<Servicio>();
		lista_servicios = servicioService.listar_servicio();

		List<Servicio> lista_servicios_no_seleccionados = new ArrayList<Servicio>();
		lista_servicios_no_seleccionados = servicioService.listar_servicio();

		List<Reserva_Servicio> lista_reserva_servicio = new ArrayList<Reserva_Servicio>();
		lista_reserva_servicio = rese_servi_s.listar_rxs_idrese(reservas.getIdreserva());

		System.out.println(lista_reserva_servicio == null);

		System.out.println("sssssssssssssssssssssssssssssssssssss" + lista_reserva_servicio.size());

		if (lista_reserva_servicio.size() == 0) {
			if (myParams.length > 1) {
				reservaService.actualizarReserva(reservas, id);
				for (String ids : myParams) {

					Reserva_Servicio reserva_servi;

					if (ids.equals("no_selecciono") == false) {

						reserva_servi = new Reserva_Servicio(reservas.getIdreserva(), ids);
						rese_servi_s.registrarReserva_Servicio(reserva_servi);

					}

				}
			} else {
				reservaService.actualizarReserva(reservas, id);

			}
		}

		else {

			if (lista_reserva_servicio.size() == myParams.length - 1) {
				System.out.println("Listas de Igual Tamaño");
				reservaService.actualizarReserva(reservas, id);
				int contador = 1;
				for (Reserva_Servicio ids : lista_reserva_servicio) {

					System.out.println("*-----------------------------------------------------------------*");
					System.out.println(ids.getIdr_x_s());
					System.out.println(reservas.getIdreserva());
					System.out.println(myParams[contador]);

					rese_servi_s.actualizar_reserva_servicio(ids.getIdr_x_s(), reservas.getIdreserva(),
							myParams[contador]);

					contador++;

				}

			}
			if (lista_reserva_servicio.size() < myParams.length - 1) {
				System.out.println("Lista de cehckbox de mayor tamaño");
				reservaService.actualizarReserva(reservas, id);
				int numero_registros = (myParams.length - 1) - lista_reserva_servicio.size();

				System.out.println(numero_registros);
				int contador = 1;
				Reserva_Servicio reserva_servi;
				for (int i = 1; i <= numero_registros; i++) {

					reserva_servi = new Reserva_Servicio(reservas.getIdreserva(), myParams[contador]);
					rese_servi_s.registrarReserva_Servicio(reserva_servi);
					contador++;

				}

				List<Reserva_Servicio> ls = new ArrayList<Reserva_Servicio>();
				ls = rese_servi_s.listar_rxs_idrese(reservas.getIdreserva());
				int contador2 = 1;
				for (Reserva_Servicio ids : ls) {

					System.out.println("*-----------------------------------------------------------------*");
					System.out.println(ids.getIdr_x_s());
					System.out.println(reservas.getIdreserva());
					System.out.println(myParams[contador2]);

					rese_servi_s.actualizar_reserva_servicio(ids.getIdr_x_s(), reservas.getIdreserva(),
							myParams[contador2]);

					contador2++;

				}

			}
			if (lista_reserva_servicio.size() > myParams.length - 1) {
				System.out.println("Lista de cehckbox de menor tamaño");
				reservaService.actualizarReserva(reservas, id);
				int numero_registros = lista_reserva_servicio.size() - (myParams.length - 1);

				System.out.println(numero_registros);
				int contador = 0;

				for (int i = 1; i <= numero_registros; i++) {

					System.out.println(lista_reserva_servicio.get(contador).getIdr_x_s());
					rese_servi_s.eliminar_reserva_servicio(lista_reserva_servicio.get(contador).getIdr_x_s());
					contador++;

				}

				List<Reserva_Servicio> ls = new ArrayList<Reserva_Servicio>();
				ls = rese_servi_s.listar_rxs_idrese(reservas.getIdreserva());

				if (ls.size() > 0) {

					int contador2 = 1;
					for (Reserva_Servicio ids : ls) {

						System.out.println("*-----------------------------------------------------------------*");
						System.out.println(ids.getIdr_x_s());
						System.out.println(reservas.getIdreserva());
						System.out.println(myParams[contador2]);

						rese_servi_s.actualizar_reserva_servicio(ids.getIdr_x_s(), reservas.getIdreserva(),
								myParams[contador2]);

						contador2++;

					}
				}

			}

		}

		reservaService.actualizarReserva(reservas, id);
		
		if (numero_tarjetas.equals("6666666666666666") == false) {
			System.out.println("Paga");
			pagoService.registrarPago(precio, reservas.getIdreserva(), propietarios, numero_tarjetas, cvv,
					vencimiento_mes, vencimiento_años);
		}
		if (devolucion != 0) {
			System.out.println("No Paga");
			List<Pago> pagos = new ArrayList<Pago>();
			pagos = pagoService.listar_pago(reservas.getIdreserva());
			double menor = 0;
			double mayor = 0;
			
			for (Pago p : pagos) {

				System.out.println(p.getPrecio());

				if (menor > p.getPrecio() || menor == 0)
					menor = p.getPrecio();
				if (mayor < p.getPrecio())
					mayor = p.getPrecio();

			}

			

			for (Pago p : pagos) {

				if(p.getPrecio() == mayor) {
					double precio_b = p.getPrecio() - devolucion; 
					pagoService.actualizar_pago(p.getIdpago(),precio_b);
				}

			}

		}
		
		
		
		return "redirect:/historial_usuario";

	}

	@PostMapping("/actualizar-reserva_sin_habitacion")
	public String actualizar_reserva(@RequestParam(value = "myParam[]") String[] myParams,
			@ModelAttribute Reservas reservas, @RequestParam(value = "precio") Double precio,
			@RequestParam(value = "propietarios") String propietarios,
			@RequestParam(value = "numero_tarjetas") String numero_tarjetas, @RequestParam(value = "cvv") String cvv,
			@RequestParam(value = "vencimiento_mes") String vencimiento_mes,
			@RequestParam(value = "vencimiento_años") String vencimiento_años,
			@RequestParam(value = "devolucion") Double devolucion) {

		List<Servicio> lista_servicios = new ArrayList<Servicio>();
		lista_servicios = servicioService.listar_servicio();

		List<Servicio> lista_servicios_no_seleccionados = new ArrayList<Servicio>();
		lista_servicios_no_seleccionados = servicioService.listar_servicio();

		List<Reserva_Servicio> lista_reserva_servicio = new ArrayList<Reserva_Servicio>();
		lista_reserva_servicio = rese_servi_s.listar_rxs_idrese(reservas.getIdreserva());

		System.out.println(lista_reserva_servicio == null);

		System.out.println("sssssssssssssssssssssssssssssssssssss" + lista_reserva_servicio.size());

		if (lista_reserva_servicio.size() == 0) {
			if (myParams.length > 1) {
				reservaService.actualizarReserva_sin_habitacion(reservas);
				for (String ids : myParams) {

					Reserva_Servicio reserva_servi;

					if (ids.equals("no_selecciono") == false) {

						reserva_servi = new Reserva_Servicio(reservas.getIdreserva(), ids);
						rese_servi_s.registrarReserva_Servicio(reserva_servi);

					}

				}
			} else {
				reservaService.actualizarReserva_sin_habitacion(reservas);

			}
		}

		else {

			if (lista_reserva_servicio.size() == myParams.length - 1) {
				System.out.println("Listas de Igual Tamaño");
				reservaService.actualizarReserva_sin_habitacion(reservas);
				int contador = 1;
				for (Reserva_Servicio ids : lista_reserva_servicio) {

					System.out.println("*-----------------------------------------------------------------*");
					System.out.println(ids.getIdr_x_s());
					System.out.println(reservas.getIdreserva());
					System.out.println(myParams[contador]);

					rese_servi_s.actualizar_reserva_servicio(ids.getIdr_x_s(), reservas.getIdreserva(),
							myParams[contador]);

					contador++;

				}

			}
			if (lista_reserva_servicio.size() < myParams.length - 1) {
				System.out.println("Lista de cehckbox de mayor tamaño");
				reservaService.actualizarReserva_sin_habitacion(reservas);
				int numero_registros = (myParams.length - 1) - lista_reserva_servicio.size();

				System.out.println(numero_registros);
				int contador = 1;
				Reserva_Servicio reserva_servi;
				for (int i = 1; i <= numero_registros; i++) {

					reserva_servi = new Reserva_Servicio(reservas.getIdreserva(), myParams[contador]);
					rese_servi_s.registrarReserva_Servicio(reserva_servi);
					contador++;

				}

				List<Reserva_Servicio> ls = new ArrayList<Reserva_Servicio>();
				ls = rese_servi_s.listar_rxs_idrese(reservas.getIdreserva());
				int contador2 = 1;
				for (Reserva_Servicio ids : ls) {

					System.out.println("*-----------------------------------------------------------------*");
					System.out.println(ids.getIdr_x_s());
					System.out.println(reservas.getIdreserva());
					System.out.println(myParams[contador2]);

					rese_servi_s.actualizar_reserva_servicio(ids.getIdr_x_s(), reservas.getIdreserva(),
							myParams[contador2]);

					contador2++;

				}

			}
			if (lista_reserva_servicio.size() > myParams.length - 1) {
				System.out.println("Lista de cehckbox de menor tamaño");
				reservaService.actualizarReserva_sin_habitacion(reservas);
				int numero_registros = lista_reserva_servicio.size() - (myParams.length - 1);

				System.out.println(numero_registros);
				int contador = 0;

				for (int i = 1; i <= numero_registros; i++) {

					System.out.println(lista_reserva_servicio.get(contador).getIdr_x_s());
					rese_servi_s.eliminar_reserva_servicio(lista_reserva_servicio.get(contador).getIdr_x_s());
					contador++;

				}

				List<Reserva_Servicio> ls = new ArrayList<Reserva_Servicio>();
				ls = rese_servi_s.listar_rxs_idrese(reservas.getIdreserva());

				if (ls.size() > 0) {

					int contador2 = 1;
					for (Reserva_Servicio ids : ls) {

						System.out.println("*-----------------------------------------------------------------*");
						System.out.println(ids.getIdr_x_s());
						System.out.println(reservas.getIdreserva());
						System.out.println(myParams[contador2]);

						rese_servi_s.actualizar_reserva_servicio(ids.getIdr_x_s(), reservas.getIdreserva(),
								myParams[contador2]);

						contador2++;

					}
				}

			}

		}
		reservaService.actualizarReserva_sin_habitacion(reservas);

		System.out.println("Holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa:" + numero_tarjetas);
		System.out.println(numero_tarjetas.equals("6666666666666666"));

		if (numero_tarjetas.equals("6666666666666666") == false) {
			System.out.println("Paga");
			pagoService.registrarPago(precio, reservas.getIdreserva(), propietarios, numero_tarjetas, cvv,
					vencimiento_mes, vencimiento_años);
		}
		if (devolucion != 0) {
			System.out.println("No Paga");
			List<Pago> pagos = new ArrayList<Pago>();
			pagos = pagoService.listar_pago(reservas.getIdreserva());
			double menor = 0;
			double mayor = 0;
			
			for (Pago p : pagos) {

				System.out.println(p.getPrecio());

				if (menor > p.getPrecio() || menor == 0)
					menor = p.getPrecio();
				if (mayor < p.getPrecio())
					mayor = p.getPrecio();

			}

			

			for (Pago p : pagos) {

				if(p.getPrecio() == mayor) {
					double precio_b = p.getPrecio() - devolucion; 
					pagoService.actualizar_pago(p.getIdpago(),precio_b);
				}

			}

		}

		return "redirect:/historial_usuario";

	}

	@GetMapping("/historial_usuario/detalle_reserva_usuario/cambiar_categoria/{id}")
	public String cambiar_categoria(@PathVariable("id") String idrese, Model model) {

		List<Temporada> lista_temporada = new ArrayList<Temporada>();
		lista_temporada = service.listar_temporada();

		String id;
		boolean encontrado;

		for (Temporada tempo : lista_temporada) {

			if (LocalDate.now().isAfter(tempo.getFechaini()) && LocalDate.now().isBefore(tempo.getFechafi())) {

				id = tempo.getIdtemporada();
				encontrado = true;
				serviced.actualizar_precio_descuento(id);

				model.addAttribute("tempo", service.listar_temporada_id(id));
				model.addAttribute("lista", servicect.listar_Categoria_x_Temporada(id));
				model.addAttribute("encontrado", encontrado);

				break;

			} else {
				encontrado = false;
				serviced.cambiar_precio_base();
				model.addAttribute("lista", servicec.listar_categoria());
				model.addAttribute("encontrado", encontrado);

			}
		}

		String id_reserva = idrese;

		model.addAttribute("id_reserva", id_reserva);

		return "cambiar_categoria";
	}

	@GetMapping("/cambiar_categoria/cambiar_habitacion/{id}")
	public String cambiar_habitacion(@PathVariable("id") String cate, Model model) {

		String ids = cate;

		String[] parts = ids.split("&");
		String part1 = parts[0];
		String part2 = parts[1];

		System.out.println(part1);

		System.out.println(part2);

		Categoria cates = servicec.buscar_cate(part1);

		model.addAttribute("cate_select", cates);
		model.addAttribute("listhabitacion", habicateservice.listar_habitaciones_disponibles_x_cate(part1));

		model.addAttribute("id_reserva", part2);

		return "cambiar_habitacion";
	}

	@GetMapping("cambiar_categoria/cambiar_habitacion/actualizar_reserva_cambio_habitacion/{id}")
	public String reserva_actualizacion_cambio(@PathVariable("id") String idcate, Model model) {

		String ids = idcate;

		String[] parts = ids.split("&");
		String part1 = parts[0];
		String part2 = parts[1];

		Habitacion_ListarCate h = habicateservice.ubicar_cate(part1);

		if (h.getPreciobase() == h.getPreciodescuento()) {
			model.addAttribute("precio", h.getPreciobase());
		} else {
			model.addAttribute("precio", h.getPreciodescuento());
		}

		List<Servicio> lista_servicios = new ArrayList<Servicio>();
		lista_servicios = servicioService.listar_servicio();

		List<Servicio> lista_servicios_no_seleccionados = new ArrayList<Servicio>();
		lista_servicios_no_seleccionados = servicioService.listar_servicio();

		List<Reserva_Servicio> lista_reserva_servicio = new ArrayList<Reserva_Servicio>();
		lista_reserva_servicio = rese_servi_s.listar_rxs_idrese(part2);

		if (lista_reserva_servicio != null) {
			for (Servicio servi : lista_servicios) {

				for (Reserva_Servicio re_se : lista_reserva_servicio) {

					System.out.println();
					if (servi.getIdservicios().equals(re_se.getIdservicios())) {

						System.out.println("El servicio " + servi.getIdservicios()
								+ " ya se encuentra en la tabla reserva x servicio con el id " + re_se.getIdr_x_s());

						servi.setEstado("Eliminar");

					}
				}

			}

			model.addAttribute("listar_r_s", lista_reserva_servicio);
			model.addAttribute("listar_servicios", lista_servicios);
			double suma = 0.0;
			for (Reserva_Servicio r : lista_reserva_servicio) {

				suma = r.getPrecio() + suma;

			}
			model.addAttribute("precio_servicios", suma);

		}

		else {
			model.addAttribute("listar_r_s", lista_reserva_servicio);
			model.addAttribute("precio_servicios", 0.0);

		}

		System.out.println(part1);

		System.out.println(part2);

		String id_habitacion = habicateservice.ubicar_cate(part1).getIdhabitacion();
		System.out.println(id_habitacion);

		model.addAttribute("id", id_habitacion);

		model.addAttribute("reserva", reservaService.buscar_reserva(part2));
		model.addAttribute("ubicar_habi", habicateservice.ubicar_cate(part1));

		model.addAttribute("reserxserv", rese_servi_s.listar_rxs_idrese(part2));
		model.addAttribute("listservicios", servicioService.listar_servicio());

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return "actualizar_reserva_cambio_habitacion";

	}

	@PostMapping("/cancelar_reserva_usuario")
	public String cancelar_reserva_usuario(Listar_Detalle_Reserva confir) {

		serv.confirmar_reserva(confir.getIdreserva(), "Cancelada");

		return "redirect:historial_usuario";

	}

}
