package com.minashop.entity;

import java.util.List;

public class Order {
	private Integer id;
	private String cname;
	private String zip;
	private String addr;
	private String phone;
	private String email;
	private String bNo;
	private String bNum;
	
	private String subNum;
	private String subPrice;
	private List<Book> bookList;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getbNo() {
		return bNo;
	}
	public void setbNo(String bNo) {
		this.bNo = bNo;
	}
	public String getbNum() {
		return bNum;
	}
	public void setbNum(String bNum) {
		this.bNum = bNum;
	}
	public String getSubNum() {
		return subNum;
	}
	public void setSubNum(String subNum) {
		this.subNum = subNum;
	}
	public String getSubPrice() {
		return subPrice;
	}
	public void setSubPrice(String subPrice) {
		this.subPrice = subPrice;
	}
	public List<Book> getBookList() {
		return bookList;
	}
	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	
	
}
