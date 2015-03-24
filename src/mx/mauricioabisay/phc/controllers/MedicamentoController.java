package mx.mauricioabisay.phc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("medicamento")
@SessionAttributes({"pacienteSummary", "usuario"})
public class MedicamentoController {
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView modelAndView = new ModelAndView();
		return modelAndView;
	}
}
