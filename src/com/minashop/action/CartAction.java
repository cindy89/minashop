package com.minashop.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.minashop.entity.Cart;
import com.minashop.service.CartService;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport{

	private static final long serialVersionUID = -5276832225653182810L;
	private CartService service=new CartService();
	private List<Cart> cartList=new ArrayList<Cart>();
	private String totPrice="";
	
	public String addCart(){
		HttpServletRequest request=ServletActionContext.getRequest();
		service=CartService.getInstance(request);
		String noStr=request.getParameter("no");
		Integer no=Integer.valueOf(noStr);
		boolean b=service.addCart(no);
		return "listBook";
		/*if(b){
			return "listBook";
		}else{
			
			return "fail";
		}*/
	}
	
	public String listCart(){
		HttpServletRequest request=ServletActionContext.getRequest();
		service=CartService.getInstance(request);
		cartList=service.findCartList();
		totPrice();
		return "success";
	}
	
	public String updateCart(){
		HttpServletRequest request=ServletActionContext.getRequest();
		service=CartService.getInstance(request);
		String noStr=request.getParameter("no");
		String numStr=request.getParameter("num");
		Integer no=Integer.valueOf(noStr);
		Integer num=Integer.valueOf(numStr);
		boolean b=service.updateCart(no, num);
		if(b){
			return "success";
		}else{
			return "error";
		}
	}
	public String deleteCart(){
		HttpServletRequest request=ServletActionContext.getRequest();
		service=CartService.getInstance(request);
		Integer no=Integer.valueOf(request.getParameter("no"));
		boolean b=service.deleteCart(no);
		if(b){
			return "success";
		}else{
			return "error";
		}
	}
	public String clear(){
		HttpServletRequest request=ServletActionContext.getRequest();
		service=CartService.getInstance(request);
		service.clear();
		return "success";
	}
	
	public void totPrice(){
		float f=0;
		for(Cart cart:cartList){
			Float price=Float.valueOf(cart.getBook().getPrice());
			Integer num=cart.getNum();
			 f+=num*price;
			totPrice=f+"";
		}
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("totPrice", totPrice);
	}
	
	public CartService getService() {
		return service;
	}
	public void setService(CartService service) {
		this.service = service;
	}
	public List<Cart> getCartList() {
		return cartList;
	}

	public void setCartList(List<Cart> cartList) {
		this.cartList = cartList;
	}

	public String getTotPrice() {
		return totPrice;
	}

	public void setTotPrice(String totPrice) {
		this.totPrice = totPrice;
	}
	
}
