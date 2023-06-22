package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.model.Paciente;

@Controller
public class IndexController {
	@Autowired
	Paciente usuario;
	
	@GetMapping({"/", "/index", "/home"})
	public ModelAndView PagPrincipal() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("usuario", usuario);
		
		return mav;
	}
}
