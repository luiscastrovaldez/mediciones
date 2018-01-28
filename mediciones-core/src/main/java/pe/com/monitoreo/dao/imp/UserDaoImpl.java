package pe.com.monitoreo.dao.imp;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import pe.com.monitoreo.dao.UserDao;
import pe.com.monitoreo.entity.User;

@Repository
public class UserDaoImpl extends BaseDao<User> implements UserDao{
		
	@Override
	public void saveUser(User usuario) {
		// TODO Auto-generated method stub
		create(usuario);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return update(user);
	}

	@Override
	public User findUserById(Serializable id) {
		// TODO Auto-generated method stub
		return findOne(User.class, id);
	}
	
	@Override
	public List<User> findUsuarioByUserName(Serializable userName) {
		// TODO Auto-generated method stub
		return findByQueryOneParam(User.class,"findUserByUserName", userName);
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return findAll(User.class);
	}

	@Override
	public List<User> findUsuarioByUserNameAndPassword(Serializable userName, Serializable password) {
		// TODO Auto-generated method stub
		return findByQueryTwoParam(User.class,"findUserByUserNameAndPassword", userName,password);
	}

	

}
