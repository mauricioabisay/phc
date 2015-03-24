package mx.mauricioabisay.phc.forms;

import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import mx.mauricioabisay.phc.entities.Laboratorio;
import mx.mauricioabisay.validation.Trim;

import org.hibernate.validator.constraints.NotEmpty;

public class LaboratorioForm {
	@NotNull
	@Min(0)
	private long id = 0;
	@NotEmpty
	private String laboratorio;
	@NotEmpty
	private String tipo;
	@NotEmpty
	private String estado;
	@Trim
	private String observaciones;
	
	private Date fecha;
	private String fechaString;
	private long paciente;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
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
	public String getFechaString() {
		return fechaString;
	}
	public void setFechaString(String fechaString) {
		this.fechaString = fechaString;
	}
	public long getPaciente() {
		return paciente;
	}
	public void setPaciente(long paciente) {
		this.paciente = paciente;
	}
	
	public LaboratorioForm() {}
	public LaboratorioForm(Laboratorio l) {
		this.setId(l.getId());
		this.setLaboratorio(l.getLaboratorio());
		this.setTipo(l.getTipo());
		this.setEstado(l.getEstado());
		this.setObservaciones(l.getObservaciones());
		
		this.setPaciente(l.getPaciente());
		this.setFecha(l.getFechaCaptura());
		this.setFechaString(this.fecha.toLocalDate().format(DateTimeFormatter.ofPattern("dd/MMMM/YYYY", Locale.forLanguageTag("es-MX"))));
	}
}
