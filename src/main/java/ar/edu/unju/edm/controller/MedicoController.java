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

import ar.edu.unju.edm.model.Medico;
import ar.edu.unju.edm.service.MedicoService;

@Controller
public class MedicoController {
	private static final Log GRUPO1 = LogFactory.getLog(MedicoController.class);
	
	@Autowired
	Medico medico;
	@Autowired
	@Qualifier
	MedicoService medicoService;
	
	// Carga del formulario
	@GetMapping("/formMedico")
	public ModelAndView cargarFormMedico() {
		
		ModelAndView vistaFormMedico = new ModelAndView("formMedico");
		vistaFormMedico.addObject("medico", medico);
		
		return vistaFormMedico;
	}
	
	// Carga de la lista
	@PostMapping("/listaMedicos")
	public ModelAndView mostrarListaMedicos(@ModelAttribute("medico") Medico nuevoMedico) {
		
		ModelAndView vistaListaMedicos = new ModelAndView("listaMedicos");
		GRUPO1.warn("Mostrando nuevo registro" + nuevoMedico.getNombres());
		try {
			medicoService.cargarMedico(nuevoMedico);
		} catch (Exception e) {
			
		}
		vistaListaMedicos.addObject("listaMedicos", medicoService.listarMedicos());
		
		return vistaListaMedicos;
	}
}
