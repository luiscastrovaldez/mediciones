package pe.com.monitoreo.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.com.monitoreo.dao.UsuarioDao;
import pe.com.monitoreo.entity.Usuario;
import pe.com.monitoreo.service.UsuarioService;

/**
 * 
 * @author lcastro
 *
 */

@Transactional
@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDao usuarioDao;

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void saveUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		usuarioDao.saveUsuario(usuario);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public Usuario updateUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioDao.updateUsuario(usuario);
	}

	@Transactional(readOnly = true)
	@Override
	public Usuario findUsuarioById(Serializable id) {
		// TODO Auto-generated method stub
		return usuarioDao.findUsuarioById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Usuario> listarUsuarios() {
		// TODO Auto-generated method stub
		return usuarioDao.listarUsuarios();
	}

}
