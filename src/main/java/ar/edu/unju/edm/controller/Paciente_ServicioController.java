package ar.edu.unju.edm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import ar.edu.unju.edm.model.Paciente_Servicio;
import ar.edu.unju.edm.repository.PacienteRepository;
import ar.edu.unju.edm.repository.Paciente_ServicioRepository;
import ar.edu.unju.edm.repository.ServicioRepository;
import ar.edu.unju.edm.service.Paciente_ServicioService;

@Controller
public class Paciente_ServicioController {
	// Entidad y Servicio utilizados
	@Autowired
	@Qualifier("servicioPaciente_Servicio")
	Paciente_ServicioService paciente_servicioService;
    @Autowired
    Paciente_ServicioRepository paciente_servicioRepository;
    @Autowired
    PacienteRepository pacienteRepository;
    @Autowired
    ServicioRepository servicioRepository;
	// Carga del formulario
	@GetMapping("/formPaciente_Servicio")
	public ModelAndView cargarFormPaciente_Servicio() {
		// Creacion de la vista y adicion del objeto a la vista
		ModelAndView vistaFormPaciente_Servicio = new ModelAndView("formPaciente_Servicio");
		vistaFormPaciente_Servicio.addObject("paciente_servicio", new Paciente_Servicio());
		
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
	   @PostMapping("/editarPaciente_Servicio/{id_pacienteservicio}")
	    public ModelAndView modificarPaciente_Servicio(@PathVariable Integer id_pacienteservicio, @Valid @ModelAttribute("pacienteservicio") Paciente_Servicio paciente_servicio, BindingResult result) {
	        ModelAndView vistaFormPaciente_Servicio = new ModelAndView("formPaciente_Servicio");
	        if (result.hasErrors()) {
	            vistaFormPaciente_Servicio.addObject("mensaje", "Por favor, corrija los errores a continuación");
	        } else {
	            try {
	                paciente_servicio.setId_pacienteservicio(id_pacienteservicio);
	                paciente_servicioService.modificarPaciente_Servicio(paciente_servicio);
	                vistaFormPaciente_Servicio.addObject("paciente_servicio", paciente_servicio);
	                vistaFormPaciente_Servicio.addObject("mensaje", "El paciente_servicio se ha modificado exitosamente");
	            } catch (Exception e) {
	                vistaFormPaciente_Servicio.addObject("mensaje", "Ha ocurrido un error al modificar el paciente_servicio");
	            }
	        }
	        return vistaFormPaciente_Servicio;
	    }
	    
	    @PostMapping("/eliminarPaciente_Servicio")
	    public ModelAndView eliminarPaciente_Servicio(@RequestParam("id_pacienteservicio") Integer id_pacienteservicio) {
	      ModelAndView vistaListaMedicos = new ModelAndView("listaPacientes_Servicios");
	      paciente_servicioService.eliminarPaciente_Servicio(id_pacienteservico);
	      vistaListaMedicos.addObject("listaPacientes_Servicio", paciente_servicioService.listarRegistros());
	      vistaListaMedicos.addObject("mensaje", "El paciente_servicio se ha eliminado exitosamente.");
	      return vistaListaMedicos;
	    }
}
