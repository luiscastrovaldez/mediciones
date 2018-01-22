package pe.com.monitoreo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author lcastro
 *
 */

@Entity
@Table(name = "USUARIO")
public class Usuario extends Auditoria {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8147624140456772218L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NOMBRES")
	private String nombres;

	@Column(name = "APELLIDOS")
	private String apellidos;

	@Column(name = "CORREO")
	private String correo;

	@Column(name = "CLAVE")
	private String clave;

	public Usuario() {

	}

	public Usuario(String nombres, String apellidos, String correo, String clave) {
		super();		
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.clave = clave;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", correo=" + correo
				+ ", clave=" + clave + ", getUsuarioCreacion()=" + getUsuarioCreacion() + ", getFechaCreacion()="
				+ getFechaCreacion() + ", getUsuarioModificacion()=" + getUsuarioModificacion()
				+ ", getFechaModificacion()=" + getFechaModificacion() + "]";
	}

}
