package mx.mauricioabisay.phc.forms;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import mx.mauricioabisay.phc.entities.Padecimiento;
import mx.mauricioabisay.phc.enums.FormBoolean;
import mx.mauricioabisay.validation.Trim;

import org.hibernate.validator.constraints.NotEmpty;

public class PadecimientoForm {
	@NotNull
	@Min(0)
	private long id = 0;
	@NotEmpty
	private String padecimiento;
	@NotEmpty
	private String estado;
	@Trim
	private String descripcion;
	@NotNull
	private FormBoolean tratamiento;
	private FormBoolean anterior;
	@NotNull
	private long paciente;
	@NotNull
	private int counter;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPadecimiento() {
		return padecimiento;
	}
	public void setPadecimiento(String padecimiento) {
		this.padecimiento = padecimiento;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public FormBoolean getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(FormBoolean tratamiento) {
		this.tratamiento = tratamiento;
	}
	public FormBoolean getAnterior() {
		return anterior;
	}
	public void setAnterior(FormBoolean anterior) {
		this.anterior = anterior;
	}
	public long getPaciente() {
		return paciente;
	}
	public void setPaciente(long paciente) {
		this.paciente = paciente;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	
	public PadecimientoForm() {}
	public PadecimientoForm(Padecimiento padecimiento) {
		this.setId(padecimiento.getId());
		this.setPadecimiento(padecimiento.getPadecimiento());
		this.setEstado(padecimiento.getEstado());
		this.setDescripcion(padecimiento.getDescripcion());
		this.setTratamiento(padecimiento.getTratamiento());
		this.setAnterior(padecimiento.getAnterior());
		this.setPaciente(padecimiento.getPaciente());
	}
	
}
