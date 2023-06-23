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

import ar.edu.unju.edm.model.Especialidad;
import ar.edu.unju.edm.repository.EspecialidadRepository;
import ar.edu.unju.edm.service.EspecialidadService;

@Controller
public class EspecialidadController {
	// Entidad y Servicio utilizados
	@Autowired
	@Qualifier("servicioEspecialidad")
	EspecialidadService especialidadService;
    @Autowired
    EspecialidadRepository especialidadRepository;
    
	// Carga del formulario
	@GetMapping("/formEspecialidad")
	public ModelAndView cargarFormEspecialidad() {
		// Creacion de la vista y adicion del objeto a la vista
		ModelAndView vistaFormEspecialidad = new ModelAndView("formEspecialidad");
		vistaFormEspecialidad.addObject("especialidad", new Especialidad());
		
		return vistaFormEspecialidad;
	}
	
	// Carga de la lista
	@PostMapping("/listaEspecialidades")
	public ModelAndView mostrarListaEspecialidades(@ModelAttribute("medico") Especialidad nuevaEspecialidad) {
		// Creacion de la vista
		ModelAndView vistaListaEspecialidades = new ModelAndView("listaEspecialidades");
		
		// Carga del objeto desde la BD y adicion del mismo a la vista
		try {
			especialidadService.cargarEspecialidad(nuevaEspecialidad);
		} catch (Exception e) {
			// TODO: handle exception
		}
		vistaListaEspecialidades.addObject("listaEspecialidades", especialidadService.listarEspecialidades());
		
		return vistaListaEspecialidades;
	}
	 
    @PostMapping("/editarEspecialidad/{id_especialidad}")
    public ModelAndView modificarUnaEspecialidad(@PathVariable Integer id_especialidad, @Valid @ModelAttribute("especialidad") Especialidad especialidad, BindingResult result) {
        ModelAndView vistaFormularioEspecialidad = new ModelAndView("formEspecialidad");
        if (result.hasErrors()) {
            vistaFormularioEspecialidad.addObject("mensaje", "Por favor, corrija los errores a continuación");
        } else {
            try {
                especialidad.setId_especialidad(id_especialidad);
                especialidadService.modificarUnaEspecialidad(especialidad);
                vistaFormularioEspecialidad.addObject("especialidad", especialidad);
                vistaFormularioEspecialidad.addObject("mensaje", "La especialiad se ha modificado exitosamente");
            } catch (Exception e) {
                vistaFormularioEspecialidad.addObject("mensaje", "Ha ocurrido un error al modificar el especialidad");
            }
        }
        return vistaFormularioEspecialidad;
    }
    
    @PostMapping("/eliminarEspecialidad")
    public ModelAndView eliminarEspecialidad(@RequestParam("id_especialidad") Integer id_especialidad) {
      ModelAndView vistaListaEspecialidades = new ModelAndView("listaEspecialidades");
      especialidadService.eliminarEspecialidad(id_especialidad);
      vistaListaEspecialidades.addObject("listaEspecialidades", especialidadService.listarEspecialidades());
      vistaListaEspecialidades.addObject("mensaje", "La especialidad se ha eliminado exitosamente.");
      return vistaListaEspecialidades;
    }
}
