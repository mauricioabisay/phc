package mx.mauricioabisay.phc.controllers;

import java.sql.Date;
import java.time.LocalDate;

import javax.inject.Inject;
import javax.validation.Valid;

import mx.mauricioabisay.phc.entities.Interrogatorio;
import mx.mauricioabisay.phc.forms.InterrogatorioForm;
import mx.mauricioabisay.phc.repositories.InterrogatorioRepository;
import mx.mauricioabisay.phc.session.PacienteSummary;
import mx.mauricioabisay.phc.session.Usuario;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("interrogatorio")
@SessionAttributes({"pacienteSummary", "usuario"})
public class InterrogatorioController {
	@Inject InterrogatorioRepository interrogatorioRepository; 
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView modelAndView = new ModelAndView("interrogatorio/create");
		modelAndView.addObject("interrogatorioForm", new InterrogatorioForm());
		return modelAndView;
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ModelAndView create(@Valid InterrogatorioForm form, Errors errors,
			@ModelAttribute PacienteSummary pacienteSummary) {
		ModelAndView modelAndView = new ModelAndView("interrogatorio/create");
		if(errors.hasErrors()) {
			modelAndView.addObject("interrogatorioForm", form);
			return modelAndView;
		}
		form.setPaciente(pacienteSummary.getId());
		form.setFecha(Date.valueOf(LocalDate.now()));
		interrogatorioRepository.add(new Interrogatorio(form));
		modelAndView.clear();
		modelAndView.setViewName("redirect:/interrogatorio/" + pacienteSummary.getId());
		return modelAndView;
	}
	
	@RequestMapping(value = "/{pacienteId}", method = RequestMethod.GET)
	public ModelAndView list(@PathVariable("pacienteId") long idPaciente, @ModelAttribute Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("interrogatorio/list");
		usuario.setCurrent("interrogatorio");
		modelAndView.addObject("interrogatorios", interrogatorioRepository.selectAllFromPaciente(idPaciente));
		return modelAndView;
	}
	
	@RequestMapping(value = "retrieve/{interrogatorioId}", method = RequestMethod.GET)
	public ModelAndView retrieve(@PathVariable("interrogatorioId") long idInterrogatorio) {
		ModelAndView modelAndView = new ModelAndView("interrogatorio/retrieve");
		modelAndView.addObject("interrogatorio", interrogatorioRepository.get(idInterrogatorio));
		return modelAndView;
	}
	
	@RequestMapping(value = "update/{interrogatorioId}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("interrogatorioId") long idInterrogatorio) {
		ModelAndView modelAndView = new ModelAndView("interrogatorio/create");
		modelAndView.addObject("interrogatorioForm", new InterrogatorioForm(interrogatorioRepository.get(idInterrogatorio)));
		return modelAndView;
	}
	
	@RequestMapping(value = "update/{interrogatorioId}", method = RequestMethod.POST)
	public ModelAndView update(@Valid InterrogatorioForm form, Errors errors) {
		ModelAndView modelAndView = new ModelAndView("interrogatorio/create");
		
		if(errors.hasErrors()) {
			modelAndView.addObject("interrogatorioForm", form);
			return modelAndView;
		}
		form.setFecha(Date.valueOf(LocalDate.now()));
		Interrogatorio interrogatorio = new Interrogatorio(form);
		interrogatorio.setId(form.getId());
		interrogatorioRepository.update(interrogatorio);
		modelAndView.clear();
		modelAndView.setViewName("redirect:/interrogatorio/" + form.getPaciente());
		return modelAndView;
	}
	
	@RequestMapping(value = "delete/{interrogatorioId}", method = RequestMethod.GET)
	public String delete(@PathVariable("interrogatorioId") long idInterrogatorio,
			@ModelAttribute PacienteSummary pacienteSummary) {
		interrogatorioRepository.deleteById(idInterrogatorio);
		return "redirect:/interrogatorio/" + pacienteSummary.getId();
	}
	
}
