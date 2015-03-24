package mx.mauricioabisay.phc.controllers;

import javax.inject.Inject;
import javax.validation.Valid;

import mx.mauricioabisay.phc.entities.Paciente;
import mx.mauricioabisay.phc.forms.PacienteForm;
import mx.mauricioabisay.phc.repositories.PacienteRepository;
import mx.mauricioabisay.phc.session.PacienteSummary;
import mx.mauricioabisay.phc.session.Usuario;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("paciente")
@SessionAttributes({"pacienteSummary", "usuario"})
public class PacienteController {
	@Inject PacienteRepository pacienteRepository;
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView modelAndView = new ModelAndView("paciente/create");
		modelAndView.addObject("pacienteForm", new PacienteForm());
		modelAndView.addObject("usuario", new Usuario("paciente"));
		return modelAndView;
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ModelAndView create(ModelMap model, @Valid PacienteForm form, Errors errors) {
		if(errors.hasErrors()) {
			model.put("pacienteForm", form);
			return new ModelAndView("paciente/create");
		}
		Paciente paciente = new Paciente(form);
		
		//paciente.setRfc(form.getRfc());
		//paciente.setCurp(curp);
		pacienteRepository.add(paciente);
		
		return new ModelAndView(new RedirectView("retrieve/"+paciente.getId()));
	}
	
	@RequestMapping(value = "retrieve/{pacienteId}", method = RequestMethod.GET)
	public ModelAndView retrieve(ModelMap model, @PathVariable("pacienteId") long pacienteId) {
		ModelAndView modelAndView = new ModelAndView("paciente/retrieve");
		modelAndView.addObject("usuario", new Usuario("paciente"));
		PacienteForm paciente = new PacienteForm(pacienteRepository.get(pacienteId));
		modelAndView.addObject("pacienteForm", paciente);
		modelAndView.addObject("pacienteSummary", new PacienteSummary(paciente));
		return modelAndView;
	}
	
	@RequestMapping(value = "update/{pacienteId}", method = RequestMethod.GET)
	public String update(ModelMap model, @PathVariable("pacienteId") long pacienteId) {
		model.put("pacienteForm", new PacienteForm(pacienteRepository.get(pacienteId)));
		model.put("edit", true);
		return "paciente/create";
	}
	
	@RequestMapping(value = "update/{pacienteId}", method = RequestMethod.POST)
	public ModelAndView update(@Valid PacienteForm form, Errors errors) {
		ModelAndView modelAndView = new ModelAndView("redirect:/paciente/retrieve/" + form.getId()); 
		if(errors.hasErrors()) {
			modelAndView.addObject("pacienteForm", form);
			return new ModelAndView("paciente/create");
		}
		Paciente paciente = new Paciente(form);
		paciente.setId(form.getId());
		pacienteRepository.update(paciente);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "delete/{pacienteId}", method = RequestMethod.GET)
	public String delete(@PathVariable("pacienteId") long pacienteId) {
		pacienteRepository.deleteById(pacienteId);
		return "redirect:/welcome";
	}
}
