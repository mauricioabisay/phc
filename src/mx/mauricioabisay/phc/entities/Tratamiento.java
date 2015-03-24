package mx.mauricioabisay.phc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import mx.mauricioabisay.phc.enums.TipoTratamiento;
import mx.mauricioabisay.validation.Trim;

@Entity
@Table(name = "tratamiento")
public class Tratamiento {
	private long id;
	@NotEmpty
	private String tratamiento;
	@Trim
	private String descripcion;
	@NotNull
	private TipoTratamiento tipo;
	
	private long padecimiento;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tratamiento")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Enumerated(EnumType.STRING)
	public TipoTratamiento getTipo() {
		return tipo;
	}
	public void setTipo(TipoTratamiento tipo) {
		this.tipo = tipo;
	}
	@Column(name = "padecimiento_fk")
	public long getPadecimiento() {
		return padecimiento;
	}
	public void setPadecimiento(long padecimiento) {
		this.padecimiento = padecimiento;
	}
}
