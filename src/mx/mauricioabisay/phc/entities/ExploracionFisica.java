package mx.mauricioabisay.phc.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import mx.mauricioabisay.phc.forms.ExploracionFisicaForm;

@Entity
@Table(name = "exploracion_fisica")
public class ExploracionFisica {
	private long id;
	
	private double temperatura;
	private int presionSistolica;
	private int presionDiastolica;
	private int frecuenciaCardiaca;
	private int frecuenciaRespiratoria;
	
	private double peso;
	private double estatura;
	
	private String habitus;
	private String cabeza;
	private String ojos;
	private String garganta;
	private String nariz;
	private String oido;
	private String torax;
	private String abdomen;
	private String genitales;
	private String miembros;
	
	private String observaciones;
	private Date fecha;
	private long paciente;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_exploracion_fisica")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}
	@Column(name = "presion_sistolica")
	public int getPresionSistolica() {
		return presionSistolica;
	}
	public void setPresionSistolica(int presionSistolica) {
		this.presionSistolica = presionSistolica;
	}
	@Column(name = "presion_diastolica")
	public int getPresionDiastolica() {
		return presionDiastolica;
	}
	public void setPresionDiastolica(int presionDiastolica) {
		this.presionDiastolica = presionDiastolica;
	}
	@Column(name = "frec_cardiaca")
	public int getFrecuenciaCardiaca() {
		return frecuenciaCardiaca;
	}
	public void setFrecuenciaCardiaca(int frecuenciaCardiaca) {
		this.frecuenciaCardiaca = frecuenciaCardiaca;
	}
	@Column(name = "frec_respiratoria")
	public int getFrecuenciaRespiratoria() {
		return frecuenciaRespiratoria;
	}
	public void setFrecuenciaRespiratoria(int frecuenciaRespiratoria) {
		this.frecuenciaRespiratoria = frecuenciaRespiratoria;
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
	public String getHabitus() {
		return habitus;
	}
	public void setHabitus(String habitus) {
		this.habitus = habitus;
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	@Column(name = "paciente_fk")
	public long getPaciente() {
		return paciente;
	}
	public void setPaciente(long paciente) {
		this.paciente = paciente;
	}
	
	public ExploracionFisica() {}
	
	public ExploracionFisica(ExploracionFisicaForm e) {
		this.setAbdomen(e.getAbdomen());
		this.setCabeza(e.getCabeza());
		this.setEstatura(e.getEstatura());
		this.setFecha(e.getFecha());
		this.setFrecuenciaCardiaca(e.getFrec_cardiaca());
		this.setFrecuenciaRespiratoria(e.getFrec_respiratoria());
		this.setGarganta(e.getGarganta());
		this.setGenitales(e.getGenitales());
		this.setHabitus(e.getHabitus());
		this.setMiembros(e.getMiembros());
		this.setNariz(e.getNariz());
		this.setObservaciones(e.getObservaciones());
		this.setOido(e.getOido());
		this.setOjos(e.getOjos());
		this.setPeso(e.getPeso());
		this.setPresionDiastolica(e.getPresion_arterial_diastolica());
		this.setPresionSistolica(e.getPresion_arterial_sistolica());
		this.setTemperatura(e.getTemperatura());
		this.setTorax(e.getTorax());
		
		this.setPaciente(e.getPaciente());
		
	}
}
