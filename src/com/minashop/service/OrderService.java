package com.minashop.service;

import java.util.ArrayList;
import java.util.List;

import com.minashop.dao.OrderDao;
import com.minashop.entity.Book;
import com.minashop.entity.Order;

public class OrderService {
	private OrderDao dao=new OrderDao();
	private BookService bService=new BookService();
	public boolean addOrder(Order order){
		return dao.addOrder(order);
	}
	public List<Order> orderList(){
		List<Order> orderList=new ArrayList<Order>();
		orderList=dao.orderList();
		for(Order order:orderList){
			String[] nums=order.getbNum().split(",");
			String[] nos=order.getbNo().split(",");
			String subNum=subNum(nums);
			String subPrice=subPrice(nos,nums);
			order.setSubNum(subNum);
			order.setSubPrice(subPrice);
		}
		return orderList;
	}
	
	public Order orderById(String idStr){
		Integer id=Integer.valueOf(idStr);
		Order order=dao.orderById(id);
		String[] nos=order.getbNo().split(",");
		String[] nums=order.getbNum().split(",");
		String totPrice=subPrice(nos,nums);
		order.setSubPrice(totPrice);
		order.setBookList(bookList(nos,nums));
		return order;
	}
	
	private List<Book> bookList(String[] nos,String[] nums){
		List<Book> bookList=new ArrayList<Book>();
		for(int i=0;i<nos.length;i++){
			int no=Integer.valueOf(nos[i]);
			Book book=bService.findBookById(no);
			book.setBnum(nums[i]);
			bookList.add(book);
		}
		return bookList;
	}
	
	private String subNum(String[] nums){
		String subNum="";
		int subNum1=0;
		for(int i=0;i<nums.length;i++){
			subNum1+=Integer.valueOf(nums[i]);
		}
		subNum=subNum1+"";
		return subNum;
	}
	
	private String subPrice(String[] nos,String[] nums){
		String subPrice="";
		float subPrice1=0;
		for(int i=0;i<nos.length;i++){
			Book book=bService.findBookById(Integer.valueOf(nos[i]));
			float price=Float.valueOf(book.getPrice());
			int num=Integer.valueOf(nums[i]);
			subPrice1+=price*num;
			
		}
		subPrice=subPrice1+"";
		return subPrice;
	}
	
	public OrderDao getDao() {
		return dao;
	}

	public void setDao(OrderDao dao) {
		this.dao = dao;
	}
	public BookService getbService() {
		return bService;
	}
	public void setbService(BookService bService) {
		this.bService = bService;
	}
}
