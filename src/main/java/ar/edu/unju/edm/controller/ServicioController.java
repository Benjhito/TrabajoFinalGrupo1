package ar.edu.unju.edm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

import ar.edu.unju.edm.model.Servicio;
import ar.edu.unju.edm.service.ServicioService;

@Controller
public class ServicioController {
	private static final Log GRUPO1 = LogFactory.getLog(ServicioController.class);
	
	@Autowired
	Servicio servicio;
	@Autowired
	@Qualifier
	ServicioService servicioService;
	
	// Carga del formulario
	@GetMapping("/formServicio")
	public ModelAndView cargarFormServicio() {
		
		ModelAndView vistaFormServicio = new ModelAndView("formServicio");
		vistaFormServicio.addObject("servicio", servicio);
		
		return vistaFormServicio;
	}
	
	// Carga de la lista
	@PostMapping("/listaServicios")
	public ModelAndView mostrarListaServicios(@ModelAttribute("servicio") Servicio nuevoServicio) {
		
		ModelAndView vistaListaServicios = new ModelAndView("listaServicios");
		GRUPO1.warn("Mostrando nuevo registro" + nuevoServicio.getConsulta());
        try {
            servicioService.cargarServicio(nuevoServicio);
        } catch (Exception e) {
            // TODO: handle exception
        }
        vistaListaServicios.addObject("listaServicios", vistaListaServicios);
		return vistaListaServicios;
	}
}