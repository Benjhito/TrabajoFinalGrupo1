package ar.edu.unju.edm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import ar.edu.unju.edm.model.Medico;
import ar.edu.unju.edm.service.MedicoService;

@Controller
public class MedicoController {
	// Entidad y Servicio utilizados
	@Autowired
	Medico medico;
	@Autowired
	@Qualifier("servicioMedico")
	MedicoService medicoService;
	
	// Carga del formulario
	@GetMapping("/formMedico")
	public ModelAndView cargarFormMedico() {
		// Creacion de la vista y adicion del objeto a la vista
		ModelAndView vistaFormMedico = new ModelAndView("formMedico");
		vistaFormMedico.addObject("medico", medico);
		
		return vistaFormMedico;
	}
	
	// Carga de la lista
	@PostMapping("/listaMedicos")
	public ModelAndView mostrarListaMedicos(@ModelAttribute("medico") Medico nuevoMedico) {
		// Creacion de la vista
		ModelAndView vistaListaMedicos = new ModelAndView("listaMedicos");
		
		// Carga del objeto desde la BD y adicion del mismo a la vista
		try {
			medicoService.cargarMedico(nuevoMedico);
		} catch (Exception e) {
			// TODO: handle exception
		}
		vistaListaMedicos.addObject("listaMedicos", medicoService.listarMedicos());
		
		return vistaListaMedicos;
	}
}
