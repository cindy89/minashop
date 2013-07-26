package com.minashop.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.minashop.entity.User;

public class HbUtil {
	private static SessionFactory sf;
	
	static{
		try{
			sf=new Configuration().configure().buildSessionFactory();
		}catch(HibernateException e){
			e.printStackTrace();
		}
		
	}
	
	public static Session getSession(){
		Session session=null;
		try{
			session=sf.openSession();
		}catch(HibernateException e){
			e.printStackTrace();
		}
		return session;
	}

/*	public static void main(String[] args){
		HbUtil hb=new HbUtil();
		Session session=hb.getSession();
		User user=(User)session.createQuery("from User u where u.id=1");
		System.out.println(user.getName());
		
	}
*/	
}

