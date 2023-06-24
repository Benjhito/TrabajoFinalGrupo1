package ar.edu.unju.edm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.edm.model.Paciente;

@Controller
public class IndexController {
	@Autowired
	Paciente paciente;
	
	// Carga pagina principal
	@GetMapping({"/", "/index", "/home"})
	public ModelAndView PagPrincipal() {
		ModelAndView mav = new ModelAndView("index");
		
		return mav;
	}
	
	@PostMapping({"/", "/index", "/home"})
	public ModelAndView UserPagPrincipal() {
		ModelAndView mav = new ModelAndView("index");
		
		return mav;
	}
	
	// Carga de la pagina para iniciar sesion
	@GetMapping("/login")
	public ModelAndView FormLogin() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("paciente", paciente);
		
		return mav;
	}
}