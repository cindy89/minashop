package com.minashop.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.minashop.entity.Order;
import com.minashop.util.HbUtil;

public class OrderDao {

	public boolean addOrder(Order order){
		Session session=HbUtil.getSession();
		try{
			session.beginTransaction();
			session.save(order);
			session.getTransaction().commit();
			return true;
			}catch(Exception e){
				e.printStackTrace();
				session.getTransaction().rollback();
				return false;
			}finally{
				session.close();
			}
	}
	
	@SuppressWarnings("unchecked")
	public List<Order> orderList(){
		List<Order> orderList=new ArrayList<Order>();
		Session session=HbUtil.getSession();
		orderList=session.createQuery("from Order").list();
		session.close();
		return orderList;
	}
	
	public Order orderById(Integer id){
		Session session=HbUtil.getSession();
		Order order=(Order) session.createQuery("from Order o where o.id=?")
				            .setInteger(0, id).uniqueResult();
		session.close();
		return order;
	}
}
