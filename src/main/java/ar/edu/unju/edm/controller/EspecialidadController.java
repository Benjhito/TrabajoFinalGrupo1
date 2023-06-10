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
	@Autowired
	Especialidad especialidad;
	@Autowired
	@Qualifier
	EspecialidadService especialidadService;
	
	@GetMapping("/formEspecialidad")
	public ModelAndView cargarFormEspecialidad() {
		
		ModelAndView vistaFormEspecialidad = new ModelAndView("formEspecialidad");
		vistaFormEspecialidad.addObject("especialidad", especialidad);
		
		return vistaFormEspecialidad;
	}
	
	@PostMapping("/listaEspecialidades")
	public ModelAndView mostrarListaEspecialidades(@ModelAttribute("medico") Especialidad nuevaEspecialidad) {
		
		ModelAndView vistaListaEspecialidades = new ModelAndView("listaEspecialidades");
		try {
			especialidadService.cargarEspecialidad(nuevaEspecialidad);
		} catch (Exception e) {
			
		}
		vistaListaEspecialidades.addObject("listaEspecialidades", especialidadService.listarEspecialidades());
		
		return vistaListaEspecialidades;
	}
}
