package ar.edu.unju.edm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import ar.edu.unju.edm.model.Paciente;
import ar.edu.unju.edm.service.PacienteService;

@Controller
public class PacienteController {
	// Entidad y Servicio utilizados
	@Autowired
	Paciente paciente;
	@Autowired
	@Qualifier("servicioPaciente")
	PacienteService pacienteService;
	
	// Carga del formulario
	@GetMapping("/formPaciente")
	public ModelAndView cargarFormpaciente() {
		// Creacion de la vista y adicion del objeto a la vista
		ModelAndView vistaFormPaciente = new ModelAndView("formPaciente");
		vistaFormPaciente.addObject("paciente", paciente);
		
		return vistaFormPaciente;
	}
	
	// Carga de la lista
	@PostMapping("/mostrarListaPacientes")
	public ModelAndView mostrarListaPacientes(@ModelAttribute("paciente") Paciente nuevoPaciente) {
		// Creacion de la vista
		ModelAndView vistaListaPacientes = new ModelAndView("listaPacientes");
		
		// Carga del objeto desde la BD y adicion del mismo a la vista
		try {
			pacienteService.cargarPaciente(nuevoPaciente);
		} catch (Exception e) {
			// TODO: handle exception
		}
		vistaListaPacientes.addObject("listaPacientes", pacienteService.listarPacientes());
		
		return vistaListaPacientes;
	}

}