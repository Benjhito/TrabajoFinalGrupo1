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

import ar.edu.unju.edm.model.Medico;
import ar.edu.unju.edm.service.MedicoService;
import ar.edu.unju.edm.service.EspecialidadService;

@Controller
public class MedicoController {
	// Inyeccion de Dependencias
    @Autowired @Qualifier("servicioMedico")
    MedicoService medicoService;
    @Autowired
    EspecialidadService especialidadService;

    // Carga del formulario para Medicos
    @GetMapping("/formMedico")
    public ModelAndView cargarFormMedico() {
        ModelAndView vistaFormMedico = new ModelAndView("formMedico");
        vistaFormMedico.addObject("medico", new Medico());
        
        return vistaFormMedico;
    }
    
    // Carga de la tabla con los registros de Medicos
    @GetMapping("/listaMedicos")
    public ModelAndView obtenerListaMedicos() {
    	ModelAndView vistaListaMedicos = new ModelAndView("listaMedicos");
    	vistaListaMedicos.addObject("listadoMedicos", medicoService.listarMedicos());
    	
    	return vistaListaMedicos;
    }
    
    @PostMapping("/listaMedicos")
	public ModelAndView mostrarListaMedicos(@ModelAttribute("medico") Medico nuevoMedico) {
		ModelAndView vistaListaMedicos = new ModelAndView("listaMedicos");
		
		try {
			medicoService.cargarMedico(nuevoMedico);
		} catch (Exception e) {
			vistaListaMedicos.addObject("mensaje", "Ha ocurrido un error cargando la pagina. ");
		}
		vistaListaMedicos.addObject("listadoMedicos", medicoService.listarMedicos());
		vistaListaMedicos.addObject("listadoEspecialidades", especialidadService.listarEspecialidades());
		
		return vistaListaMedicos;
	}
    
    // Carga del formulario Medico para modificar datos
    @PostMapping("/editarMedico/{id_medico}")
    public ModelAndView modificarMedico(@PathVariable Integer id_medico, 
    		@Valid @ModelAttribute("medico") Medico medico, BindingResult result) {
        ModelAndView vistaFormMedico = new ModelAndView("formMedico");
        
        if (result.hasErrors()) {
            vistaFormMedico.addObject("mensaje", "Por favor, corrija los errores a continuacion. ");
        } else {
            try {
                medico.setId_medico(id_medico);
                medicoService.modificarMedico(medico);
                vistaFormMedico.addObject("medico", medico);
                vistaFormMedico.addObject("mensaje", "El médico se ha modificado exitosamente. ");
            } catch (Exception e) {
                vistaFormMedico.addObject("mensaje", "Ha ocurrido un error al modificar el médico. ");
            }
        
        }
        return vistaFormMedico;
    }
    
    // Carga de la lista en caso de querer eliminar un Medico
    @PostMapping("/eliminarMedico")
    public ModelAndView eliminarMedico(@RequestParam("id_medico") Integer id_medico) {
      ModelAndView vistaListaMedicos = new ModelAndView("listaMedicos");
      
      medicoService.eliminarMedico(id_medico);
      vistaListaMedicos.addObject("listadoMedicos", medicoService.listarMedicos());
      vistaListaMedicos.addObject("mensaje", "El médico se ha eliminado exitosamente.");
      
      return vistaListaMedicos;
    }
}