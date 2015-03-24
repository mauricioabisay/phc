package mx.mauricioabisay.phc.controllers;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;

import mx.mauricioabisay.form.Campo;
import mx.mauricioabisay.phc.entities.Padecimiento;
import mx.mauricioabisay.phc.entities.Tratamiento;
import mx.mauricioabisay.phc.enums.FormBoolean;
import mx.mauricioabisay.phc.enums.TipoTratamiento;
import mx.mauricioabisay.phc.forms.PadecimientoForm;
import mx.mauricioabisay.phc.repositories.PadecimientoRepository;
import mx.mauricioabisay.phc.repositories.TratamientoRepository;
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
@RequestMapping("padecimiento")
@SessionAttributes({"pacienteSummary", "usuario"})
public class PadecimientoController {
	@Inject PadecimientoRepository padecimientoRepository;
	@Inject TratamientoRepository tratamientoRepository;
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView modelAndView = new ModelAndView("padecimiento/create");
		
		PadecimientoForm padecimientoForm = new PadecimientoForm();
		padecimientoForm.setCounter(1);
		modelAndView.addObject("padecimientoForm", padecimientoForm);
		modelAndView.addObject("ignorar_1", false);
		modelAndView.addObject("tratamiento_1", new Campo(""));
		modelAndView.addObject("tipo_1", new Campo(""));
		modelAndView.addObject("descripcion_1", new Campo(""));
		return modelAndView;
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ModelAndView create(@Valid PadecimientoForm form, Errors errors, 
			@RequestParam Map<String, String> fullForm, 
			@ModelAttribute PacienteSummary pacienteSummary) {
		ModelAndView modelAndView = new ModelAndView("padecimiento/create");
		form.setAnterior(FormBoolean.si);
		if(errors.hasErrors()) {
			modelAndView.addObject("padecimientoForm", form);
			return modelAndView;
		}
		
		boolean errores = false;
		ArrayList<Tratamiento> tratamientos = new ArrayList<>();
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		
		if(form.getTratamiento().equals(FormBoolean.si)) {
			int counter = form.getCounter();
			String tratamiento, tipo, descripcion, ignorar;
			Campo tratamientoCampo, tipoCampo, descripcionCampo;
			Tratamiento tratamientoAux;
			for(int i = 1; i <= counter; i++) {
				ignorar = fullForm.get("ignorar_" + i);
				modelAndView.addObject("ignorar_" + i, ignorar.equals("si"));
				if(ignorar.equals("no")) {
					tratamiento = fullForm.get("tratamiento_" + i);
					tipo = fullForm.get("tipo_" + i);
					descripcion = fullForm.get("descripcion_" + i);
					
					tratamientoAux = new Tratamiento();
					tratamientoAux.setDescripcion(descripcion);
					tratamientoAux.setTipo(TipoTratamiento.valueOf(tipo));
					tratamientoAux.setTratamiento(tratamiento);
					
					tratamientoCampo = new Campo(tratamiento);
					tipoCampo = new Campo(tipo);
					descripcionCampo = new Campo(descripcion);
					
					Set<ConstraintViolation<Tratamiento>> violations = validator.validate(tratamientoAux);
					
					if(!violations.isEmpty()) {
						for(ConstraintViolation<Tratamiento> error : violations) {
							switch(error.getPropertyPath().toString()) {
							case "tratamiento": {
								tratamientoCampo.setError(true);
								break;
							}
							case "tipo": {
								tipoCampo.setError(true);
								break;
							}
							case "descripcion": {
								descripcionCampo.setError(true);
								break;
							}
							}
						}
						errores = true;
					} else {
						if(!errores) {
							tratamientos.add(tratamientoAux);
						}
					}
					modelAndView.addObject("tratamiento_" + i, tratamientoCampo);
					modelAndView.addObject("tipo_" + i, tipoCampo);
					modelAndView.addObject("descripcion_" + i, descripcionCampo);
				}
			}
		}
		
		if(!errores) {
			form.setPaciente(pacienteSummary.getId());
			Padecimiento padecimientoAux = new Padecimiento(form);
			padecimientoRepository.add(padecimientoAux);
			for(Tratamiento t: tratamientos) {
				t.setPadecimiento(padecimientoAux.getId());
				tratamientoRepository.add(t);
			}
		} else {
			return modelAndView;
		}
		modelAndView.clear();
		modelAndView.setViewName("redirect:/padecimiento/" + pacienteSummary.getId());
		return modelAndView;
	}
	
	@RequestMapping(value = "/{pacienteId}", method = RequestMethod.GET)
	public ModelAndView list(@PathVariable("pacienteId") long idPaciente, @ModelAttribute Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("padecimiento/list");
		usuario.setCurrent("padecimiento");
		modelAndView.addObject("antecedentesPatologicos", padecimientoRepository.selectAllFromPaciente(idPaciente));
		return modelAndView;
	}
	
	@RequestMapping(value = "/retrieve/{padecimientoId}", method = RequestMethod.GET)
	public ModelAndView retrieve(@PathVariable("padecimientoId") long idPadecimiento) {
		ModelAndView modelAndView = new ModelAndView("padecimiento/retrieve");
		modelAndView.addObject("padecimiento", padecimientoRepository.get(idPadecimiento));
		modelAndView.addObject("tratamientos", tratamientoRepository.selectAllFromPadecimiento(idPadecimiento));
		return modelAndView;
	}
	
	@RequestMapping(value = "/delete/{padecimientoId}", method = RequestMethod.GET)
	public String delete(@PathVariable("padecimientoId") long idPadecimiento, 
			@ModelAttribute PacienteSummary pacienteSummary) {
		tratamientoRepository.deleteByPadecimiento(idPadecimiento);
		padecimientoRepository.deleteById(idPadecimiento);
		return "redirect:/padecimiento/" + pacienteSummary.getId();
	}
}
