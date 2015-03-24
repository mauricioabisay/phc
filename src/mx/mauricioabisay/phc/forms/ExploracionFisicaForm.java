package mx.mauricioabisay.phc.forms;

import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import mx.mauricioabisay.phc.entities.ExploracionFisica;
import mx.mauricioabisay.phc.enums.FormBoolean;
import mx.mauricioabisay.validation.Trim;

public class ExploracionFisicaForm {
	@NotNull
	@Min(0)
	private long id = 0;
	
	@Trim
	private String habitus;
	
	@NotNull
	private double temperatura;
	@NotNull
	private int presion_arterial_sistolica;
	@NotNull
	private int presion_arterial_diastolica;
	@NotNull
	private int frec_cardiaca;
	@NotNull
	private int frec_respiratoria;
	
	@NotNull
	private double peso;
	@NotNull
	private double estatura;
	
	@Trim
	private String cabeza;
	@Trim
	private String ojos;
	@Trim
	private String garganta;
	@Trim
	private String nariz;
	@Trim
	private String oido;
	@Trim
	private String torax;
	@Trim
	private String abdomen;
	@Trim
	private String genitales;
	@Trim
	private String miembros;
	
	@Trim
	private String observaciones;
	@NotNull
	private FormBoolean alergia;
	@NotNull
	private int counter;
	
	private long paciente;
	private Date fecha;
	private String fechaString;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getHabitus() {
		return habitus;
	}
	public void setHabitus(String habitus) {
		this.habitus = habitus;
	}
	public double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}
	public int getPresion_arterial_sistolica() {
		return presion_arterial_sistolica;
	}
	public void setPresion_arterial_sistolica(int presion_arterial_sistolica) {
		this.presion_arterial_sistolica = presion_arterial_sistolica;
	}
	public int getPresion_arterial_diastolica() {
		return presion_arterial_diastolica;
	}
	public void setPresion_arterial_diastolica(int presion_arterial_diastolica) {
		this.presion_arterial_diastolica = presion_arterial_diastolica;
	}
	public int getFrec_cardiaca() {
		return frec_cardiaca;
	}
	public void setFrec_cardiaca(int frec_cardiaca) {
		this.frec_cardiaca = frec_cardiaca;
	}
	public int getFrec_respiratoria() {
		return frec_respiratoria;
	}
	public void setFrec_respiratoria(int frec_respiratoria) {
		this.frec_respiratoria = frec_respiratoria;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getEstatura() {
		return estatura;
	}
	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}
	public String getCabeza() {
		return cabeza;
	}
	public void setCabeza(String cabeza) {
		this.cabeza = cabeza;
	}
	public String getOjos() {
		return ojos;
	}
	public void setOjos(String ojos) {
		this.ojos = ojos;
	}
	public String getGarganta() {
		return garganta;
	}
	public void setGarganta(String garganta) {
		this.garganta = garganta;
	}
	public String getNariz() {
		return nariz;
	}
	public void setNariz(String nariz) {
		this.nariz = nariz;
	}
	public String getOido() {
		return oido;
	}
	public void setOido(String oido) {
		this.oido = oido;
	}
	public String getTorax() {
		return torax;
	}
	public void setTorax(String torax) {
		this.torax = torax;
	}
	public String getAbdomen() {
		return abdomen;
	}
	public void setAbdomen(String abdomen) {
		this.abdomen = abdomen;
	}
	public String getGenitales() {
		return genitales;
	}
	public void setGenitales(String genitales) {
		this.genitales = genitales;
	}
	public String getMiembros() {
		return miembros;
	}
	public void setMiembros(String miembros) {
		this.miembros = miembros;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	public FormBoolean getAlergia() {
		return alergia;
	}
	public void setAlergia(FormBoolean alergia) {
		this.alergia = alergia;
	}
	public long getPaciente() {
		return paciente;
	}
	public void setPaciente(long paciente) {
		this.paciente = paciente;
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
	
	public ExploracionFisicaForm() {}
	
	public ExploracionFisicaForm(ExploracionFisica e) {
		this.setId(e.getId());
		
		this.setEstatura(e.getEstatura());
		this.setPeso(e.getPeso());
		this.setFrec_cardiaca(e.getFrecuenciaCardiaca());
		this.setFrec_respiratoria(e.getFrecuenciaRespiratoria());
		this.setPresion_arterial_diastolica(e.getPresionDiastolica());
		this.setPresion_arterial_sistolica(e.getPresionSistolica());
		this.setTemperatura(e.getTemperatura());
		
		this.setObservaciones(e.getObservaciones());
		
		this.setAbdomen(e.getAbdomen());
		this.setCabeza(e.getCabeza());
		this.setGarganta(e.getGarganta());
		this.setGenitales(e.getGenitales());
		this.setHabitus(e.getHabitus());
		this.setMiembros(e.getMiembros());
		this.setNariz(e.getNariz());
		this.setOido(e.getOido());
		this.setOjos(e.getOjos());
		this.setTorax(e.getTorax());
		
		this.setPaciente(e.getPaciente());
		this.setFecha(e.getFecha());
		this.setFechaString(
				this.fecha.toLocalDate().format(DateTimeFormatter.ofPattern("dd/MMMM/YYYY", Locale.forLanguageTag("es-MX"))));
	}
	
}
