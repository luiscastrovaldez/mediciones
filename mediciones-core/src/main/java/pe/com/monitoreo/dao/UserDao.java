package pe.com.monitoreo.dao;

import java.io.Serializable;
import java.util.List;

import pe.com.monitoreo.entity.User;

/**
 * 
 * @author lcastro
 *
 */
public interface UserDao {

	void saveUser(User user);
	
	User updateUser(User user);
	
	User findUserById(Serializable id);
	
	List<User> findAllUsers();
		
	List<User> findUserByUserName(Serializable userName);
	
	List<User> findUserByUserNameAndPassword(Serializable userName,Serializable password);
}
