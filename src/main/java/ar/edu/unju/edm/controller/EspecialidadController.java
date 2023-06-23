package ar.edu.unju.edm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import ar.edu.unju.edm.model.Especialidad;
import ar.edu.unju.edm.service.EspecialidadService;

@Controller
public class EspecialidadController {
	// Entidad y Servicio utilizados
	@Autowired
	Especialidad especialidad;
	@Autowired
	@Qualifier("servicioEspecialidad")
	EspecialidadService especialidadService;
	
	// Carga del formulario
	@GetMapping("/formEspecialidad")
	public ModelAndView cargarFormEspecialidad() {
		// Creacion de la vista y adicion del objeto a la vista
		ModelAndView vistaFormEspecialidad = new ModelAndView("formEspecialidad");
		vistaFormEspecialidad.addObject("especialidad", especialidad);
		
		return vistaFormEspecialidad;
	}
	
	// Carga de la lista
	@PostMapping("/listaEspecialidades")
	public ModelAndView mostrarListaEspecialidades(@ModelAttribute("medico") Especialidad nuevaEspecialidad) {
		// Creacion de la vista
		ModelAndView vistaListaEspecialidades = new ModelAndView("listaEspecialidades");
		
		// Carga del objeto desde la BD y adicion del mismo a la vista
		try {
			especialidadService.cargarEspecialidad(nuevaEspecialidad);
		} catch (Exception e) {
			// TODO: handle exception
		}
		vistaListaEspecialidades.addObject("listaEspecialidades", especialidadService.listarEspecialidades());
		
		return vistaListaEspecialidades;
	}
}