package mx.mauricioabisay.phc.controllers;

import javax.inject.Inject;
import javax.validation.Valid;

import mx.mauricioabisay.phc.forms.SearchForm;
import mx.mauricioabisay.phc.repositories.PacienteRepository;
import mx.mauricioabisay.phc.session.PacienteSummary;
import mx.mauricioabisay.phc.session.Usuario;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes({"pacienteSummary", "usuario"})
public class WelcomeController {
	@Inject PacienteRepository pacienteRepository;

	@RequestMapping(value = "welcome", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		model.addAttribute("searchForm", new SearchForm());
		model.addAttribute("usuario", new Usuario());
		return "main";
	}
	
	@RequestMapping(value = "welcome", method = RequestMethod.POST)
	public ModelAndView search(SessionStatus sessionStatus, @Valid SearchForm searchForm, Errors errors) {
		ModelAndView modelAndView = new ModelAndView("main");
		sessionStatus.setComplete();
		if(errors.hasErrors()) {
			modelAndView.addObject("searchForm", searchForm);
			return modelAndView;
		}
		if(searchForm.getNombre().equals("")) {
			modelAndView.addObject("pacientes", pacienteRepository.selectAll());
		} else {
			modelAndView.addObject("pacientes", pacienteRepository.search(searchForm.getNombre()));
		}
		modelAndView.addObject("usuario", new Usuario());
		return modelAndView;
	}
	
	@RequestMapping("logout_paciente")
	public String logoutPaciente(SessionStatus sessionStatus, 
			@ModelAttribute PacienteSummary pacienteSummary,
			ModelMap model) {
		sessionStatus.setComplete();
		model.addAttribute("searchForm", new SearchForm());
		model.addAttribute("usuario", new Usuario());
		return "redirect:/welcome";
	}
	
	@RequestMapping("logout")
	public String logoutPHC(SessionStatus sessionStatus, ModelMap model) {
		sessionStatus.setComplete();
		model.addAttribute("searchForm", new SearchForm());
		model.addAttribute("usuario", new Usuario());
		return "redirect:/welcome";
	}
	
}
