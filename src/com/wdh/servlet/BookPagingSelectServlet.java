package com.wdh.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wdh.util.DaoImpl;
import com.wdh.util.TB_Book;

/**
 * Servlet implementation class BookPagingSelectServlet
 */
@WebServlet("/pagingbookselect.do")
public class BookPagingSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookPagingSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoImpl dImpl=new DaoImpl();
		int pagenum=Integer.valueOf(request.getParameter("pagenum"));
		int pagesum=dImpl.pageSum();
		List<TB_Book> list=dImpl.pageSelect(pagenum);
		List<Integer> l=new ArrayList<Integer>();
		for(int i=1;i<=pagesum;i++) {
			l.add(i);
		}
		request.setAttribute("booklist", list);
		request.setAttribute("pagesum", l);
		request.getRequestDispatcher("/WEB-INF/views/pagingbookselect.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
