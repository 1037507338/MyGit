package com.wdh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wdh.util.DaoImpl;
import com.wdh.util.TB_Book;

/**
 * Servlet implementation class BookUpdateServlet
 */
@WebServlet("/bookupdate.do")
public class BookUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoImpl dImpl=new DaoImpl();
		int bookid=Integer.valueOf(request.getParameter("bookid"));
		String bookname=request.getParameter("bookname");
		int bookprice=Integer.valueOf(request.getParameter("bookprice"));
		TB_Book book=new TB_Book();
		book.setBookid(bookid);
		book.setBookname(bookname);
		book.setBookprice(bookprice);
		dImpl.bookUpdate(book);
		response.sendRedirect("bookselect.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
