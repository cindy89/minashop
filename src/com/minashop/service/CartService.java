package com.minashop.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.minashop.entity.Book;
import com.minashop.entity.Cart;

public class CartService {
	
	private Map<Integer,Cart> carts=new HashMap<Integer,Cart>();
	private BookService bservice=new BookService();
	
	public static CartService getInstance(HttpServletRequest request){
		HttpSession session=request.getSession();
		CartService cartService=(CartService)session.getAttribute("cart_key");
		if(cartService==null){
			cartService=new CartService();
			session.setAttribute("cart_key", cartService);
		}
		return cartService;
	}
	
	public boolean addCart(Integer id){
		if(!carts.containsKey(id)){
			Book book=bservice.findBookById(id);
			Cart cart=new Cart();
			cart.setBook(book);
			cart.setNum(1);
			carts.put(id, cart);
			return true;
		}else{
			return false;
		}
	}
	public List<Cart> findCartList(){
		List<Cart> cartList=new ArrayList<Cart>();
		for(Integer id:carts.keySet()){
			cartList.add(carts.get(id));
		}
		return cartList;
	}
	public boolean updateCart(Integer no,Integer num){
		if(carts.containsKey(no)){
			Cart cart=carts.get(no);
			if(num<=0){
				carts.remove(no);
			}else{
				cart.setNum(num);
			}
			return true;
		}else{
			return false;
		}
	}
	public boolean deleteCart(Integer no){
		if(carts.containsKey(no)){
			carts.remove(no);
			return true;
		}else{
			return false;
		}
	}
	public void clear(){
		carts.clear();
	}
	
	public Map<Integer, Cart> getCarts() {
		return carts;
	}

	public void setCarts(Map<Integer, Cart> carts) {
		this.carts = carts;
	}

	public BookService getBservice() {
		return bservice;
	}

	public void setBservice(BookService bservice) {
		this.bservice = bservice;
	}
	
}
