package com.wdh.util;

public class TB_Book {
	private Integer bookid;
	private String bookname;
	private Integer bookprice;
	public TB_Book() {
		super();
	}
	public TB_Book(Integer bookid, String bookname, Integer bookprice) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.bookprice = bookprice;
	}
	public Integer getBookid() {
		return bookid;
	}
	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public Integer getBookprice() {
		return bookprice;
	}
	public void setBookprice(Integer bookprice) {
		this.bookprice = bookprice;
	}
	@Override
	public String toString() {
		return "TB_Book [bookid=" + bookid + ", bookname=" + bookname + ", bookprice=" + bookprice + "]";
	}
}
