package mx.mauricioabisay.phc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import mx.mauricioabisay.phc.enums.FormBoolean;
import mx.mauricioabisay.phc.forms.PadecimientoForm;

@Entity
@Table(name = "padecimiento")
public class Padecimiento {
	private long id;
	private String padecimiento;
	private String estado;
	private String descripcion;
	private FormBoolean tratamiento;
	private FormBoolean anterior;
	private long paciente;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_padecimiento")
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
	@Enumerated(EnumType.STRING)
	public FormBoolean getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(FormBoolean tratamiento) {
		this.tratamiento = tratamiento;
	}
	@Enumerated(EnumType.STRING)
	public FormBoolean getAnterior() {
		return anterior;
	}
	public void setAnterior(FormBoolean anterior) {
		this.anterior = anterior;
	}
	@Column(name = "paciente_fk")
	public long getPaciente() {
		return paciente;
	}
	public void setPaciente(long paciente) {
		this.paciente = paciente;
	}
	
	public Padecimiento() {}
	public Padecimiento(PadecimientoForm form) {
		this.setPadecimiento(form.getPadecimiento());
		this.setTratamiento(form.getTratamiento());
		this.setAnterior(form.getAnterior());
		this.setDescripcion(form.getDescripcion());
		this.setEstado(form.getEstado());
		this.setPaciente(form.getPaciente());
	}
}