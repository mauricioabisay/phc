package mx.mauricioabisay.phc.session;

import java.io.Serializable;

import mx.mauricioabisay.phc.enums.Sexo;
import mx.mauricioabisay.phc.forms.PacienteForm;

public class PacienteSummary implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String edad;
	private String sexo;
	
	public PacienteSummary(PacienteForm paciente) {
		this.id = paciente.getId();
		this.nombre = paciente.getNombre();
		this.apellidoPaterno = paciente.getAp();
		this.apellidoMaterno = paciente.getAm();
		this.edad = paciente.getEdad();
		this.sexo = Sexo.M.name().equals(paciente.getSexo())? "Hombre" : "Mujer";
	}
	
	public PacienteSummary(long id, String nombre, String apellidoPaterno, String apellidoMaterno, String edad)  {
		this.id = id;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.edad = edad;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
