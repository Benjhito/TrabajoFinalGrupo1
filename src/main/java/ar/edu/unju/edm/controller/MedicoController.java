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

import ar.edu.unju.edm.model.Medico;
import ar.edu.unju.edm.service.MedicoService;
import ar.edu.unju.edm.repository.MedicoRepository;
import ar.edu.unju.edm.repository.EspecialidadRepository;

@Controller
public class MedicoController {
    @Autowired
    @Qualifier("servicioMedico")
    MedicoService medicoService;
    @Autowired
    MedicoRepository medicoRepository;
    @Autowired
    EspecialidadRepository especialidadRepository;

    @GetMapping("/formMedico")
    public ModelAndView cargarFormMedico() {
        ModelAndView vistaFormMedico = new ModelAndView("formMedico");
        vistaFormMedico.addObject("medico", new Medico());
        
        return vistaFormMedico;
    }
    
    @PostMapping("/listaMedicos")
	public ModelAndView mostrarListaMedicos(@ModelAttribute("medico") Medico nuevoMedico) {
		ModelAndView vistaListaMedicos = new ModelAndView("listaMedicos");
		
		try {
			medicoService.cargarMedico(nuevoMedico);
		} catch (Exception e) {
			// TODO: Handle exception
		}
		vistaListaMedicos.addObject("listaMedicos", medicoService.listarMedicos());
		
		return vistaListaMedicos;
	}
    
    @PostMapping("/editarMedico/{id_medico}")
    public ModelAndView modificarMedico(@PathVariable Integer id_medico, @Valid @ModelAttribute("medico") Medico medico, BindingResult result) {
        ModelAndView vistaFormMedico = new ModelAndView("formMedico");
        if (result.hasErrors()) {
            vistaFormMedico.addObject("mensaje", "Por favor, corrija los errores a continuación");
        } else {
            try {
                medico.setId_medico(id_medico);
                medicoService.modificarMedico(medico);
                vistaFormMedico.addObject("medico", medico);
                vistaFormMedico.addObject("mensaje", "El médico se ha modificado exitosamente");
            } catch (Exception e) {
                vistaFormMedico.addObject("mensaje", "Ha ocurrido un error al modificar el médico");
            }
        }
        return vistaFormMedico;
    }
    
    @PostMapping("/eliminarMedico")
    public ModelAndView eliminarMedico(@RequestParam("id_medico") Integer id_medico) {
      ModelAndView vistaListaMedicos = new ModelAndView("listaMedicos");
      medicoService.eliminarMedico(id_medico);
      vistaListaMedicos.addObject("listaMedicos", medicoService.listarMedicos());
      vistaListaMedicos.addObject("mensaje", "El médico se ha eliminado exitosamente.");
      return vistaListaMedicos;
    }
}