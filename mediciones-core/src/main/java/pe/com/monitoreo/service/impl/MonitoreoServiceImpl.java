package pe.com.monitoreo.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.com.monitoreo.entity.Usuario;
import pe.com.monitoreo.service.MonitoreoService;
import pe.com.monitoreo.service.PersonService;
import pe.com.monitoreo.service.UsuarioService;

@Transactional
@Service("monitoreoService")
public class MonitoreoServiceImpl implements MonitoreoService{

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PersonService personService;

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void saveUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		this.usuarioService.saveUsuario(usuario);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public Usuario updateUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return this.usuarioService.updateUsuario(usuario);
	}

	@Transactional(readOnly = true)
	@Override
	public Usuario findUsuarioById(Serializable id) {
		// TODO Auto-generated method stub
		return this.usuarioService.findUsuarioById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Usuario> listarUsuarios() {
		// TODO Auto-generated method stub
		return this.usuarioService.listarUsuarios();
	}
	
	
	
}
