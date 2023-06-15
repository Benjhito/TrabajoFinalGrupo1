package ar.edu.unju.edm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import ar.edu.unju.edm.model.Servicio;
import ar.edu.unju.edm.service.ServicioService;

@Controller
public class ServicioController {
	// Entidad y Servicio utilizados
	@Autowired
	Servicio servicio;
	@Autowired
	@Qualifier("servicioServicio")
	ServicioService servicioService;
	
	// Carga del formulario
	@GetMapping("/formServicio")
	public ModelAndView cargarFormServicio() {
		// Creacion de la vista y adicion del objeto a la vista
		ModelAndView vistaFormServicio = new ModelAndView("formServicio");
		vistaFormServicio.addObject("servicio", servicio);
		
		return vistaFormServicio;
	}
	
	// Carga de la lista
	@PostMapping("/listaServicios")
	public ModelAndView mostrarListaServicios(@ModelAttribute("servicio") Servicio nuevoServicio) {
		// Creacion de la vista
		ModelAndView vistaListaServicios = new ModelAndView("listaServicios");
		
		// Carga del objeto desde la BD y adicion del mismo a la vista
		try {
            servicioService.cargarServicio(nuevoServicio);
        } catch (Exception e) {
            // TODO: handle exception
        }
        vistaListaServicios.addObject("listaServicios", vistaListaServicios);
		
        return vistaListaServicios;
	}
}