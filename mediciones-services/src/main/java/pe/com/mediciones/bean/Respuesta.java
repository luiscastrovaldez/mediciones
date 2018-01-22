package pe.com.mediciones.bean;

import java.util.List;

import pe.com.monitoreo.entity.Usuario;

public class Respuesta {

	public Respuesta() {

	}

	private int status;
	private List<Usuario> data;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Usuario> getData() {
		return data;
	}

	public void setData(List<Usuario> data) {
		this.data = data;
	}

}
