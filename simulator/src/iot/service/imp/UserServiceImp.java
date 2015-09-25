package iot.service.imp;

import iot.bean.User;
import iot.dao.UserDao;
import iot.service.UserService;

public class UserServiceImp implements UserService {

	  private UserDao userDao;
	  
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User save(User user) {
		 userDao.save(user);
		return user;
	}

}
