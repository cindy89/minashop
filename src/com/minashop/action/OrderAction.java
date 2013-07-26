package com.minashop.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.minashop.entity.Book;
import com.minashop.entity.Cart;
import com.minashop.entity.Order;
import com.minashop.service.CartService;
import com.minashop.service.OrderService;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport {

	private static final long serialVersionUID = -2371306341133403280L;
	private List<Cart> cartList=new ArrayList<Cart>();
	private List<Order> orderList=new ArrayList<Order>();
	private List<Book> bookList1=new ArrayList<Book>();
	private OrderService service=new OrderService();
	private Order order;
	public String addOrder(){
		HttpServletRequest request=ServletActionContext.getRequest();
		CartService cartService=CartService.getInstance(request);
		String bNos="";
		String bNums="";
		if(cartList.size()==0){
			cartList=cartService.findCartList();
		}
		for(Cart cart:cartList){
			bNos+=cart.getBook().getNo()+",";
			bNums+=cart.getNum()+",";
		}
		order.setbNo(bNos);
		order.setbNum(bNums);
		boolean b=service.addOrder(order);
		request.setAttribute("order", order);
		String totPrice=request.getParameter("totPrice");
		request.setAttribute("totPrice", totPrice);
		if(b){
			return "success";
		}else{
			return "fail";
		}
		
	}
	
	public String listOrder(){
		orderList=service.orderList();
		if(orderList.size()!=0){
			return "success";
		}else{
			return "fail";
		}
		
	}
	
	public String orderById(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("id");
		order=service.orderById(id);
		bookList1=order.getBookList();
		request.setAttribute("order", order);
		return "success";
	}
	
	public String confirmOrder()throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		CartService cartService=CartService.getInstance(request);
		cartList=cartService.findCartList();
		String totPrice=request.getParameter("totPrice");
		request.setAttribute("totPrice", totPrice);
		return "success";
	}

	public List<Cart> getCartList() {
		return cartList;
	}

	public void setCartList(List<Cart> cartList) {
		this.cartList = cartList;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public List<Book> getBookList1() {
		return bookList1;
	}

	public void setBookList1(List<Book> bookList1) {
		this.bookList1 = bookList1;
	}

	public OrderService getService() {
		return service;
	}

	public void setService(OrderService service) {
		this.service = service;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
}
