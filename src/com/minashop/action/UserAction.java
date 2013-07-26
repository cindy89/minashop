package com.minashop.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.minashop.entity.Book;
import com.minashop.entity.User;
import com.minashop.service.BookService;
import com.minashop.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String name;
	private String pwd;
	private UserService service=new UserService();
	private BookService bservice=new BookService();
	List<Book> bookList=new ArrayList<Book>();
	/**
	 * user login
	 * @return
	 * */
	public String execute()throws Exception{
		return "success";
	}
	public String login()throws Exception{
		
		User user=service.findUser(name, pwd);
		if(user!=null){
			bookList=bservice.selectAllBook();
			return "success";
		}else{
			return "fail";
		}
	}
	/**
	 * user register
	 * @return
	 * */
	public String register()throws Exception{
		User user=new User();
		HttpServletRequest request= ServletActionContext.getRequest();
		user.setName(request.getParameter("name"));
		user.setPwd(request.getParameter("pwd"));
		user.setZip(request.getParameter("zip"));
		user.setAddr(request.getParameter("addr"));
		user.setPhone(request.getParameter("phone"));
		user.setEmail(request.getParameter("email"));
		if(user.getName()!=null){
			service.addUser(user);
			return "success";
		}else{
			return "fail";
		}
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public UserService getService() {
		return service;
	}
	public void setService(UserService service) {
		this.service = service;
	}
	public List<Book> getBookList() {
		return bookList;
	}
	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	public BookService getBservice() {
		return bservice;
	}
	public void setBservice(BookService bservice) {
		this.bservice = bservice;
	}
	
}
