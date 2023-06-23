package ar.edu.unju.edm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;

import ar.edu.unju.edm.model.Servicio;
import ar.edu.unju.edm.service.ServicioService;
import ar.edu.unju.edm.repository.ServicioRepository;

@Controller
public class ServicioController {
	// Inyeccion de Dependencias
	@Autowired @Qualifier("servicioServicio")
	ServicioService servicioService;
	@Autowired
	ServicioRepository servicioRepository;
		
	// Carga del formulario para Servicios
	@GetMapping("/formServicios")
	public ModelAndView cargarFormServicio() {
		ModelAndView vistaFormServicio = new ModelAndView("formServicio");
		vistaFormServicio.addObject("servicio", new Servicio());
		
		return vistaFormServicio;
	}
	
	// Carga de la tabla con los registros de Servicios
	@GetMapping("/listaServicios")
	public ModelAndView obtenerListaServicios() {
		ModelAndView vistaListaServicios = new ModelAndView("listaServicios");
		
		return vistaListaServicios;
	}
	
	@PostMapping("/listaServicios")
	public ModelAndView mostrarListaServicios(@ModelAttribute("servicio") Servicio nuevoServicio) {
		ModelAndView vistaListaServicios = new ModelAndView("listaServicios");
		
		try {
			servicioService.cargarServicio(nuevoServicio);
		} catch (Exception e) {
			vistaListaServicios.addObject("mensaje", "Ha ocurrido un error al cargar la pagina. ");
		}
		vistaListaServicios.addObject("listadoServicios", servicioService.listarServicios());
		
		return vistaListaServicios;
	}
	
	// Carga del formulario Servicio para modificar datos
	@PostMapping("/editarServicio/{id_servicio}")
	public ModelAndView modificarServicio(@PathVariable Integer id_servicio, 
			@Valid @ModelAttribute("servicio") Servicio servicio, BindingResult result) {
		ModelAndView vistaFormServicio = new ModelAndView("formServicio");
		
		if (result.hasErrors()) {
			vistaFormServicio.addObject("mensaje", "Por favor, corrija los errores a continuacion. ");
		} else {
			try {
				servicio.setId_servicio(id_servicio);
				servicioService.modificarServicio(servicio);
				vistaFormServicio.addObject("servicio", servicio);
				vistaFormServicio.addObject("mensaje", "El servicio se ha modificado con exito. ");
			} catch (Exception e) {
				vistaFormServicio.addObject("mensaje", "Ha ocurrido un error al modificar el servicio. ");
			}
		}
		
		return vistaFormServicio;
	}
	
	// Carga de la lista en caso de querer eliminar un Servicio.
	@PostMapping("/eliminarServicio")
	public ModelAndView eliminarServicio(@RequestParam("id_servicio") Integer id_servicio) {
		ModelAndView vistaListaServicios = new ModelAndView("listaServicios");
	
		servicioService.eliminarServicio(id_servicio);
		vistaListaServicios.addObject("listadoServicios", servicioService.listarServicios());
		vistaListaServicios.addObject("mensaje", "El servicio se ha eliminado con exito. ");
		
		return vistaListaServicios;
	}
}