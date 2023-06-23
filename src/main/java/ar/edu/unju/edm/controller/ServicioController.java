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

import ar.edu.unju.edm.model.Servicio;
import ar.edu.unju.edm.repository.MedicoRepository;
import ar.edu.unju.edm.repository.ServicioRepository;
import ar.edu.unju.edm.service.ServicioService;

@Controller
public class ServicioController {
	// Entidad y Servicio utilizados
	@Autowired
	@Qualifier("servicioServicio")
	ServicioService servicioService;
    @Autowired
    ServicioRepository servicioRepository;
    @Autowired
    MedicoRepository medicoRepository;
	
	// Carga del formulario
	@GetMapping("/formServicio")
	public ModelAndView cargarFormServicio() {
		// Creacion de la vista y adicion del objeto a la vista
		ModelAndView vistaFormServicio = new ModelAndView("formServicio");
		vistaFormServicio.addObject("servicio", new Servicio());
		
		return vistaFormServicio;
	}
	
	// Carga de la lista
	@PostMapping("/listaServicios")
	public ModelAndView mostrarListaServicios(@ModelAttribute("servicio") Servicio nuevoServicio) {
		// Creacion de la vista
		ModelAndView vistaListaServicios = new ModelAndView("listaServicios");
		
		// Carga del objeto desde la BD y adicion del mismo a la vista
		try {
            servicioService.cargarServicio(nuevoServicio);
        } catch (Exception e) {
            // TODO: handle exception
        }
        vistaListaServicios.addObject("listaServicios", vistaListaServicios);
		
        return vistaListaServicios;
	}
    @PostMapping("/editarServicio/{id_servicio}")
    public ModelAndView modificarServicio(@PathVariable Integer id_servicio, @Valid @ModelAttribute("servicio") Servicio servicio, BindingResult result) {
        ModelAndView vistaFormServicio = new ModelAndView("formServicio");
        if (result.hasErrors()) {
            vistaFormServicio.addObject("mensaje", "Por favor, corrija los errores a continuación");
        } else {
            try {
                servicio.setId_servicio(id_servicio);
                servicioService.modificarUnServicio(servicio);
                vistaFormServicio.addObject("servicio", servicio);
                vistaFormServicio.addObject("mensaje", "El servicio se ha modificado exitosamente");
            } catch (Exception e) {
                vistaFormServicio.addObject("mensaje", "Ha ocurrido un error al modificar el servicio");
            }
        }
        return vistaFormServicio;
    }
    
    @PostMapping("/eliminarServicio")
    public ModelAndView eliminarServicio(@RequestParam("id_servicio") Integer id_servicio) {
      ModelAndView vistaListaServicios = new ModelAndView("listaServicios");
      servicioService.eliminarServicio(id_servicio);
      vistaListaServicios.addObject("listaServicios", servicioService.listarServicios());
      vistaListaServicios.addObject("mensaje", "El servicio se ha eliminado exitosamente.");
      return vistaListaServicios;
    }
}