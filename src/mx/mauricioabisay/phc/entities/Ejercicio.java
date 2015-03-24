package mx.mauricioabisay.phc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="ejercicio")
public class Ejercicio {
	private long id;
	@NotEmpty
	private String ejercicio;
	@NotEmpty
	private String tipo;
	@NotNull
	@Min(1)
	private int frecuenciaValor;
	@NotEmpty
	private String frecuenciaTipo;
	@NotNull
	private long paciente;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ejercicio")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEjercicio() {
		return ejercicio;
	}
	public void setEjercicio(String ejercicio) {
		this.ejercicio = ejercicio;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Column(name = "frec_valor")
	public int getFrecuenciaValor() {
		return frecuenciaValor;
	}
	public void setFrecuenciaValor(int frecuenciaValor) {
		this.frecuenciaValor = frecuenciaValor;
	}

	@Column(name = "frec_tipo")
	public String getFrecuenciaTipo() {
		return frecuenciaTipo;
	}
	public void setFrecuenciaTipo(String frecuenciaTipo) {
		this.frecuenciaTipo = frecuenciaTipo;
	}
	@Column(name = "paciente_fk")
	public long getPaciente() {
		return paciente;
	}
	public void setPaciente(long paciente) {
		this.paciente = paciente;
	}
}
