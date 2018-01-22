package pe.com.monitoreo.service;

import java.io.Serializable;
import java.util.List;

import pe.com.monitoreo.entity.Usuario;

public interface MonitoreoService {

	void saveUsuario(Usuario usuario);

	Usuario updateUsuario(Usuario usuario);

	Usuario findUsuarioById(Serializable id);

	List<Usuario> listarUsuarios();
}
