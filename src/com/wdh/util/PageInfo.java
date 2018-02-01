package com.wdh.util;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class PageInfo {
	int recordcount;
	int pagesum;
	int pagesize=5;
	int currentpage=1;
	String action;
	List<?> list=new ArrayList<>();
	
	public PageInfo(HttpServletRequest request) {
		action=request.getRequestURI();
		String page=request.getParameter("currentpage");
		if(page!=null) {
			currentpage=Integer.valueOf(page);
		}
		request.setAttribute("pageInfo", this);
	}
	public int getRecordcount() {
		return recordcount;
	}
	public void setRecordcount(int recordcount) {
		this.recordcount = recordcount;
	}
	public int getPagesum() {
		if(recordcount%pagesize==0) {
			return recordcount/pagesize;
		}else {
			return recordcount/pagesize+1;
		}
	}
	public void setPagesum(int pagesum) {
		this.pagesum = pagesum;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
}
