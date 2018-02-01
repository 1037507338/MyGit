package com.wdh.util;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class InsertTool {
	
	public<T> T autoinsert(HttpServletRequest request,Class<T> c) {
		Field[] field=c.getDeclaredFields();
		T t=null;
		try {
			t = c.newInstance();
			for(int i=0;i<field.length;i++) {
				field[i].setAccessible(true);
				Object param = null;
				if(request.getParameter(field[i].getName())!=null) {
					if (field[i].getType() == String.class) {
						param = request.getParameter(field[i].getName());
					} else if (field[i].getType() == int.class || field[i].getType() == Integer.class) {
						param = Integer.valueOf(request.getParameter(field[i].getName()));
					} else {
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
						Date d = null;
						try {
							d = format.parse(request.getParameter(field[i].getName()));
						} catch (Exception e) {
							e.printStackTrace();
						}
						param = new java.sql.Date(d.getTime());
					}
					field[i].set(t, param);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
}
