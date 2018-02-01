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
 * Servlet implementation class BookUpdatePrepareServlet
 */
@WebServlet("/bookupdateprepare.do")
public class BookUpdatePrepareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookUpdatePrepareServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DaoImpl dImpl=new DaoImpl();
		int bookid=Integer.valueOf(request.getParameter("bookid"));
		TB_Book book=dImpl.oneSelect(bookid);
		request.setAttribute("book", book);
		request.getRequestDispatcher("/WEB-INF/views/bookupdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
