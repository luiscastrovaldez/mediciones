package pe.com.monitoreo.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.com.monitoreo.dao.UserDao;
import pe.com.monitoreo.entity.User;
import pe.com.monitoreo.service.UserService;

/**
 * 
 * @author lcastro
 *
 */

@Transactional
@Service("usuarioService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao usuarioDao;

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		usuarioDao.saveUser(user);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return usuarioDao.updateUser(user);
	}

	@Transactional(readOnly = true)
	@Override
	public User findUserById(Serializable id) {
		// TODO Auto-generated method stub
		return usuarioDao.findUserById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return usuarioDao.findAllUsers();
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> findUserByUserName(Serializable userName) {
		// TODO Auto-generated method stub
		return usuarioDao.findUserByUserName(userName);
	}

	@Override
	public List<User> findUserByUserNameAndPassword(Serializable userName, Serializable password) {
		// TODO Auto-generated method stub
		return usuarioDao.findUserByUserNameAndPassword(userName, password);
	}

}
