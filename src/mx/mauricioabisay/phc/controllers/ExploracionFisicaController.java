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
import mx.mauricioabisay.phc.entities.Alergia;
import mx.mauricioabisay.phc.entities.ExploracionFisica;
import mx.mauricioabisay.phc.enums.FormBoolean;
import mx.mauricioabisay.phc.forms.ExploracionFisicaForm;
import mx.mauricioabisay.phc.repositories.AlergiaRepository;
import mx.mauricioabisay.phc.repositories.ExploracionFisicaRepository;
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
@RequestMapping("exploracionfisica")
@SessionAttributes({"pacienteSummary", "usuario"})
public class ExploracionFisicaController {
	@Inject
	ExploracionFisicaRepository exploracionFisicaRepository;
	@Inject
	AlergiaRepository alergiaRepository;

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public ModelAndView create(@ModelAttribute PacienteSummary pacienteSummary) {
		ModelAndView modelAndView = new ModelAndView(
				"exploracion_fisica/create");
		ExploracionFisicaForm form = new ExploracionFisicaForm();
		List<Alergia> alergias = alergiaRepository.selectAllFromPaciente(pacienteSummary.getId());
		
		if(alergias.isEmpty()) {
			form.setCounter(1);
			form.setAlergia(FormBoolean.no);
			modelAndView.addObject("id_1", 0);
			modelAndView.addObject("ignorar_1", false);
			modelAndView.addObject("alergia_1", new Campo(""));
		} else {
			form.setCounter(alergias.size());
			form.setAlergia(FormBoolean.si);
			int i = 1;
			for(Alergia a : alergias) {
				modelAndView.addObject("id_" + i, a.getId());
				modelAndView.addObject("ignorar_" + i, false);
				modelAndView.addObject("alergia_" + i, new Campo(a.getAlergia()));
				i++;
			}
		}
		modelAndView.addObject("exploracionFisicaForm", form);
		
		return modelAndView;
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ModelAndView create(@Valid ExploracionFisicaForm form,
			Errors errors, @RequestParam Map<String, String> fullForm,
			@ModelAttribute PacienteSummary pacienteSummary) {
		
		ModelAndView modelAndView = new ModelAndView("exploracion_fisica/create");
		if (errors.hasErrors()) {
			modelAndView.addObject("exploracionFisicaForm", form);
			return modelAndView;
		}

		boolean errores = false;
		String alergia, ignorar;
		Campo alergiaCampo;
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Alergia auxAlergia;
		ArrayList<Alergia> alergias = new ArrayList<>();
		ArrayList<Long> alergiasDelete = new ArrayList<>();
		int counter = form.getCounter();
		if (form.getAlergia().equals(FormBoolean.si)) {
			for (int i = 1; i <= counter; i++) {
				ignorar = fullForm.get("ignorar_" + i);
				modelAndView.addObject("ignorar_" + i, ignorar.equals("si"));
				if (ignorar.equals("no")) {
					auxAlergia = new Alergia();
					auxAlergia.setId(Long.valueOf(fullForm.getOrDefault("id_" + i, "0")));
					alergia = fullForm.get("alergia_" + i);
					auxAlergia.setAlergia(alergia);
					alergiaCampo = new Campo(alergia);
					auxAlergia.setPaciente(pacienteSummary.getId());
					Set<ConstraintViolation<Alergia>> violations = validator
							.validate(auxAlergia);
					if (!violations.isEmpty()) {
						for (ConstraintViolation<Alergia> a : violations) {
							switch (a.getPropertyPath().toString()) {
							case "alergia": {
								alergiaCampo.setError(true);
								break;
							}
							}
						}
						errores = true;
					} else {
						if (!errores) {
							alergias.add(auxAlergia);
						}
					}
					modelAndView.addObject("alergia_" + i, alergiaCampo);
				} else {
					long id = Long.valueOf(fullForm.get("id_" + i));
					if(id > 0) {
						alergiasDelete.add(id);
					}
				}
			}
		} else {
			alergiaRepository.deleteAllFromPaciente(pacienteSummary.getId());
		}

		if (errores) {
			modelAndView.setViewName("exploracion_fisica/create");
		} else {
			form.setPaciente(pacienteSummary.getId());
			form.setFecha(Date.valueOf(LocalDate.now()));
			exploracionFisicaRepository.add(new ExploracionFisica(form));
			for (Alergia a : alergias) {
				if(a.getId() > 0) {
					alergiaRepository.update(a);
				} else {
					alergiaRepository.add(a);
				}
			}
			for(Long id : alergiasDelete) {
				alergiaRepository.deleteById(id);
			}
			modelAndView.clear();
			modelAndView.setViewName("redirect:/exploracionfisica/" + pacienteSummary.getId());
		}
		return modelAndView;
	}

	@RequestMapping(value = "/{pacienteId}", method = RequestMethod.GET)
	public ModelAndView list(@PathVariable("pacienteId") long idPaciente, @ModelAttribute Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("exploracion_fisica/list");
		usuario.setCurrent("exploracionFisica");
		modelAndView.addObject("exploraciones",
				exploracionFisicaRepository.selectAllFromPaciente(idPaciente));
		return modelAndView;
	}
	
	@RequestMapping(value = "retrieve/{exploracionId}", method = RequestMethod.GET)
	public ModelAndView retrieve(@PathVariable("exploracionId") long idExploracion) {
		ModelAndView modelAndView = new ModelAndView("exploracion_fisica/retrieve");
		modelAndView.addObject("exploracionFisicaForm", exploracionFisicaRepository.get(idExploracion));
		return modelAndView;
	}
	
	@RequestMapping(value = "update/{exploracionId}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("exploracionId") long idExploracion) {
		ModelAndView modelAndView = new ModelAndView("exploracion_fisica/create");
		
		ExploracionFisicaForm form = new ExploracionFisicaForm(exploracionFisicaRepository.get(idExploracion));
		List<Alergia> alergias = alergiaRepository.selectAllFromPaciente(form.getPaciente());
		form.setCounter(alergias.size());
		
		if(alergias.isEmpty()) {
			form.setCounter(1);
			form.setAlergia(FormBoolean.no);
			modelAndView.addObject("id_1", 0);
			modelAndView.addObject("ignorar_1", false);
			modelAndView.addObject("alergia_1", new Campo(""));
		} else {
			form.setCounter(alergias.size());
			form.setAlergia(FormBoolean.si);
			int i = 1;
			for(Alergia a : alergias) {
				modelAndView.addObject("id_" + i, a.getId());
				modelAndView.addObject("ignorar_" + i, false);
				modelAndView.addObject("alergia_" + i, new Campo(a.getAlergia()));
				i++;
			}
		}
		modelAndView.addObject("exploracionFisicaForm", form);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "update/{exploracionId}", method = RequestMethod.POST)
	public ModelAndView update(@Valid ExploracionFisicaForm form,
			Errors errors, @RequestParam Map<String, String> fullForm) {
		
		ModelAndView modelAndView = new ModelAndView("exploracion_fisica/create");
		if (errors.hasErrors()) {
			modelAndView.addObject("exploracionFisicaForm", form);
			return modelAndView;
		}

		boolean errores = false;
		String alergia, ignorar;
		Campo alergiaCampo;
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Alergia auxAlergia;
		ArrayList<Alergia> alergias = new ArrayList<>();
		ArrayList<Long> alergiasDelete = new ArrayList<>();
		int counter = form.getCounter();
		if (form.getAlergia().equals(FormBoolean.si)) {
			for (int i = 1; i <= counter; i++) {
				ignorar = fullForm.get("ignorar_" + i);
				modelAndView.addObject("ignorar_" + i, ignorar.equals("si"));
				if (ignorar.equals("no")) {
					auxAlergia = new Alergia();
					auxAlergia.setId(Long.valueOf(fullForm.getOrDefault("id_" + i, "0")));
					alergia = fullForm.get("alergia_" + i);
					auxAlergia.setAlergia(alergia);
					alergiaCampo = new Campo(alergia);
					auxAlergia.setPaciente(form.getPaciente());
					Set<ConstraintViolation<Alergia>> violations = validator
							.validate(auxAlergia);

					if (!violations.isEmpty()) {
						for (ConstraintViolation<Alergia> a : violations) {
							switch (a.getPropertyPath().toString()) {
							case "alergia": {
								alergiaCampo.setError(true);
								break;
							}
							}
						}
						errores = true;
					} else {
						if (!errores) {
							alergias.add(auxAlergia);
						}
					}
					modelAndView.addObject("alergia_" + i, alergiaCampo);
				} else {
					long id = Long.valueOf(fullForm.get("id_" + i));
					if(id > 0) {
						alergiasDelete.add(id);
					}
				}
			}
		} else {
			alergiaRepository.deleteAllFromPaciente(form.getPaciente());
		}

		if (errores) {
			modelAndView.addObject("exploracionFisicaForm", form);
			modelAndView.addObject("alergias", alergiaRepository.selectAllFromPaciente(form.getPaciente()));
			modelAndView.setViewName("exploracion_fisica/create");
		} else {
			form.setFecha(Date.valueOf(LocalDate.now()));
			exploracionFisicaRepository.add(new ExploracionFisica(form));
			for (Alergia a : alergias) {
				if(a.getId() > 0) {
					alergiaRepository.update(a);
				} else {
					alergiaRepository.add(a);
				}
			}
			for(Long id : alergiasDelete) {
				alergiaRepository.deleteById(id);
			}
			modelAndView.clear();
			modelAndView.setViewName("redirect:/exploracionfisica/" + form.getPaciente());
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "delete/{exploracionId}", method = RequestMethod.GET)
	public String delete(@PathVariable("exploracionId") long idExploracion, 
			@ModelAttribute PacienteSummary pacienteSummary) {
		exploracionFisicaRepository.deleteById(idExploracion);
		return "redirect:/exploracionfisica/" + pacienteSummary.getId();
	}
}
