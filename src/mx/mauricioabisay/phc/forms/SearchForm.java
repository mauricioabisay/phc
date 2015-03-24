package mx.mauricioabisay.phc.forms;

import mx.mauricioabisay.validation.Trim;

public class SearchForm {
	@Trim
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
