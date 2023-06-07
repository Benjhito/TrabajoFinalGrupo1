package ar.edu.unju.edm.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.edm.model.Especialidad;
import ar.edu.unju.edm.service.EspecialidadService;

@Controller
public class EspecialidadController {
	@Autowired
	Especialidad especialidad;
	@Autowired
	EspecialidadService especialidadService;
	
	@GetMapping("/formEspecialidad")
	public ModelAndView cargarFormEspecialidad() {
		
		ModelAndView vistaFormEspecialidad = new ModelAndView("formEspecialidad");
		vistaFormEspecialidad.addObject("especialidad", especialidad);
		
		return vistaFormEspecialidad;
	}
	
	@PostMapping("/formEspecialidad")
	public ModelAndView mostrarFormEspecialidad() {
		
		ModelAndView vistaFormEspecialidad = new ModelAndView("formEspecialidad");
		vistaFormEspecialidad.addObject("especialidad", especialidad);
		
		return vistaFormEspecialidad;
	}
	
	@GetMapping("/listaEspecialidades")
	public ModelAndView cargarListaEspecialidades() {
		
		ModelAndView vistaListaEspecialidades = new ModelAndView("listaEspecialidades");
		
		return vistaListaEspecialidades;
	}
	
	@PostMapping("/listaEspecialidades")
	public ModelAndView mostrarListaEspecialidades() {
		
		ModelAndView vistaListaEspecialidades = new ModelAndView("listaEspecialidades");
		
		return vistaListaEspecialidades;
	}
}
