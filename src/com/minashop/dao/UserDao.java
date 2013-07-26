package com.minashop.dao;

import java.sql.SQLException;
import org.hibernate.Session;
import com.minashop.entity.User;
import com.minashop.util.HbUtil;

public class UserDao {

	public User findUser(String name,String pwd)throws SQLException{
		Session session=HbUtil.getSession();
		User user=(User)session.createQuery("from User u where u.name=? and u.pwd=?")
				                .setString(0, name).setString(1, pwd)
				                .uniqueResult();
		session.close();
		return user;
	}
	
	public void addUser(User user)throws SQLException{
		Session session=HbUtil.getSession();
		try{
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
		
	}
	
	//测试
	/*
	public static void main(String[] args){
		UserDao dao=new UserDao();
		User user=dao.findUser("aaa", "111");
		System.out.print(user.getName()+","+user.getEmail());
		
	}
	*/
}
