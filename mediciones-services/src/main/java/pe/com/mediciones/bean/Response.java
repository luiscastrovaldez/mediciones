package pe.com.mediciones.bean;

import java.util.List;

import pe.com.monitoreo.entity.User;

public class Response {

	public Response() {

	}

	private int status;
	private List<User> data;

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

}
