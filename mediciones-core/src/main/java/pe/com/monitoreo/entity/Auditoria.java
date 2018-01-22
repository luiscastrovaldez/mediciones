package pe.com.monitoreo.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Auditoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2009407345263402424L;

	public Auditoria() {

	}

	@Column(name = "USUARIO_CREACION")
	private String usuarioCreacion;

	@Column(name = "FECHA_CREACION")
	private Timestamp fechaCreacion;

	@Column(name = "USUARIO_MODIFICACION")
	private String usuarioModificacion;

	@Column(name = "FECHA_MODIFICACION")
	private Timestamp fechaModificacion;

	public Auditoria(String usuarioCreacion, Timestamp fechaCreacion, String usuarioModificacion,
			Timestamp fechaModificacion) {
		super();
		this.usuarioCreacion = usuarioCreacion;
		this.fechaCreacion = fechaCreacion;
		this.usuarioModificacion = usuarioModificacion;
		this.fechaModificacion = fechaModificacion;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public Timestamp getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

}
