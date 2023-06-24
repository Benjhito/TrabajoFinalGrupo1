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

import ar.edu.unju.edm.model.Paciente;
import ar.edu.unju.edm.service.PacienteService;

@Controller
public class PacienteController {
	// Inyeccion de Dependencias
    @Autowired @Qualifier("servicioPaciente")
    PacienteService pacienteService;

    // Carga del formulario para Pacientes
    @GetMapping("/formPaciente")
    public ModelAndView cargarFormPaciente() {
        ModelAndView vistaFormPaciente = new ModelAndView("formPaciente");
        vistaFormPaciente.addObject("paciente", new Paciente());
        
        return vistaFormPaciente;
    }
    
    // Carga de la tabla con los registros de Pacientes
    @GetMapping("/listaPacientes")
    public ModelAndView obtenerListaPacientes() {
    	ModelAndView vistaListaPacientes = new ModelAndView("listaPacientes");
    	vistaListaPacientes.addObject("listadoPacientes", pacienteService.listarPacientes());
    	
    	return vistaListaPacientes;
    }
    
    @PostMapping("/listaPacientes")
	public ModelAndView mostrarListaPacientes(@ModelAttribute("paciente") Paciente nuevoPaciente) {
		ModelAndView vistaListaPacientes = new ModelAndView("listaPacientes");
		
		try {
			nuevoPaciente.setClave("...");
			pacienteService.cargarPaciente(nuevoPaciente);
		} catch (Exception e) {
			vistaListaPacientes.addObject("mensaje", "Ha ocurrido un error cargando la pagina. ");
		}
		vistaListaPacientes.addObject("listadoPacientes", pacienteService.listarPacientes());
		
		return vistaListaPacientes;
	}
    
    // Carga del formulario Paciente para modificar datos
    @PostMapping("/editarPaciente/{id_paciente}")
    public ModelAndView modificarPaciente(@PathVariable Integer id_paciente, 
    		@Valid @ModelAttribute("paciente") Paciente paciente, BindingResult result) {
        ModelAndView vistaFormPaciente = new ModelAndView("formPaciente");
        
        if (result.hasErrors()) {
            vistaFormPaciente.addObject("mensaje", "Por favor, corrija los errores a continuacion. ");
        } else {
            try {
                paciente.setId_paciente(id_paciente);
                pacienteService.modificarPaciente(paciente);
                vistaFormPaciente.addObject("paciente", paciente);
                vistaFormPaciente.addObject("mensaje", "El médico se ha modificado exitosamente. ");
            } catch (Exception e) {
                vistaFormPaciente.addObject("mensaje", "Ha ocurrido un error al modificar el médico. ");
            }
        
        }
        return vistaFormPaciente;
    }
    
    // Carga de la lista en caso de querer eliminar un Paciente
    @PostMapping("/eliminarPaciente")
    public ModelAndView eliminarPaciente(@RequestParam("id_paciente") Integer id_paciente) {
      ModelAndView vistaListaPacientes = new ModelAndView("listaPacientes");
      
      pacienteService.eliminarPaciente(id_paciente);
      vistaListaPacientes.addObject("listadoPacientes", pacienteService.listarPacientes());
      vistaListaPacientes.addObject("mensaje", "El médico se ha eliminado exitosamente.");
      
      return vistaListaPacientes;
    }
}