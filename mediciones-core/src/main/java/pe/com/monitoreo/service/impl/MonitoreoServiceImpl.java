package pe.com.monitoreo.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.com.monitoreo.entity.User;
import pe.com.monitoreo.service.MonitoreoService;
import pe.com.monitoreo.service.UserService;

@Transactional
@Service("monitoreoService")
public class MonitoreoServiceImpl implements MonitoreoService {

	@Autowired
	private UserService userService;

	/*@Autowired
	private PersonService personService;*/

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		this.userService.saveUser(user);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return this.userService.updateUser(user);
	}

	@Transactional(readOnly = true)
	@Override
	public User findUserById(Serializable id) {
		// TODO Auto-generated method stub
		return this.userService.findUserById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return this.userService.findAllUsers();
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> findUsuarioByUserName(Serializable userName) {
		// TODO Auto-generated method stub
		return userService.findUsuarioByUserName(userName);
	}

	@Override
	public List<User> findUsuarioByUserNameAndPassword(Serializable userName, Serializable password) {
		// TODO Auto-generated method stub
		return userService.findUsuarioByUserNameAndPassword(userName, password);
	}

}
