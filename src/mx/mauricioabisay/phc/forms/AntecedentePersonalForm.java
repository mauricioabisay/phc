package mx.mauricioabisay.phc.forms;

import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import mx.mauricioabisay.phc.entities.AntecedentePersonal;
import mx.mauricioabisay.phc.enums.FormBoolean;

public class AntecedentePersonalForm {
	@NotNull
	@Min(0)
	private long id = 0;
	@NotNull
	private FormBoolean embarazo;
	@NotNull
	private FormBoolean lactancia;
	@Min(0)
	@Digits(integer=2, fraction=0)
	private int gesta;
	@Min(0)
	@Digits(integer=2, fraction=0)
	private int semanas_embarazo;
	@Min(0)
	@Digits(integer=3, fraction=3)
	private double peso_pregestacional;
	@NotNull
	private FormBoolean alcohol;
	@Digits(integer=2, fraction=0)
	private int alcohol_frec_valor;
	@NotEmpty
	private String alcohol_frec_tipo;
	@Digits(integer=2, fraction=0)
	private int alcohol_frec_cantidad;
	@NotNull
	private FormBoolean tabaco;
	@Digits(integer=2, fraction=0)
	private int tabaco_frec_cantidad;
	@NotEmpty
	private String tabaco_frec_tipo;
	
	private int tabaco_inicio_valor;
	private String tabaco_inicio_tipo;
	
	@NotNull
	private FormBoolean ejercicio;
	@NotNull
	private int counter;
	
	private Date fecha;
	private long paciente;
	private String fechaActualizacion;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public FormBoolean getEmbarazo() {
		return embarazo;
	}
	public void setEmbarazo(FormBoolean embarazo) {
		this.embarazo = embarazo;
	}
	public FormBoolean getLactancia() {
		return lactancia;
	}
	public void setLactancia(FormBoolean lactancia) {
		this.lactancia = lactancia;
	}
	public int getGesta() {
		return gesta;
	}
	public void setGesta(int gesta) {
		this.gesta = gesta;
	}
	public int getSemanas_embarazo() {
		return semanas_embarazo;
	}
	public void setSemanas_embarazo(int semanas_embarazo) {
		this.semanas_embarazo = semanas_embarazo;
	}
	public double getPeso_pregestacional() {
		return peso_pregestacional;
	}
	public void setPeso_pregestacional(double peso_pregestacional) {
		this.peso_pregestacional = peso_pregestacional;
	}
	public FormBoolean getAlcohol() {
		return alcohol;
	}
	public void setAlcohol(FormBoolean alcohol) {
		this.alcohol = alcohol;
	}
	public int getAlcohol_frec_valor() {
		return alcohol_frec_valor;
	}
	public void setAlcohol_frec_valor(int alcohol_frec_valor) {
		this.alcohol_frec_valor = alcohol_frec_valor;
	}
	public String getAlcohol_frec_tipo() {
		return alcohol_frec_tipo;
	}
	public void setAlcohol_frec_tipo(String alcohol_frec_tipo) {
		this.alcohol_frec_tipo = alcohol_frec_tipo;
	}
	public int getAlcohol_frec_cantidad() {
		return alcohol_frec_cantidad;
	}
	public void setAlcohol_frec_cantidad(int alcohol_frec_cantidad) {
		this.alcohol_frec_cantidad = alcohol_frec_cantidad;
	}
	public FormBoolean getTabaco() {
		return tabaco;
	}
	public void setTabaco(FormBoolean tabaco) {
		this.tabaco = tabaco;
	}
	public int getTabaco_frec_cantidad() {
		return tabaco_frec_cantidad;
	}
	public void setTabaco_frec_cantidad(int tabaco_frec_cantidad) {
		this.tabaco_frec_cantidad = tabaco_frec_cantidad;
	}
	public String getTabaco_frec_tipo() {
		return tabaco_frec_tipo;
	}
	public void setTabaco_frec_tipo(String tabaco_frec_tipo) {
		this.tabaco_frec_tipo = tabaco_frec_tipo;
	}
	public int getTabaco_inicio_valor() {
		return tabaco_inicio_valor;
	}
	public void setTabaco_inicio_valor(int tabaco_inicio_valor) {
		this.tabaco_inicio_valor = tabaco_inicio_valor;
	}
	public String getTabaco_inicio_tipo() {
		return tabaco_inicio_tipo;
	}
	public void setTabaco_inicio_tipo(String tabaco_inicio_tipo) {
		this.tabaco_inicio_tipo = tabaco_inicio_tipo;
	}
	public FormBoolean getEjercicio() {
		return ejercicio;
	}
	public void setEjercicio(FormBoolean ejercicio) {
		this.ejercicio = ejercicio;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public long getPaciente() {
		return paciente;
	}
	public void setPaciente(long paciente) {
		this.paciente = paciente;
	}
	public String getFechaActualizacion() {
		return fechaActualizacion;
	}
	public void setFechaActualizacion(String fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	
	//Constructors
	public AntecedentePersonalForm() {}
	
	public AntecedentePersonalForm(AntecedentePersonal antecedente) {
		this.setId(antecedente.getId());
		
		this.setAlcohol(antecedente.getAlcohol());
		this.setAlcohol_frec_cantidad(antecedente.getAlcoholCantidad());
		this.setAlcohol_frec_tipo(antecedente.getAlcoholFrecuenciaTipo().name());
		this.setAlcohol_frec_valor(antecedente.getAlcoholFrecuenciaValor());
		
		this.setTabaco(antecedente.getTabaco());
		this.setTabaco_frec_cantidad(antecedente.getTabacoFrecuenciaCantidad());
		this.setTabaco_frec_tipo(antecedente.getTabacoFrecuenciaTipo().name());
		
		this.setEjercicio(antecedente.getEjercicio());
		
		this.setEmbarazo(antecedente.getEmbarazo());
		this.setSemanas_embarazo(antecedente.getSemana());
		this.setGesta(antecedente.getGesta());
		this.setPeso_pregestacional(antecedente.getPesoPregestacional());
		this.setLactancia(antecedente.getLactancia());
		
		this.setPaciente(antecedente.getPaciente());
		this.setFecha(antecedente.getFechaActualizacion());
		
		this.setFechaActualizacion(
				this.fecha.toLocalDate().format(DateTimeFormatter.ofPattern("dd/MMMM/YYYY", Locale.forLanguageTag("es-MX")))
				);
	}
	
}
