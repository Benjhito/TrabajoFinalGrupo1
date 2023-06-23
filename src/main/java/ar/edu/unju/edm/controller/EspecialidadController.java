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

import ar.edu.unju.edm.model.Especialidad;
import ar.edu.unju.edm.service.EspecialidadService;
import ar.edu.unju.edm.repository.EspecialidadRepository;

@Controller
public class EspecialidadController {
	// Inyeccion de Dependencias
	@Autowired @Qualifier("servicioEspecialidad")
	EspecialidadService especialidadService;
	@Autowired
	EspecialidadRepository especialidadRepository;
	
	// Carga del formulario para Especialidades
	@GetMapping("/formEspecialidad")
	public ModelAndView cargarFormEspecialidad() {
		ModelAndView vistaFormEspecialidad = new ModelAndView("formEspecialidad");
		vistaFormEspecialidad.addObject("especialidad", new Especialidad());
		
		return vistaFormEspecialidad;
	}
	
	// Carga de la tabla con los registros de Especialidades
	@GetMapping("/listaEspecialidades")
	public ModelAndView obtenerListaEspecialidades() {
		ModelAndView vistaListaEspecialidades = new ModelAndView("listaEspecialidades");
		
		return vistaListaEspecialidades;
	}
	
	@PostMapping("/listaEspecialidades")
	public ModelAndView mostrarListaPacientes(@ModelAttribute("especialidad") Especialidad nuevaEspecialidad) {
		ModelAndView vistaListaEspecialidades = new ModelAndView("listaEspecialidades");
		
		try {
			especialidadService.cargarEspecialidad(nuevaEspecialidad);
		} catch (Exception e) {
			vistaListaEspecialidades.addObject("mensaje", "Ha ocurrido un error al cargar la pagina. ");
		}
		vistaListaEspecialidades.addObject("listadoEspecialidad", especialidadService.listarEspecialidades());
		
		return vistaListaEspecialidades;
	}
	
	// Carga del formulario Especialidad para modificar datos
	@PostMapping("/editarEspecialidad/{id_especialidad}")
	public ModelAndView modificarEspecialidad(@PathVariable Integer id_especialidad, 
			@Valid @ModelAttribute("especialidad") Especialidad especialidad, BindingResult result) {
		ModelAndView vistaFormEspecialidad = new ModelAndView("formEspecialidad");
		
		if (result.hasErrors()) {
			vistaFormEspecialidad.addObject("mensaje", "Por favor, corrija los errores a continuacion. ");
		} else {
			try {
				especialidad.setId_especialidad(id_especialidad);
				especialidadService.modificarEspecialidad(especialidad);
				vistaFormEspecialidad.addObject("especialidad", especialidad);
				vistaFormEspecialidad.addObject("mensaje", "La especialidad se ha modificado con exito. ");
			} catch (Exception e) {
				vistaFormEspecialidad.addObject("mensaje", "Ha ocurrido un error al modificar la especialidad. ");
			}
		}
		
		return vistaFormEspecialidad;
	}
	
	// Carga de la lista en caso de querer eliminar una Especialidad.
	@PostMapping("/eliminarEspecialidad")
	public ModelAndView eliminarEspecialidad(@RequestParam("id_especialidad") Integer id_especialidad) {
		ModelAndView vistaListaEspecialidades = new ModelAndView("listaEspecialidades");
		
		especialidadService.eliminarEspecialidad(id_especialidad);
		vistaListaEspecialidades.addObject("listadoEspecialidades", especialidadService.listarEspecialidades());
		vistaListaEspecialidades.addObject("mensaje", "La especialidad se ha eliminado con exito. ");
		
		return vistaListaEspecialidades;
	}
}
