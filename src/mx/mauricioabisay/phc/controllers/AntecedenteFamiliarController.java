package mx.mauricioabisay.phc.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import mx.mauricioabisay.form.Campo;
import mx.mauricioabisay.phc.entities.AntecedenteFamiliar;
import mx.mauricioabisay.phc.repositories.AntecedenteFamiliarRepository;
import mx.mauricioabisay.phc.session.PacienteSummary;
import mx.mauricioabisay.phc.session.Usuario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("antecedentefamiliar")
@SessionAttributes({"pacienteSummary", "usuario"})
public class AntecedenteFamiliarController {
	@Inject AntecedenteFamiliarRepository antecedenteFamiliarRespository;
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView modelAndView = new ModelAndView("antecedente_familiar/create");
		modelAndView.addObject("counter", 1);
		modelAndView.addObject("ignorar_1", false);
		modelAndView.addObject("enfermedad_1", new Campo(""));
		modelAndView.addObject("parentesco_1", new Campo(""));
		modelAndView.addObject("estado_1", new Campo(""));
		return modelAndView;
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ModelAndView create(
			@ModelAttribute PacienteSummary pacienteSummary,
			@RequestParam Map<String, String> form) {
		boolean errors = false;
		ArrayList<AntecedenteFamiliar> antecedentesFamiliares = new ArrayList<>();
		ModelAndView modelAndView = new ModelAndView();
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		
		int counter = Integer.parseInt(form.get("counter"));
		modelAndView.addObject("counter", counter);
		
		String enfermedad, parentesco, estado, ignorar;
		Campo enfermedadCampo, parentescoCampo, estadoCampo;
		AntecedenteFamiliar antecedenteAux;
		for(int i = 1; i <= counter; i++) {
			ignorar = form.get("ignorar_" + i);
			modelAndView.addObject("ignorar_" + i, ignorar.equals("si"));
			if(ignorar.equals("no")) {
				enfermedad = form.get("enfermedad_" + i);
				parentesco = form.get("parentesco_" + i);
				estado = form.get("estado_" + i);
				
				antecedenteAux = new AntecedenteFamiliar();
				antecedenteAux.setEnfermedad(enfermedad);
				antecedenteAux.setParentesco(parentesco);
				antecedenteAux.setEstado(estado);
				antecedenteAux.setCaptura(java.sql.Date.valueOf(LocalDate.now()));
				antecedenteAux.setPaciente(pacienteSummary.getId());
				
				enfermedadCampo = new Campo(enfermedad);
				parentescoCampo = new Campo(parentesco);
				estadoCampo = new Campo(estado);
				
				Set<ConstraintViolation<AntecedenteFamiliar>> violations = validator.validate(antecedenteAux);
				
				if(!violations.isEmpty()) {
					for(ConstraintViolation<AntecedenteFamiliar> error : violations) {
						switch(error.getPropertyPath().toString()) {
							case "enfermedad": {
								enfermedadCampo.setError(true);
								break;
							}
							case "parentesco": {
								parentescoCampo.setError(true);
								break;
							}
							case "estado": {
								estadoCampo.setError(true);
								break;
							}
						}
					}
					errors = true;
				} else {
					if(!errors) {
						antecedentesFamiliares.add(antecedenteAux);
					}
				}
				modelAndView.addObject("enfermedad_" + i, enfermedadCampo);
				modelAndView.addObject("parentesco_" + i, parentescoCampo);
				modelAndView.addObject("estado_" + i, estadoCampo);
			}
		}
		
		if(errors) {
			modelAndView.setViewName("antecedente_familiar/create");
		} else {
			for(AntecedenteFamiliar antecedente : antecedentesFamiliares) {
				this.antecedenteFamiliarRespository.add(antecedente);
			}
			modelAndView.clear();
			modelAndView.setViewName("redirect:/antecedentefamiliar/" + pacienteSummary.getId());
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/{pacienteId}", method = RequestMethod.GET)
	public ModelAndView list(@PathVariable("pacienteId") long idPaciente, @ModelAttribute Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("antecedente_familiar/list");
		usuario.setCurrent("antecedenteFamiliar");
		modelAndView.addObject("antecedentesFamiliares", antecedenteFamiliarRespository.selectAllFromPaciente(idPaciente));
		
		return modelAndView;
	}
	
	@RequestMapping(value = "delete/{antecedenteFamiliarId}", method = RequestMethod.GET)
	public String delete(
			@ModelAttribute PacienteSummary pacienteSummary,
			@PathVariable("antecedenteFamiliarId") long antecedenteFamiliarId) {
		antecedenteFamiliarRespository.deleteById(antecedenteFamiliarId);
		return "redirect:/antecedentefamiliar/" + pacienteSummary.getId();
	}
}
