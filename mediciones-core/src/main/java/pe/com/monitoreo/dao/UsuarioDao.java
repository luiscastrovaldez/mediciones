package pe.com.monitoreo.dao;

import java.io.Serializable;
import java.util.List;

import pe.com.monitoreo.entity.Usuario;

/**
 * 
 * @author lcastro
 *
 */
public interface UsuarioDao {

	void saveUsuario(Usuario usuario);
	
	Usuario updateUsuario(Usuario usuario);
	
	Usuario findUsuarioById(Serializable id);
	
	List<Usuario> listarUsuarios();
}
