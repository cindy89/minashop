package com.minashop.service;

import java.sql.SQLException;
import com.minashop.dao.UserDao;
import com.minashop.entity.User;

public class UserService {
	private UserDao dao=new UserDao();
	
	public User findUser(String name,String pwd)throws SQLException{
		User user=dao.findUser(name, pwd);
		return user;
	}
	public void addUser(User user)throws SQLException{
		dao.addUser(user);
	}

	
	public UserDao getDao() {
		return dao;
	}
	public void setDao(UserDao dao) {
		this.dao = dao;
	}
	
}
