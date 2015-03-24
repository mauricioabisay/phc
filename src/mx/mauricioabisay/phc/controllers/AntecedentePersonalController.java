package mx.mauricioabisay.phc.controllers;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;

import mx.mauricioabisay.form.Campo;
import mx.mauricioabisay.phc.entities.AntecedentePersonal;
import mx.mauricioabisay.phc.entities.Ejercicio;
import mx.mauricioabisay.phc.enums.FormBoolean;
import mx.mauricioabisay.phc.forms.AntecedentePersonalForm;
import mx.mauricioabisay.phc.repositories.AntecedentePersonalRepository;
import mx.mauricioabisay.phc.repositories.EjercicioRepository;
import mx.mauricioabisay.phc.session.PacienteSummary;
import mx.mauricioabisay.phc.session.Usuario;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("antecedentepersonal")
@SessionAttributes({"pacienteSummary", "usuario"})
public class AntecedentePersonalController {
	@Inject AntecedentePersonalRepository antecedentePersonalRepository;
	@Inject EjercicioRepository ejercicioRepository;
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public ModelAndView create(@ModelAttribute PacienteSummary pacienteSummary) {
		ModelAndView modelAndView = new ModelAndView("antecedente_personal/create");
		AntecedentePersonalForm form = new AntecedentePersonalForm();
		if(pacienteSummary.getSexo().equals("Hombre")) {
			form.setEmbarazo(FormBoolean.no);
			form.setLactancia(FormBoolean.no);
			form.setGesta(0);
			form.setSemanas_embarazo(0);
		}
		form.setCounter(1);
		modelAndView.addObject("antecedentePersonalForm", form);
		modelAndView.addObject("ignorar_1", false);
		modelAndView.addObject("ejercicio_1", new Campo(""));
		modelAndView.addObject("tipo_1", new Campo(""));
		modelAndView.addObject("frec_valor_1", new Campo("0"));
		modelAndView.addObject("frec_tipo_1", new Campo(""));
		
		return modelAndView;
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ModelAndView create(@Valid AntecedentePersonalForm form, Errors errors, 
			@RequestParam Map<String, String> fullForm,
			@ModelAttribute PacienteSummary pacienteSummary) {
		ModelAndView modelAndView = new ModelAndView("antecedente_personal/create");
		modelAndView.addObject("antecedentePersonalForm", form);
		
		if(errors.hasErrors()) {
			return modelAndView;
		}
		
		boolean errores = false;
		ArrayList<Ejercicio> ejercicios = new ArrayList<>();
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		
		int counter = form.getCounter();
		String ejercicio, tipo, frecuenciaTipo, ignorar;
		int frecuenciaValor;
		Campo ejercicioCampo, tipoCampo, frecuenciaValorCampo, frecuenciaTipoCampo;
		Ejercicio ejercicioAux;
		for(int i = 1; i <= counter; i++) {
			ignorar = fullForm.get("ignorar_" + i);
			modelAndView.addObject("ignorar_" + i, ignorar.equals("si"));
			if(ignorar.equals("no")) {
				ejercicio = fullForm.get("ejercicio_" + i);
				tipo = fullForm.get("ejerciciotipo_" + i);
				try {
					frecuenciaValor = Integer.parseInt(fullForm.get("ejerciciofrecvalor_" + i));
				}catch(Exception e) {
					frecuenciaValor = 0;
				}
				
				frecuenciaTipo = fullForm.get("ejerciciofrectipo_" + i);
				
				ejercicioAux = new Ejercicio();
				ejercicioAux.setEjercicio(ejercicio);
				ejercicioAux.setTipo(tipo);
				ejercicioAux.setFrecuenciaValor(frecuenciaValor);
				ejercicioAux.setFrecuenciaTipo(frecuenciaTipo);
				ejercicioAux.setPaciente(pacienteSummary.getId());
				
				ejercicioCampo = new Campo(ejercicio);
				tipoCampo = new Campo(tipo);
				frecuenciaValorCampo = new Campo(String.valueOf(frecuenciaValor));
				frecuenciaTipoCampo = new Campo(frecuenciaTipo);
				
				Set<ConstraintViolation<Ejercicio>> violations = validator.validate(ejercicioAux);
				
				if(!violations.isEmpty()) {
					for(ConstraintViolation<Ejercicio> error : violations) {
						switch(error.getPropertyPath().toString()) {
							case "ejercicio": {
								ejercicioCampo.setError(true);
								break;
							}
							case "tipo": {
								tipoCampo.setError(true);
								break;
							}
							case "frecuenciaValor": {
								frecuenciaValorCampo.setError(true);
								break;
							}
							case "frecuenciaTipo": {
								frecuenciaTipoCampo.setError(true);
								break;
							}
						}
					}
					errores = true;
				} else {
					if(!errores) {
						ejercicios.add(ejercicioAux);
					}
				}
				modelAndView.addObject("ejercicio_" + i, ejercicioCampo);
				modelAndView.addObject("tipo_" + i, tipoCampo);
				modelAndView.addObject("frec_valor_" + i, frecuenciaValorCampo);
				modelAndView.addObject("frec_tipo_" + i, frecuenciaTipoCampo);
			}
		}
		
		if(form.getEjercicio().equals(FormBoolean.si)) {
			if(!errores) {
				for(Ejercicio e : ejercicios) {
					ejercicioRepository.add(e);
				}
			}else {
				return modelAndView;
			}
		}
		form.setPaciente(pacienteSummary.getId());
		form.setFecha(Date.valueOf(LocalDate.now()));
		antecedentePersonalRepository.add(new AntecedentePersonal(form));
		modelAndView.clear();
		modelAndView.setViewName("antecedente_personal/retrieve");
		return modelAndView;
	}
	
	@RequestMapping(value = "/{pacienteId}", method = RequestMethod.GET)
	public ModelAndView retrieve(@PathVariable("pacienteId") long idPaciente, @ModelAttribute Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView();
		usuario.setCurrent("antecedentePersonal");
		if(antecedentePersonalRepository.pacienteHasAntecedente(idPaciente)) {
			List<AntecedentePersonal> items = antecedentePersonalRepository.selectAllFromPaciente(idPaciente);
			AntecedentePersonalForm aux = new AntecedentePersonalForm();
			for(AntecedentePersonal item : items) {
				aux = new AntecedentePersonalForm(item);
			}
			List<Ejercicio> ejercicios = ejercicioRepository.selectAllFromPaciente(idPaciente);
			aux.setCounter(ejercicios.size());
			
			modelAndView.addObject("antecedentePersonalForm", aux);
			modelAndView.addObject("ejercicios", ejercicios);
			modelAndView.setViewName("antecedente_personal/retrieve");
		} else {
			modelAndView.setViewName("redirect:/antecedentepersonal/create");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "update/{antecedenteId}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("antecedenteId") long idAntecedente) {
		ModelAndView modelAndView = new ModelAndView("antecedente_personal/create");
		
		AntecedentePersonalForm aux = new AntecedentePersonalForm(antecedentePersonalRepository.get(idAntecedente));
		List<Ejercicio> ejercicios = ejercicioRepository.selectAllFromPaciente(aux.getPaciente());
		aux.setCounter(ejercicios.size());
		
		modelAndView.addObject("antecedentePersonalForm", aux);
		int i = 1;
		for(Ejercicio e : ejercicios) {
			modelAndView.addObject("ignorar_" + i, false);
			modelAndView.addObject("id_ejercicio_" + i, new Campo(String.valueOf(e.getId())));
			modelAndView.addObject("ejercicio_" + i, new Campo(e.getEjercicio()));
			modelAndView.addObject("tipo_" + i, new Campo(e.getTipo()));
			modelAndView.addObject("frec_valor_" + i, new Campo(String.valueOf(e.getFrecuenciaValor())));
			modelAndView.addObject("frec_tipo_" + i, new Campo(e.getFrecuenciaTipo()));
			i++;
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "update/{antecedenteId}", method = RequestMethod.POST)
	public ModelAndView update(@Valid AntecedentePersonalForm form, Errors errors, @RequestParam Map<String, String> fullForm) {
		ModelAndView modelAndView = new ModelAndView("antecedente_personal/create");
		modelAndView.addObject("antecedentePersonalForm", form);
		
		if(errors.hasErrors()) {
			return modelAndView;
		}
		
		boolean errores = false;
		ArrayList<Ejercicio> ejercicios = new ArrayList<>();
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		
		int counter = form.getCounter();
		String ejercicio, tipo, frecuenciaTipo, ignorar;
		int frecuenciaValor;
		long id;
		Campo idEjercicioCampo, ejercicioCampo, tipoCampo, frecuenciaValorCampo, frecuenciaTipoCampo;
		Ejercicio ejercicioAux;
		for(int i = 1; i <= counter; i++) {
			ignorar = fullForm.get("ignorar_" + i);
			modelAndView.addObject("ignorar_" + i, ignorar.equals("si"));
			if(ignorar.equals("no")) {
				id = Long.parseLong(fullForm.get("id_" + i));
				ejercicio = fullForm.get("ejercicio_" + i);
				tipo = fullForm.get("ejerciciotipo_" + i);
				try {
					frecuenciaValor = Integer.parseInt(fullForm.get("ejerciciofrecvalor_" + i));
				}catch(Exception e) {
					frecuenciaValor = 0;
				}
				
				frecuenciaTipo = fullForm.get("ejerciciofrectipo_" + i);
				
				ejercicioAux = new Ejercicio();
				ejercicioAux.setId(id);
				ejercicioAux.setEjercicio(ejercicio);
				ejercicioAux.setTipo(tipo);
				ejercicioAux.setFrecuenciaValor(frecuenciaValor);
				ejercicioAux.setFrecuenciaTipo(frecuenciaTipo);
				ejercicioAux.setPaciente(form.getPaciente());
				
				idEjercicioCampo = new Campo(String.valueOf(id));
				ejercicioCampo = new Campo(ejercicio);
				tipoCampo = new Campo(tipo);
				frecuenciaValorCampo = new Campo(String.valueOf(frecuenciaValor));
				frecuenciaTipoCampo = new Campo(frecuenciaTipo);
				
				Set<ConstraintViolation<Ejercicio>> violations = validator.validate(ejercicioAux);
				
				if(!violations.isEmpty()) {
					for(ConstraintViolation<Ejercicio> error : violations) {
						switch(error.getPropertyPath().toString()) {
							case "ejercicio": {
								ejercicioCampo.setError(true);
								break;
							}
							case "tipo": {
								tipoCampo.setError(true);
								break;
							}
							case "frecuenciaValor": {
								frecuenciaValorCampo.setError(true);
								break;
							}
							case "frecuenciaTipo": {
								frecuenciaTipoCampo.setError(true);
								break;
							}
						}
					}
					errores = true;
				} else {
					if(!errores) {
						ejercicios.add(ejercicioAux);
					}
				}
				modelAndView.addObject("id_ejercicio_" + i, idEjercicioCampo);
				modelAndView.addObject("ejercicio_" + i, ejercicioCampo);
				modelAndView.addObject("tipo_" + i, tipoCampo);
				modelAndView.addObject("frec_valor_" + i, frecuenciaValorCampo);
				modelAndView.addObject("frec_tipo_" + i, frecuenciaTipoCampo);
			}
		}
		
		if(form.getEjercicio().equals(FormBoolean.si)) {
			if(!errores) {
				for(Ejercicio e : ejercicios) {
					if(e.getId() > 0) {
						ejercicioRepository.update(e);
					}else {
						ejercicioRepository.add(e);
					}
				}
			}else {
				return modelAndView;
			}
		}
		form.setFecha(Date.valueOf(LocalDate.now()));
		antecedentePersonalRepository.update(new AntecedentePersonal(form));
		modelAndView.clear();
		modelAndView.setViewName("redirect:/antecedentepersonal/" + form.getPaciente());
		return modelAndView;
	}
	
	@RequestMapping(value = "deleteejercicio/{ejercicioId}")
	public String deleteEjercicio(@PathVariable("ejercicioId") long idEjercicio,
			@ModelAttribute PacienteSummary pacienteSummary) {
		
		ejercicioRepository.deleteById(idEjercicio);
		return "redirect:/antecedentepersonal/" + pacienteSummary.getId();
	}
	
}
