package pe.com.monitoreo.service;

import java.io.Serializable;
import java.util.List;

import pe.com.monitoreo.entity.User;

public interface UserService {

void saveUser(User user);
	
	User updateUser(User user);
	
	User findUserById(Serializable id);
	
	List<User> findAllUsers();
		
	List<User> findUsuarioByUserName(Serializable userName);
	
	List<User> findUsuarioByUserNameAndPassword(Serializable userName,Serializable password);
}
