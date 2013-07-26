package com.minashop.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.minashop.entity.Book;
import com.minashop.util.HbUtil;

public class BookDao {

	@SuppressWarnings("unchecked")
	public List<Book> selectAllBook()throws SQLException{
		Session session=HbUtil.getSession();
		List<Book> bookList=new ArrayList<Book>();
		
		bookList=session.createQuery("from Book").list();
		session.close();
		return bookList;
	}
	
	public Book findBookById(Integer id){
		Session session=HbUtil.getSession();
		Book book=(Book)session.createQuery("from Book b where b.no=?")
				               .setInteger(0, id).uniqueResult();
		session.close();
		return book;
	}
}
