package iot.action;

import java.io.Serializable;

import com.opensymphony.xwork2.ActionSupport;

import iot.bean.User;
import iot.service.UserService;

public class UserAction extends ActionSupport implements Serializable{
 
	 private static final long serialVersionUID = 12L;  
	    
	    private User user;  
	    private UserService userService;
	    public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
	public UserService getUserService() {
			return userService;
		}
	public void setUserService(UserService userService) {
			this.userService = userService;
		}
		public String execute(){  
	        if (userService.save(user)!=null) {  
	            return SUCCESS;  
	        }else {  
	            return ERROR;  
	        }  
	    }  
	 
}
