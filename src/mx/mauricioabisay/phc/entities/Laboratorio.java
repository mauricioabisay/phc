package mx.mauricioabisay.phc.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import mx.mauricioabisay.phc.forms.LaboratorioForm;

@Entity
@Table(name = "laboratorio")
public class Laboratorio {
	
	private long id;
	private String laboratorio;
	private String tipo;
	private String estado;
	private String observaciones;
	private Date fechaCaptura;
	private long paciente;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_laboratorio")
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
	@Column(name="fecha_captura")
	public Date getFechaCaptura() {
		return fechaCaptura;
	}
	public void setFechaCaptura(Date fechaCaptura) {
		this.fechaCaptura = fechaCaptura;
	}
	@Column(name="paciente_fk")
	public long getPaciente() {
		return paciente;
	}
	public void setPaciente(long paciente) {
		this.paciente = paciente;
	}
	
	public Laboratorio() {}
	public Laboratorio(LaboratorioForm form) {
		this.setLaboratorio(form.getLaboratorio());
		this.setTipo(form.getTipo());
		this.setEstado(form.getEstado());
		this.setObservaciones(form.getObservaciones());
		
		this.setFechaCaptura(form.getFecha());
		this.setPaciente(form.getPaciente());
	}
}
