package iot.dao.imp;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import iot.bean.User;
import iot.dao.UserDao;

public class UserDaoImp extends  HibernateDaoSupport implements UserDao{
	 public User save(User user){  
		 if(user!=null){
	    	this.getHibernateTemplate().save(user);
	        return user;  
	    } 
		 else return null;
	 }
}
