package com.minashop.action;

import java.util.ArrayList;
import java.util.List;

import com.minashop.entity.Book;
import com.minashop.service.BookService;
import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport {
	
	private static final long serialVersionUID = -1635202325492084079L;
	private BookService service=new BookService();
	private List<Book> bookList=new ArrayList<Book>();
	
	public String selectAllBook()throws Exception{
		bookList=service.selectAllBook();
		return "success";
	}
	
	public BookService getService() {
		return service;
	}
	public void setService(BookService service) {
		this.service = service;
	}
	public List<Book> getBookList() {
		return bookList;
	}
	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	
}
