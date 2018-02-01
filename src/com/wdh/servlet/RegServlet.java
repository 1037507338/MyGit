package com.wdh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wdh.util.DaoImpl;
import com.wdh.util.InsertTool;
import com.wdh.util.TB_User;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/reg.do")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
//		String username=request.getParameter("username");
//		String realname=request.getParameter("realname");
//		String sex=request.getParameter("sex");
//		String birth=request.getParameter("birth");
//		String password=request.getParameter("password");
//		String address=request.getParameter("province")+request.getParameter("city");
//		String[] hobby=request.getParameterValues("hobby");
//		Date d=null;
//		java.sql.Date date=null;
//		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
//		try {
//			d=df.parse(birth);
//			date = new java.sql.Date(d.getTime());
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		StringBuffer sb=new StringBuffer();
//		for(int i=0;i<hobby.length;i++) {
//			if(i==hobby.length-1) {
//				sb.append(hobby[i]);
//			}else {
//				sb.append(hobby[i]+",");
//			}
//		}
//		TB_User user=new TB_User();
//		user.setUsername(username);
//		user.setRealname(realname);
//		user.setSex(sex);
//		user.setBirth(date);
//		user.setPassword(password);
//		user.setAddress(address);
//		user.setHobby(sb.toString());
		InsertTool it=new InsertTool();
		TB_User user=it.autoinsert(request, TB_User.class);
		System.out.println("user:"+user);
		DaoImpl dImpl=new DaoImpl();
		dImpl.userinsert(user);
		response.sendRedirect("login.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
