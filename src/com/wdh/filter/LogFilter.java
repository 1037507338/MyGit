package com.wdh.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LogFilter
 */
@WebFilter("*.do")
public class LogFilter implements Filter {
	List<String> list=new ArrayList<String>();
    /**
     * Default constructor. 
     */
    public LogFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpServletRequest hsr=(HttpServletRequest) request;
		HttpSession session=hsr.getSession();
		String path=hsr.getContextPath();
		String uri=hsr.getRequestURI().replaceAll(path, "");
		if(session.getAttribute("user")!=null||list.contains(uri)) {
			chain.doFilter(request, response);
		}else {
			PrintWriter out=response.getWriter();
			out.println("<script>window.top.location.href='"+path+"/login.html'</script>");
			out.flush();
			out.close();
		}
		// pass the request along the filter chain
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		list.add("/login.html");
		list.add("/login.do");
		list.add("/register.html");
		list.add("/reg.do");
	}

}
