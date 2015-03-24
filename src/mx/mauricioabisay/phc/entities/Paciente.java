package mx.mauricioabisay.phc.entities;

import java.sql.Date;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import mx.mauricioabisay.phc.enums.EstadoCivil;
import mx.mauricioabisay.phc.enums.FormBoolean;
import mx.mauricioabisay.phc.enums.Sexo;
import mx.mauricioabisay.phc.forms.PacienteForm;

@Entity
@Table(name = "paciente")
public class Paciente {

	private long id;
	private String rfc;
	private String curp;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private Date fechaNacimiento;
	private Sexo sexo;
	private EstadoCivil estadoCivil;
	private String ocupacion;

	private String calle;
	private String numeroExterior;
	private String numeroInterior;
	private String colonia;
	private String ciudad;
	private String estado;
	private String codigoPostal;
	private String pais;

	private String telefono;
	private String celular;

	private String recomendadoPor;

	// Getters and Setters

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_paciente")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "ap")
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	@Column(name = "am")
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	@Column(name = "fecha_nacimiento")
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Enumerated(EnumType.STRING)
	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	@Column(name = "edo_civil")
	@Enumerated(EnumType.STRING)
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	@Column(name = "num_ext")
	public String getNumeroExterior() {
		return numeroExterior;
	}

	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}

	@Column(name = "num_int")
	public String getNumeroInterior() {
		return numeroInterior;
	}

	public void setNumeroInterior(String numeroInterior) {
		this.numeroInterior = numeroInterior;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Column(name = "cp")
	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	@Column(name = "recomendado_por")
	public String getRecomendadoPor() {
		return recomendadoPor;
	}

	public void setRecomendadoPor(String recomendadoPor) {
		this.recomendadoPor = recomendadoPor;
	}

	// Constructors
	public Paciente() {
	}

	public Paciente(PacienteForm form) {
		this.setNombre(form.getNombre());
		this.setApellidoPaterno(form.getAp());
		this.setApellidoMaterno(form.getAm());

		GregorianCalendar fechaAux = new GregorianCalendar(form.getAaaa(),
				(form.getMm() - 1), form.getDd());
		this.setFechaNacimiento(new Date(fechaAux.getTimeInMillis()));

		this.setSexo(Sexo.valueOf(form.getSexo()));
		this.setOcupacion(form.getOcupacion());
		this.setEstadoCivil(EstadoCivil.valueOf(form.getEdo_civil()));

		this.setCalle(form.getCalle());
		this.setNumeroExterior(form.getNum_ext());
		this.setNumeroInterior(form.getNum_int());
		this.setCiudad(form.getCiudad());
		this.setCodigoPostal(form.getCp());
		this.setColonia(form.getColonia());
		this.setEstado(form.getEstado());

		StringBuilder telefono;
		if (form.getCel_2() != null && form.getCel_2() != "") {
			telefono = new StringBuilder();
			telefono.append(form.getCel_1());
			telefono.append(form.getCel_2());
			telefono.append(form.getCel_3());
			telefono.append(form.getCel_4());
			telefono.append(form.getCel_5());
			this.setCelular(telefono.toString());
		}

		if (form.getTel_1() != null && form.getTel_1() != "") {
			telefono = new StringBuilder();
			telefono.append(form.getTel_lada());
			telefono.append(form.getTel_1());
			telefono.append(form.getTel_2());
			telefono.append(form.getTel_3());
			telefono.append(form.getTel_4());
			this.setTelefono(telefono.toString());
		}

		if (FormBoolean.valueOf(form.getRecomendado_boolean()).equals(
				FormBoolean.si)) {
			this.setRecomendadoPor(form.getRecomendado_por());
		}
	}
}
