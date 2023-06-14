package ar.edu.unju.edm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import ar.edu.unju.edm.model.Paciente_Servicio;
import ar.edu.unju.edm.service.Paciente_ServicioService;

@Controller
public class Paciente_ServicioController {
	// Entidad y Servicio utilizados
	@Autowired
	Paciente_Servicio paciente_servicio;
	@Autowired
	@Qualifier("servicioPaciente_Servicio")
	Paciente_ServicioService paciente_servicioService;
	
	// Carga del formulario
	@GetMapping("/formPaciente_Servicio")
	public ModelAndView cargarFormPaciente_Servicio() {
		// Creacion de la vista y adicion del objeto a la vista
		ModelAndView vistaFormPaciente_Servicio = new ModelAndView("formPaciente_Servicio");
		vistaFormPaciente_Servicio.addObject("paciente_servicio", paciente_servicio);
		
		return vistaFormPaciente_Servicio;
	}
	
	// Carga de la lista
	@PostMapping("/listaPacienteServicio")
	public ModelAndView mostrarListaPacienteServicio(@ModelAttribute("paciente_servicio") Paciente_Servicio nuevoPaciente_Servicio) {
		// Creacion de la vista
		ModelAndView vistaListaPaciente_Servicio = new ModelAndView("listaPaciente_Servicio");
		
		// Carga del objeto desde la BD y adicion del mismo a la vista
		try {
			paciente_servicioService.cargarPaciente_Servicio(nuevoPaciente_Servicio);
		} catch (Exception e) {
			// TODO: handle exception
		}
		vistaListaPaciente_Servicio.addObject("listaPaciente_Servicio", paciente_servicioService.listarRegistros());
		
		return vistaListaPaciente_Servicio;
	}
}
