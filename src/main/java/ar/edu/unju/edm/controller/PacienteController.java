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

import ar.edu.unju.edm.model.Paciente;
import ar.edu.unju.edm.service.PacienteService;

@Controller
public class PacienteController {
	private static final Log GRUPO1 = LogFactory.getLog(PacienteController.class);
	
	@Autowired
	Paciente paciente;
	@Autowired
	@Qualifier
	PacienteService pacienteService;
	
	// Carga del formulario
	@GetMapping("/formPaciente")
	public ModelAndView cargarFormpaciente() {
		
		ModelAndView vistaFormPaciente = new ModelAndView("formPaciente");
		vistaFormPaciente.addObject("paciente", paciente);
		
		return vistaFormPaciente;
	}
	
	// Carga de la lista
	@PostMapping("/listaPacientes")
	public ModelAndView mostrarListaPacientes(@ModelAttribute("paciente") Paciente nuevoPaciente) {
		
		ModelAndView vistaListaPacientes = new ModelAndView("listaPacientes");
		GRUPO1.warn("Mostrando nuevo registro" + nuevoPaciente.getNombres());
		try {
			pacienteService.cargarPaciente(nuevoPaciente);
		} catch (Exception e) {
			
		}
		vistaListaPacientes.addObject("listaPacientes", pacienteService.listarPacientes());
		
		return vistaListaPacientes;
	}

}