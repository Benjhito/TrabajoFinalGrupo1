package ar.edu.unju.edm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	@GetMapping({"/", "/index", "home"})
	public ModelAndView PagPrincipal() {
		ModelAndView mav = new ModelAndView("index");
		
		return mav;
	}
}
