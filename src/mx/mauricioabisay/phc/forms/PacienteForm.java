package mx.mauricioabisay.phc.forms;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.TextStyle;
import java.util.Locale;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import mx.mauricioabisay.phc.entities.Paciente;
import mx.mauricioabisay.phc.enums.FormBoolean;
import mx.mauricioabisay.validation.Trim;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class PacienteForm {
	
	@NotNull
	@Min(0)
	private long id = 0;
	
	@NotEmpty(message = "El nombre debe especificarse")
	private String nombre;
	
	@NotEmpty(message = "El apellido paterno debe especificarse")
	private String ap;
	
	@NotEmpty(message = "El apellido materno debe especificarse")
	private String am;
	
	@NotNull(message = "La fecha de nacimiento debe especificarse")
	@Min(1)
	@Max(31)
	private Integer dd;
	
	@NotNull(message = "La fecha de nacimiento debe especificarse")
	@Min(1)
	@Max(12)
	private Integer mm;
	
	@NotNull(message = "La fecha de nacimiento debe especificarse")
	@Digits(integer=4, fraction=0)
	private Integer aaaa;
	
	@NotEmpty(message = "El sexo debe espcificarse")
	private String sexo;
	
	@NotEmpty(message = "El sexo debe espcificarse")
	private String edo_civil;
	
	@NotEmpty(message = "La ocupación debe especificarse")
	private String ocupacion;
	
	@NotEmpty(message = "La calle debe especificarse")
	private String calle;
	
	@NotEmpty(message = "El número exterior debe especificarse")
	private String num_ext;
	
	@Trim(message = "Num.Int. no debe contener caracteres vacíos")
	private String num_int;
	
	@NotBlank(message = "Colonia debe especificarse")
	private String colonia;
	
	@NotBlank(message = "Ciudad debe especificarse")
	private String ciudad;
	
	@NotBlank(message = "Estado debe especificarse")
	private String estado = "PUE";
	
	@NotBlank(message = "C.P. debe especificarse")
	private String cp;
	
	//@NotBlank
	//private String pais;
	
	@Trim
	@Length(min = 0, max = 3)
	private String tel_lada = "222";
	@Trim
	@Length(min = 0, max = 1)
	private String tel_1;
	@Trim
	@Length(min = 0, max = 2)
	private String tel_2;
	@Trim
	@Length(min = 0, max = 2)
	private String tel_3;
	@Trim
	@Length(min = 0, max = 2)
	private String tel_4;
	
	@Trim
	@Length(min = 0, max = 2)
	private String cel_1 = "22";
	@Trim
	@Length(min = 0, max = 2)
	private String cel_2;
	@Trim
	@Length(min = 0, max = 2)
	private String cel_3;
	@Trim
	@Length(min = 0, max = 2)
	private String cel_4;
	@Trim
	@Length(min = 0, max = 2)
	private String cel_5;
	
	@NotEmpty(message = "Debe especificarse si el paciente ha sido recomendado")
	private String recomendado_boolean;
	
	@Trim(message = "Recomendado no debe contener espacios vacíos")
	private String recomendado_por;
	
	//Retrieve specific fields
	private Period edad;
	private String fecha_nacimiento;
	private String telefono;
	private String celular;
	
	//Constructors
	
	public PacienteForm() {}
	
	public PacienteForm(Paciente paciente) {
		
		this.setId(paciente.getId());
		this.setNombre(paciente.getNombre());
		this.setAp(paciente.getApellidoPaterno());
		this.setAm(paciente.getApellidoMaterno());
		
		LocalDate birthday = paciente.getFechaNacimiento().toLocalDate();
		int year = birthday.getYear();
		int month = birthday.getMonthValue();
		int day = birthday.getDayOfMonth();
		
		this.edad = Period.between(birthday, LocalDate.now());
		this.fecha_nacimiento = day + " / " + 
								birthday.getMonth().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("es-MX")).toUpperCase() 
								+ " / " + year;
		this.setAaaa(year);
		this.setMm(month);
		this.setDd(day);
		this.setSexo(paciente.getSexo().toString());
		this.setEdo_civil(paciente.getEstadoCivil().toString());
		this.setOcupacion(paciente.getOcupacion());
		
		String telefono;
		telefono = paciente.getTelefono();
		this.setTelefono(telefono);
		if(telefono != null && telefono.length() > 3) {
			this.setTel_lada(telefono.substring(0, 2));
			this.setTel_1(telefono.substring(3, 3));
			this.setTel_2(telefono.substring(4, 5));
			this.setTel_3(telefono.substring(6, 7));
			this.setTel_4(telefono.substring(8, 9));
		}
		
		telefono = paciente.getCelular();
		this.setCelular(telefono);
		if(telefono != null && telefono.length() > 2) {
			this.setCel_1(telefono.substring(0, 1));
			this.setCel_2(telefono.substring(2, 3));
			this.setCel_3(telefono.substring(4, 5));
			this.setCel_4(telefono.substring(6, 7));
			this.setCel_5(telefono.substring(8, 9));
		}
		
		this.setCalle(paciente.getCalle());
		this.setNum_ext(paciente.getNumeroExterior());
		this.setNum_int(paciente.getNumeroInterior());
		this.setColonia(paciente.getColonia());
		this.setCiudad(paciente.getCiudad());
		this.setEstado(paciente.getEstado());
		this.setCp(paciente.getCodigoPostal());
		
		String recomendadoPor = paciente.getRecomendadoPor();
		if(recomendadoPor != null) {
			this.recomendado_boolean = FormBoolean.si.toString();
			this.setRecomendado_por(recomendadoPor);
		} else {
			this.recomendado_boolean = FormBoolean.no.toString();
		}
		
	}
	
	//Getters and Setters
	
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

	public String getAp() {
		return ap;
	}

	public void setAp(String ap) {
		this.ap = ap;
	}

	public String getAm() {
		return am;
	}

	public void setAm(String am) {
		this.am = am;
	}

	public Integer getDd() {
		return dd;
	}

	public void setDd(Integer dd) {
		this.dd = dd;
	}

	public Integer getMm() {
		return mm;
	}

	public void setMm(Integer mm) {
		this.mm = mm;
	}

	public Integer getAaaa() {
		return aaaa;
	}

	public void setAaaa(Integer aaaa) {
		this.aaaa = aaaa;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEdo_civil() {
		return edo_civil;
	}

	public void setEdo_civil(String edo_civil) {
		this.edo_civil = edo_civil;
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

	public String getNum_ext() {
		return num_ext;
	}

	public void setNum_ext(String num_ext) {
		this.num_ext = num_ext;
	}

	public String getNum_int() {
		return num_int;
	}

	public void setNum_int(String num_int) {
		this.num_int = num_int;
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

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getTel_lada() {
		return tel_lada;
	}

	public void setTel_lada(String tel_lada) {
		this.tel_lada = tel_lada;
	}

	public String getTel_1() {
		return tel_1;
	}

	public void setTel_1(String tel_1) {
		this.tel_1 = tel_1;
	}

	public String getTel_2() {
		return tel_2;
	}

	public void setTel_2(String tel_2) {
		this.tel_2 = tel_2;
	}

	public String getTel_3() {
		return tel_3;
	}

	public void setTel_3(String tel_3) {
		this.tel_3 = tel_3;
	}

	public String getTel_4() {
		return tel_4;
	}

	public void setTel_4(String tel_4) {
		this.tel_4 = tel_4;
	}

	public String getCel_1() {
		return cel_1;
	}

	public void setCel_1(String cel_1) {
		this.cel_1 = cel_1;
	}

	public String getCel_2() {
		return cel_2;
	}

	public void setCel_2(String cel_2) {
		this.cel_2 = cel_2;
	}

	public String getCel_3() {
		return cel_3;
	}

	public void setCel_3(String cel_3) {
		this.cel_3 = cel_3;
	}

	public String getCel_4() {
		return cel_4;
	}

	public void setCel_4(String cel_4) {
		this.cel_4 = cel_4;
	}

	public String getCel_5() {
		return cel_5;
	}

	public void setCel_5(String cel_5) {
		this.cel_5 = cel_5;
	}

	public String getRecomendado_boolean() {
		return recomendado_boolean;
	}

	public void setRecomendado_boolean(String recomendado_boolean) {
		this.recomendado_boolean = recomendado_boolean;
	}

	public String getRecomendado_por() {
		return recomendado_por;
	}

	public void setRecomendado_por(String recomendado_por) {
		this.recomendado_por = recomendado_por;
	}

	public String getEdad() {
		return edad.getYears() + " años " + edad.getMonths() + " meses " + edad.getDays() + " días";
	}

	public void setEdad(Period edad) {
		this.edad = edad;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
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
}
