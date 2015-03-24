package mx.mauricioabisay.phc.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import mx.mauricioabisay.phc.enums.FormBoolean;
import mx.mauricioabisay.phc.enums.TipoFrecuencia;
import mx.mauricioabisay.phc.forms.AntecedentePersonalForm;

@Entity
@Table(name = "antecedente_personal")
public class AntecedentePersonal {
	private long id;
	private FormBoolean alcohol;
	private int alcoholFrecuenciaValor;
	private TipoFrecuencia alcoholFrecuenciaTipo;
	private int alcoholCantidad;
	
	private FormBoolean tabaco;
	private int tabacoFrecuenciaCantidad;
	private TipoFrecuencia tabacoFrecuenciaTipo;
	
	private FormBoolean embarazo;
	
	private int semana;
	private int gesta;
	private double pesoPregestacional;
	
	private FormBoolean lactancia;
	
	private FormBoolean ejercicio;
	
	private long paciente;
	
	private Date fechaActualizacion;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_antecedente_personal")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Enumerated(EnumType.STRING)
	public FormBoolean getAlcohol() {
		return alcohol;
	}
	public void setAlcohol(FormBoolean alcohol) {
		this.alcohol = alcohol;
	}
	
	@Column(name = "alcohol_frec_valor")
	public int getAlcoholFrecuenciaValor() {
		return alcoholFrecuenciaValor;
	}
	public void setAlcoholFrecuenciaValor(int alcoholFrecuenciaValor) {
		this.alcoholFrecuenciaValor = alcoholFrecuenciaValor;
	}
	
	@Column(name = "alcohol_frec_tipo")
	@Enumerated(EnumType.STRING)
	public TipoFrecuencia getAlcoholFrecuenciaTipo() {
		return alcoholFrecuenciaTipo;
	}
	public void setAlcoholFrecuenciaTipo(TipoFrecuencia alcoholFrecuenciaTipo) {
		this.alcoholFrecuenciaTipo = alcoholFrecuenciaTipo;
	}
	
	@Column(name = "alcohol_frec_cantidad")
	public int getAlcoholCantidad() {
		return alcoholCantidad;
	}
	public void setAlcoholCantidad(int alcoholCantidad) {
		this.alcoholCantidad = alcoholCantidad;
	}
	
	@Enumerated(EnumType.STRING)
	public FormBoolean getTabaco() {
		return tabaco;
	}
	public void setTabaco(FormBoolean tabaco) {
		this.tabaco = tabaco;
	}
	
	@Column(name = "tabaco_frec_cantidad")
	public int getTabacoFrecuenciaCantidad() {
		return tabacoFrecuenciaCantidad;
	}
	public void setTabacoFrecuenciaCantidad(int tabacoFrecuenciaCantidad) {
		this.tabacoFrecuenciaCantidad = tabacoFrecuenciaCantidad;
	}
	
	@Column(name = "tabaco_frec_tipo")
	@Enumerated(EnumType.STRING)
	public TipoFrecuencia getTabacoFrecuenciaTipo() {
		return tabacoFrecuenciaTipo;
	}
	public void setTabacoFrecuenciaTipo(TipoFrecuencia tabacoFrecuenciaTipo) {
		this.tabacoFrecuenciaTipo = tabacoFrecuenciaTipo;
	}
	@Enumerated(EnumType.STRING)
	public FormBoolean getEmbarazo() {
		return embarazo;
	}
	public void setEmbarazo(FormBoolean embarazo) {
		this.embarazo = embarazo;
	}

	public int getSemana() {
		return semana;
	}
	public void setSemana(int semana) {
		this.semana = semana;
	}
	
	public int getGesta() {
		return gesta;
	}
	public void setGesta(int gesta) {
		this.gesta = gesta;
	}
	
	@Column(name = "peso_pregestacional")
	public double getPesoPregestacional() {
		return pesoPregestacional;
	}
	public void setPesoPregestacional(double pesoPregestacional) {
		this.pesoPregestacional = pesoPregestacional;
	}
	
	@Enumerated(EnumType.STRING)
	public FormBoolean getLactancia() {
		return lactancia;
	}
	public void setLactancia(FormBoolean lactancia) {
		this.lactancia = lactancia;
	}
	
	@Enumerated(EnumType.STRING)
	public FormBoolean getEjercicio() {
		return ejercicio;
	}
	public void setEjercicio(FormBoolean ejercicio) {
		this.ejercicio = ejercicio;
	}
	
	@Column(name = "paciente_fk")
	public long getPaciente() {
		return paciente;
	}
	public void setPaciente(long paciente) {
		this.paciente = paciente;
	}
	
	@Column(name = "fecha_actualizacion")
	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}
	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	
	//Constructors
	public AntecedentePersonal(){}
	
	public AntecedentePersonal(AntecedentePersonalForm form){
		this.setAlcohol(form.getAlcohol());
		this.setAlcoholCantidad(form.getAlcohol_frec_cantidad());
		this.setAlcoholFrecuenciaTipo(TipoFrecuencia.valueOf(form.getAlcohol_frec_tipo()));
		this.setAlcoholFrecuenciaValor(form.getAlcohol_frec_valor());
		
		this.setEjercicio(form.getEjercicio());
		this.setEmbarazo(form.getEmbarazo());
		this.setSemana(form.getSemanas_embarazo());
		this.setLactancia(form.getLactancia());
		
		this.setTabaco(form.getTabaco());
		this.setTabacoFrecuenciaCantidad(form.getTabaco_frec_cantidad());
		this.setTabacoFrecuenciaTipo(TipoFrecuencia.valueOf(form.getTabaco_frec_tipo()));
		
		this.setFechaActualizacion(form.getFecha());
		this.setPaciente(form.getPaciente());
	}
}
