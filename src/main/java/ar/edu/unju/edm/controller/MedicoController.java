package ar.edu.unju.edm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.edm.model.Medico;
import ar.edu.unju.edm.service.MedicoService;

@Controller
public class MedicoController {
	@Autowired
	Medico medico;
	@Autowired
	MedicoService medicoService;
	
	// Carga del formulario
	@GetMapping("/formMedico")
	public ModelAndView cargarFormMedico() {
		
		ModelAndView vistaFormMedico = new ModelAndView("formMedico");
		vistaFormMedico.addObject("medico", medico);
		
		return vistaFormMedico;
	}
	
	@PostMapping("/formMedico")
	public ModelAndView mostrarFormMedico() {
		
		ModelAndView vistaFormMedico = new ModelAndView("formMedico");
		vistaFormMedico.addObject("medico", medico);
		
		return vistaFormMedico;
	}
	
	// Carga de la lista
	@GetMapping("/listaMedicos")
	public ModelAndView cargarListaMedicos() {
		
		ModelAndView vistaListaMedicos = new ModelAndView("listaMedicos");
		
		return vistaListaMedicos;
	}
	
	@PostMapping("/listaMedicos")
	public ModelAndView mostrarListaMedicos() {
		
		ModelAndView vistaListaMedicos = new ModelAndView("listaMedicos");
		
		return vistaListaMedicos;
	}
}
