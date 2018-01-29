package pe.com.monitoreo.service;

import java.io.Serializable;
import java.util.List;

import pe.com.monitoreo.entity.User;

public interface MeasureService {

	void saveUser(User user);
	
	User updateUser(User user);
	
	User findUserById(Serializable id);
	
	List<User> findAllUsers();
		
	List<User> findUserByUserName(Serializable userName);
	
	List<User> findUserByUserNameAndPassword(Serializable userName,Serializable password);
}
