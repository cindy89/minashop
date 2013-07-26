package com.minashop.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.minashop.dao.BookDao;
import com.minashop.entity.Book;

public class BookService {
	private BookDao dao=new BookDao();
	
	public List<Book> selectAllBook()throws SQLException{
		List<Book> bookList=new ArrayList<Book>();
		bookList=dao.selectAllBook();
		return bookList;
	}
	
	public Book findBookById(Integer id){
		Book book=dao.findBookById(id);
		return book;
	}
	public BookDao getDao() {
		return dao;
	}
	public void setDao(BookDao dao) {
		this.dao = dao;
	}
	
}
