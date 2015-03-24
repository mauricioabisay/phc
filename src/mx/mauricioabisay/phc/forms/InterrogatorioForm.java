package mx.mauricioabisay.phc.forms;

import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import mx.mauricioabisay.phc.entities.Interrogatorio;
import mx.mauricioabisay.validation.Trim;

public class InterrogatorioForm {
	@NotNull
	@Min(0)
	private long id = 0;
	@Trim
	private String gastro_intestinal;
	@Trim
	private String respiratorio;
	@Trim
	private String cardiovascular;
	@Trim
	private String genito_urinario;
	@Trim
	private String esfera_mental;
	@Trim
	private String psicosomatico;
	@Trim
	private String otorrino_laringologico;
	@Trim
	private String musculo_esqueletico;
	@Trim
	private String endocrino;
	@Trim
	private String observaciones;
	
	private Date fecha;
	private long paciente;
	private String fechaString;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getGastro_intestinal() {
		return gastro_intestinal;
	}
	public void setGastro_intestinal(String gastro_intestinal) {
		this.gastro_intestinal = gastro_intestinal;
	}
	public String getRespiratorio() {
		return respiratorio;
	}
	public void setRespiratorio(String respiratorio) {
		this.respiratorio = respiratorio;
	}
	public String getCardiovascular() {
		return cardiovascular;
	}
	public void setCardiovascular(String cardiovascular) {
		this.cardiovascular = cardiovascular;
	}
	public String getGenito_urinario() {
		return genito_urinario;
	}
	public void setGenito_urinario(String genito_urinario) {
		this.genito_urinario = genito_urinario;
	}
	public String getEsfera_mental() {
		return esfera_mental;
	}
	public void setEsfera_mental(String esfera_mental) {
		this.esfera_mental = esfera_mental;
	}
	public String getPsicosomatico() {
		return psicosomatico;
	}
	public void setPsicosomatico(String psicosomatico) {
		this.psicosomatico = psicosomatico;
	}
	public String getOtorrino_laringologico() {
		return otorrino_laringologico;
	}
	public void setOtorrino_laringologico(String otorrino_laringologico) {
		this.otorrino_laringologico = otorrino_laringologico;
	}
	public String getMusculo_esqueletico() {
		return musculo_esqueletico;
	}
	public void setMusculo_esqueletico(String musculo_esqueletico) {
		this.musculo_esqueletico = musculo_esqueletico;
	}
	public String getEndocrino() {
		return endocrino;
	}
	public void setEndocrino(String endocrino) {
		this.endocrino = endocrino;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public long getPaciente() {
		return paciente;
	}
	public void setPaciente(long paciente) {
		this.paciente = paciente;
	}
	public String getFechaString() {
		return fechaString;
	}
	public void setFechaString(String fechaString) {
		this.fechaString = fechaString;
	}
	
	public InterrogatorioForm() {}
	
	public InterrogatorioForm(Interrogatorio i) {
		this.setId(i.getId());
		this.setCardiovascular(i.getCardiovascular());
		this.setEndocrino(i.getEndocrino());
		this.setEsfera_mental(i.getEsferaMental());
		this.setFecha(i.getFecha());
		this.setFechaString(this.fecha.toLocalDate().format(
				DateTimeFormatter.ofPattern("dd/MMMM/YYYY", Locale.forLanguageTag("es-MX"))
				));
		this.setGastro_intestinal(i.getGastroIntestinal());
		this.setGenito_urinario(i.getGenitoUrinario());
		this.setMusculo_esqueletico(i.getMusculoEsqueletico());
		this.setOtorrino_laringologico(i.getOtorrinoLaringologico());
		this.setPsicosomatico(i.getPsicosomatico());
		this.setRespiratorio(i.getRespiratorio());
		this.setObservaciones(i.getObservaciones());
		this.setPaciente(i.getPaciente());
	}
}
