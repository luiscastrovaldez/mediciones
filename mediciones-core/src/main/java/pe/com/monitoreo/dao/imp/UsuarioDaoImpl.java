package pe.com.monitoreo.dao.imp;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import pe.com.monitoreo.dao.UsuarioDao;
import pe.com.monitoreo.entity.Usuario;

@Repository
public class UsuarioDaoImpl extends BaseDao<Usuario> implements UsuarioDao{
	

	
	@Override
	public void saveUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		create(usuario);
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return update(usuario);
	}

	@Override
	public Usuario findUsuarioById(Serializable id) {
		// TODO Auto-generated method stub
		return findOne(Usuario.class, id);
	}

	@Override
	public List<Usuario> listarUsuarios() {
		// TODO Auto-generated method stub
		return findAll(Usuario.class);
	}

}
