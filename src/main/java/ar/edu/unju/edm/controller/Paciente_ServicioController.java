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

import ar.edu.unju.edm.model.Paciente_Servicio;
import ar.edu.unju.edm.service.Paciente_ServicioService;
import ar.edu.unju.edm.repository.Paciente_ServicioRepository;

@Controller
public class Paciente_ServicioController {
	// Inyeccion de Dependencias
	@Autowired @Qualifier("servicioPaciente_Servicio")
	Paciente_ServicioService paciente_servicioService;
	@Autowired
	Paciente_ServicioRepository paciente_servicioRepository;
	
	// Carga del formulario para Paciente_Servicio
	@GetMapping("/formPaciente_Servicio")
	public ModelAndView cargarFormPaciente_Servicio() {
		ModelAndView vistaFormPaciente_Servicio = new ModelAndView("formPaciente_Servicio");
		vistaFormPaciente_Servicio.addObject("paciente_servicio", new Paciente_Servicio());
		
		return vistaFormPaciente_Servicio;
	}
	
	// Carga de la tabla con los registros de Paciente_Servicio
	@GetMapping("/listaPaciente_Servicio")
	public ModelAndView obtenerListaPaciente_Servicio() {
		ModelAndView vistaListaPaciente_Servicio = new ModelAndView("formPaciente_Servicio");
		vistaListaPaciente_Servicio.addObject("paciente_servicio", new Paciente_Servicio());
		
		return vistaListaPaciente_Servicio;
	}
	
	@PostMapping("/listaPaciente_Servicio")
	public ModelAndView mostrarListaPacienteServicio(@ModelAttribute("paciente_servicio") Paciente_Servicio nuevoPaciente_Servicio) {
		ModelAndView vistaListaPaciente_Servicio = new ModelAndView("listaPaciente_Servicio");
		
		try {
			paciente_servicioService.cargarPaciente_Servicio(nuevoPaciente_Servicio);
		} catch (Exception e) {
			vistaListaPaciente_Servicio.addObject("mensaje", "Ha ocurrido un error cargando la pagina. ");
		}
		vistaListaPaciente_Servicio.addObject("listadoPaciente_Servicio", paciente_servicioService.listarPaciente_Servicio());
		
		return vistaListaPaciente_Servicio;
	}
	
	// Carga del formulario Paciente_Servicio para modificar datos
	@PostMapping("/editarPaciente_Servicio/{id_paciente_servicio}")
	public ModelAndView modificarPaciente_Servicio(@PathVariable Integer id_paciente_servicio,
			@Valid @ModelAttribute("paciente_servicio") Paciente_Servicio paciente_servicio, BindingResult result) {
		ModelAndView vistaFormPaciente_Servicio = new ModelAndView("formPaciente_Servicio");
		
		if (result.hasErrors()) {
			vistaFormPaciente_Servicio.addObject("mensaje", "Por favor, corrija los errores a continuacion. ");
		} else {
			try {
				paciente_servicio.setId_paciente_servicio(id_paciente_servicio);
				paciente_servicioService.modificarPaciente_Servicio(paciente_servicio);
				vistaFormPaciente_Servicio.addObject("paciente_servicio", paciente_servicio);
				vistaFormPaciente_Servicio.addObject("mensaje", "El registro se ha modificado con exito. ");
			} catch (Exception e) {
				vistaFormPaciente_Servicio.addObject("mensaje", "Ha ocurrido un error al modificar el registro. ");
			}
		}
		
		return vistaFormPaciente_Servicio;
	}
	
	// Carga de la lista en caso de querer eliminar un registro.
	@PostMapping("/eliminarPaciente_Servicio")
	public ModelAndView eliminarPaciente_Servicio(@RequestParam("id_paciente_servicio") Integer id_paciente_servicio) {
		ModelAndView vistaListaPaciente_Servicio = new ModelAndView("listaPaciente_Servicio");
		
		paciente_servicioService.eliminarPaciente_Servicio(id_paciente_servicio);
		vistaListaPaciente_Servicio.addObject("listadoPaciente_Servicio", paciente_servicioService.listarPaciente_Servicio());
		vistaListaPaciente_Servicio.addObject("mensaje", "El médico se ha eliminado exitosamente.");
		
		return vistaListaPaciente_Servicio;
	}
}