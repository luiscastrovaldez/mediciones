package pe.com.monitoreo.bean;

import java.io.Serializable;

public class Response implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8530335369601508209L;

	private boolean isLogged;
	private String message;

	public Response() {

	}

	public Response(boolean isLogged, String message) {
		super();
		this.isLogged = isLogged;
		this.message = message;
	}

	public boolean isLogged() {
		return isLogged;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
