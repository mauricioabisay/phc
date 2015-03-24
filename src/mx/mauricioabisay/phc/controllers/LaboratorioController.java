package mx.mauricioabisay.phc.controllers;

import java.sql.Date;
import java.time.LocalDate;

import javax.inject.Inject;
import javax.validation.Valid;

import mx.mauricioabisay.phc.entities.Laboratorio;
import mx.mauricioabisay.phc.forms.LaboratorioForm;
import mx.mauricioabisay.phc.repositories.LaboratorioRepository;
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
@RequestMapping("laboratorio")
@SessionAttributes({"pacienteSummary", "usuario"})
public class LaboratorioController {
	@Inject LaboratorioRepository laboratorioRespository;
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView modelAndView = new ModelAndView("laboratorio/create");
		modelAndView.addObject("laboratorioForm", new LaboratorioForm());
		/*
		modelAndView.addObject("counter", 1);
		modelAndView.addObject("ignorar_1", false);
		modelAndView.addObject("laboratorio_1", new Campo(""));
		modelAndView.addObject("tipo_1", new Campo(""));
		modelAndView.addObject("estado_1", new Campo(""));
		modelAndView.addObject("observaciones_1", new Campo(""));
		*/
		return modelAndView;
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ModelAndView create(@Valid LaboratorioForm form, Errors errors, @ModelAttribute PacienteSummary pacienteSummary) {
		ModelAndView modelAndView = new ModelAndView("laboratorio/create");
		if(errors.hasErrors()) {
			modelAndView.addObject("laboratorioForm", form);
			return modelAndView;
		}
		form.setPaciente(pacienteSummary.getId());
		form.setFecha(Date.valueOf(LocalDate.now()));
		laboratorioRespository.add(new Laboratorio(form));
		modelAndView.setViewName("redirect:/laboratorio/" + pacienteSummary.getId());
		return modelAndView;
	}
	
	@RequestMapping(value = "retrieve/{laboratorioId}", method = RequestMethod.GET)
	public ModelAndView retrieve(@PathVariable("laboratorioId") long idLaboratorio) {
		ModelAndView modelAndView = new ModelAndView("laboratorio/retrieve");
		modelAndView.addObject("laboratorioForm", new LaboratorioForm(laboratorioRespository.get(idLaboratorio)));
		return modelAndView;
	}
	
	@RequestMapping(value = "update/{laboratorioId}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("laboratorioId") long idLaboratorio) {
		ModelAndView modelAndView = new ModelAndView("laboratorio/create");
		modelAndView.addObject("laboratorioForm", new LaboratorioForm(laboratorioRespository.get(idLaboratorio)));
		return modelAndView;
	}
	
	@RequestMapping(value = "update/{laboratorioId}", method = RequestMethod.POST)
	public ModelAndView update(@Valid LaboratorioForm form, Errors errors) {
		ModelAndView modelAndView = new ModelAndView("laboratorio/create");
		if(errors.hasErrors()) {
			modelAndView.addObject("laboratorioForm", form);
			return modelAndView;
		}
		form.setFecha(Date.valueOf(LocalDate.now()));
		laboratorioRespository.add(new Laboratorio(form));
		modelAndView.setViewName("redirect:/laboratorio/" + form.getPaciente());
		return modelAndView;
	}
	
	@RequestMapping(value = "/{pacienteId}", method = RequestMethod.GET)
	public ModelAndView list(@PathVariable("pacienteId") long idPaciente, @ModelAttribute Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("laboratorio/list");
		usuario.setCurrent("laboratorio");
		modelAndView.addObject("estudios", laboratorioRespository.selectAllFromPaciente(idPaciente));
		
		return modelAndView;
	}
	
	@RequestMapping(value = "delete/{laboratorioId}", method = RequestMethod.GET)
	public String delete(
			@ModelAttribute PacienteSummary pacienteSummary,
			@PathVariable("laboratorioId") long laboratorioId) {
		laboratorioRespository.deleteById(laboratorioId);
		return "redirect:/laboratorio/" + pacienteSummary.getId();
	}
	
	/*
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ModelAndView create(
			@ModelAttribute PacienteSummary pacienteSummary,
			@RequestParam Map<String, String> form) {
		boolean errors = false;
		ArrayList<Laboratorio> laboratorios = new ArrayList<>();
		ModelAndView modelAndView = new ModelAndView();
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		
		int counter = Integer.parseInt(form.get("counter"));
		modelAndView.addObject("counter", counter);
		
		String laboratorio, tipo, estado, observaciones, ignorar;
		Campo laboratorioCampo, tipoCampo, estadoCampo, observacionesCampo;
		Laboratorio laboratorioAux;
		for(int i = 1; i <= counter; i++) {
			ignorar = form.get("ignorar_" + i);
			modelAndView.addObject("ignorar_" + i, ignorar.equals("si"));
			if(ignorar.equals("no")) {
				laboratorio = form.get("laboratorio_" + i);
				tipo = form.get("tipo_" + i);
				estado = form.get("estado_" + i);
				observaciones = form.get("observaciones_" + i);
				
				laboratorioAux = new Laboratorio();
				laboratorioAux.setLaboratorio(laboratorio);
				laboratorioAux.setTipo(tipo);
				laboratorioAux.setEstado(estado);
				laboratorioAux.setObservaciones(observaciones);
				laboratorioAux.setCaptura(java.sql.Date.valueOf(LocalDate.now()));
				laboratorioAux.setPaciente(pacienteSummary.getId());
				
				laboratorioCampo = new Campo(laboratorio);
				tipoCampo = new Campo(tipo);
				estadoCampo = new Campo(estado);
				observacionesCampo = new Campo(observaciones);
				
				Set<ConstraintViolation<Laboratorio>> violations = validator.validate(laboratorioAux);
				
				if(!violations.isEmpty()) {
					for(ConstraintViolation<Laboratorio> error : violations) {
						switch(error.getPropertyPath().toString()) {
							case "laboratorio": {
								laboratorioCampo.setError(true);
								break;
							}
							case "tipo": {
								tipoCampo.setError(true);
								break;
							}
							case "estado": {
								estadoCampo.setError(true);
								break;
							}
							case "observaciones": {
								observacionesCampo.setError(true);
								break;
							}
						}
					}
					errors = true;
				} else {
					if(!errors) {
						laboratorios.add(laboratorioAux);
					}
				}
				modelAndView.addObject("laboratorio_" + i, laboratorioCampo);
				modelAndView.addObject("tipo_" + i, tipoCampo);
				modelAndView.addObject("estado_" + i, estadoCampo);
				modelAndView.addObject("observaciones_" + i, observacionesCampo);
			}
		}
		
		if(errors) {
			modelAndView.setViewName("laboratorio/create");
		} else {
			for(Laboratorio l : laboratorios) {
				laboratorioRespository.add(l);
			}
			modelAndView.clear();
			modelAndView.setViewName("redirect:/laboratorio/" + pacienteSummary.getId());
		}
		return modelAndView;
	}
	*/
}
