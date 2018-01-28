package pe.com.monitoreo.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;

/**
 * 
 * @author lcastro
 *
 */

@Entity
@Table(name = "USER")
@NamedQuery(name = "findUserByUserName", query = "SELECT u FROM User u WHERE u.userName = ?1")
@NamedQuery(name = "findUserByUserNameAndPassword", query = "SELECT u FROM User u WHERE u.userName = ?1 and password = ?2")
public class User extends Audit {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8147624140456772218L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "USERNAME")
	private String userName;

	public User() {

	}

	public User(String password, String email, String userName) {
		super();
		this.password = password;
		this.email = email;
		this.userName = userName;
	}

	public User(Long id, String password, String email, String userName, String usuarioCreacion,
			Timestamp fechaCreacion, String usuarioModificacion, Timestamp fechaModificacion) {
		super(usuarioCreacion, fechaCreacion, usuarioModificacion, fechaModificacion);
		this.id = id;
		this.password = password;
		this.email = email;
		this.userName = userName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", email=" + email + ", userName=" + userName
				+ ", getCreatedBy()=" + getCreatedBy() + ", getCreatedDate()=" + getCreatedDate() + ", getUpdatedBy()="
				+ getUpdatedBy() + ", getUpdatedDate()=" + getUpdatedDate() + "]";
	}

}
