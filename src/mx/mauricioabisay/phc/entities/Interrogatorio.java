package mx.mauricioabisay.phc.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import mx.mauricioabisay.phc.forms.InterrogatorioForm;

@Entity
@Table(name = "interrogatorio")
public class Interrogatorio {
	private long id;
	private String gastroIntestinal;
	private String respiratorio;
	private String cardiovascular;
	private String genitoUrinario;
	private String esferaMental;
	private String psicosomatico;
	private String otorrinoLaringologico;
	private String musculoEsqueletico;
	private String endocrino;
	private String observaciones;
	private Date fecha;
	private long paciente;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_interrogatorio")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(name = "gastro_intestinal")
	public String getGastroIntestinal() {
		return gastroIntestinal;
	}
	public void setGastroIntestinal(String gastroIntestinal) {
		this.gastroIntestinal = gastroIntestinal;
	}
	public String getRespiratorio() {
		return respiratorio;
	}
	public void setRespiratorio(String respiratorio) {
		this.respiratorio = respiratorio;
	}
	public String getCardiovascular() {
		return cardiovascular;
	}
	public void setCardiovascular(String cardiovascular) {
		this.cardiovascular = cardiovascular;
	}
	@Column(name = "genito_urinario")
	public String getGenitoUrinario() {
		return genitoUrinario;
	}
	public void setGenitoUrinario(String genitoUrinario) {
		this.genitoUrinario = genitoUrinario;
	}
	@Column(name = "esfera_mental")
	public String getEsferaMental() {
		return esferaMental;
	}
	public void setEsferaMental(String esferaMental) {
		this.esferaMental = esferaMental;
	}
	public String getPsicosomatico() {
		return psicosomatico;
	}
	public void setPsicosomatico(String psicosomatico) {
		this.psicosomatico = psicosomatico;
	}
	@Column(name = "otorrino_laringologico")
	public String getOtorrinoLaringologico() {
		return otorrinoLaringologico;
	}
	public void setOtorrinoLaringologico(String otorrinoLaringologico) {
		this.otorrinoLaringologico = otorrinoLaringologico;
	}
	@Column(name = "musculo_esqueletico")
	public String getMusculoEsqueletico() {
		return musculoEsqueletico;
	}
	public void setMusculoEsqueletico(String musculoEsqueletico) {
		this.musculoEsqueletico = musculoEsqueletico;
	}
	public String getEndocrino() {
		return endocrino;
	}
	public void setEndocrino(String endocrino) {
		this.endocrino = endocrino;
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
	
	public Interrogatorio() {}
	
	public Interrogatorio(InterrogatorioForm i) {
		this.setCardiovascular(i.getCardiovascular());
		this.setEndocrino(i.getEndocrino());
		this.setEsferaMental(i.getEsfera_mental());
		this.setFecha(i.getFecha());
		this.setGastroIntestinal(i.getGastro_intestinal());
		this.setGenitoUrinario(i.getGenito_urinario());
		this.setMusculoEsqueletico(i.getMusculo_esqueletico());
		this.setOtorrinoLaringologico(i.getOtorrino_laringologico());
		this.setPsicosomatico(i.getPsicosomatico());
		this.setRespiratorio(i.getRespiratorio());
		this.setObservaciones(i.getObservaciones());
		this.setPaciente(i.getPaciente());
	}
}
