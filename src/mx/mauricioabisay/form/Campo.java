package mx.mauricioabisay.form;
/**
 * Helper class to store a form's field value and if there was a validation error, usefull on dynamic form elements
 * @author Mauricio Abisay
 *
 */
public class Campo {
	private String value;
	private boolean error;
	
	public Campo(String value) {
		this.value = value;
		this.error = false;
	}
	
	public Campo(String value, boolean error) {
		this.value = value;
		this.error = error;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	
	
}
