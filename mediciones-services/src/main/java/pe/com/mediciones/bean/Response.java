package pe.com.mediciones.bean;

import java.util.List;

import pe.com.monitoreo.entity.User;

public class Response {

	public Response() {

	}

	private int status;
	private List<User> data;
	private boolean isLogged;
	private String message;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<User> getData() {
		return data;
	}

	public void setData(List<User> data) {
		this.data = data;
	}

	public boolean getIsLogged() {
		return isLogged;
	}

	public void setIsLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
