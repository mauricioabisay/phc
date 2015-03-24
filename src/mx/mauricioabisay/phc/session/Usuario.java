package mx.mauricioabisay.phc.session;

import java.io.Serializable;

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private String user;
	private String current;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getCurrent() {
		return current;
	}
	public void setCurrent(String current) {
		this.current = current;
	}
	
	public Usuario() {}
	public Usuario(String current) {
		this.current = current;
	}
	
}
