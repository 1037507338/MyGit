package com.wdh.util;

import java.util.List;

public class DaoImpl extends BaseDao {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public TB_User login(String username,String password) {
		TB_User user=(TB_User) this.login(TB_User.class, "select * from TB_User where username=? and password=md5(?)", username, password);
		return user;
	}
	public void userinsert(TB_User user) {
		insert(user);
	}
	public List<TB_Book> bookSelect() {
		List<TB_Book> list=select("select * from TB_Book",TB_Book.class);
		return list;
	}
	public List<TB_Book> partSelect(String partname){
		List<TB_Book> list=select("select * from TB_Book where bookname like '%"+partname+"%'",TB_Book.class);
		return list;
	}
	public void bookDelete(int bookid) {
		this.launchsql("Delete from TB_Book where bookid=?",bookid);
	}
	public void bookInsert(String bookname,int bookprice) {
		this.launchsql("insert into TB_Book values(null,?,?)",bookname,bookprice);
	}
	public List<TB_Book> pageSelect(int pageNum) {
		List<TB_Book> list=getpage("select * from TB_Book limit ?,?",TB_Book.class, pageNum);
		return list;
	}
	public int pageSum() {
		int sum=pagesum(TB_Book.class);
		return sum;
	}
	public TB_Book oneSelect(int bookid) {
		List<TB_Book> list=select("select * from TB_Book where bookid=?",TB_Book.class,bookid);
		TB_Book book=list.get(0);
		return book;
	}
	public void bookUpdate(TB_Book book) {
		this.launchsql("Update TB_Book set bookname=?,bookprice=? where bookid=?", book.getBookname(),book.getBookprice(),book.getBookid());
	}
}
