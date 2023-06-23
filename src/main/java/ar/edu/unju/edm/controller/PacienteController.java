package ar.edu.unju.edm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import javax.validation.Valid;

import ar.edu.unju.edm.model.Paciente;
import ar.edu.unju.edm.service.PacienteService;
import ar.edu.unju.edm.repository.PacienteRepository;

@Controller
public class PacienteController {
    @Autowired
    @Qualifier("servicioPaciente")
    PacienteService pacienteService;
    @Autowired
    PacienteRepository pacienteRepository;
    @Autowired

    @GetMapping("/formPaciente")
    public ModelAndView cargarFormPaciente() {
        ModelAndView vistaFormPaciente = new ModelAndView("formPaciente");
        vistaFormPaciente.addObject("paciente", new Paciente());
        return vistaFormPaciente;
    }
    
    @PostMapping("/mostrarListaPacientes")
	public ModelAndView mostrarListaPacientes(@ModelAttribute("paciente") Paciente nuevoPaciente) {
		ModelAndView vistaListaPacientes = new ModelAndView("listaPacientes");
		try {
			pacienteService.cargarPaciente(nuevoPaciente);
		} catch (Exception e) {
			// TODO: handle exception
		}
		vistaListaPacientes.addObject("listaPacientes", pacienteService.listarPacientes());
		
		return vistaListaPacientes;
	}
    
    @PostMapping("/editarPaciente/{id_paciente}")
    public ModelAndView modificarPaciente(@PathVariable Integer id_paciente, @Valid @ModelAttribute("paciente") Paciente paciente, BindingResult result) {
        ModelAndView vistaFormularioPaciente = new ModelAndView("formPaciente");
        if (result.hasErrors()) {
            vistaFormularioPaciente.addObject("mensaje", "Por favor, corrija los errores a continuación");
        } else {
            try {
                paciente.setId_paciente(id_paciente);
                pacienteService.modificarPaciente(paciente);
                vistaFormularioPaciente.addObject("paciente", paciente);
                vistaFormularioPaciente.addObject("mensaje", "El paciente se ha modificado exitosamente");
            } catch (Exception e) {
                vistaFormularioPaciente.addObject("mensaje", "Ha ocurrido un error al modificar el médico");
            }
        }
        return vistaFormularioPaciente;
    }
    
    @PostMapping("/eliminarPaciente")
    public ModelAndView eliminarPaciente(@RequestParam("id_paciente") Integer id_paciente) {
      ModelAndView vistaListaPacientes = new ModelAndView("listaPacientes");
      pacienteService.eliminarPaciente(id_paciente);
      vistaListaPacientes.addObject("listaPacientes", pacienteService.listarPacientes());
      vistaListaPacientes.addObject("mensaje", "El paciente se ha eliminado exitosamente.");
      return vistaListaPacientes;
    }
}