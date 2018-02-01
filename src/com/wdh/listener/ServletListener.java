package com.wdh.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.wdh.util.TB_User;

/**
 * Application Lifecycle Listener implementation class ServletListener
 *
 */
@WebListener
public class ServletListener implements HttpSessionListener, HttpSessionAttributeListener {
	Map<TB_User, HttpSession> map=new HashMap<TB_User, HttpSession>();
    /**
     * Default constructor. 
     */
    public ServletListener() {
        // TODO Auto-generated constructor stub
    }
    
    /**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */

	public void attributeAdded(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
		HttpSession session=se.getSession();
    	TB_User user=(TB_User) session.getAttribute("user");
    	if(map.containsKey(user)) {
    		map.get(user).removeAttribute("user");
    		map.get(user).invalidate();
    		map.remove(user);
    	}
    	map.put(user, session);
    }

	
	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		for(TB_User user:map.keySet()) {
			if(map.get(user).equals(se.getSession())) {
				map.remove(user);
			}
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		HttpSession session=se.getSession();
    	TB_User user=(TB_User) session.getAttribute("user");
    	if(map.containsKey(user)) {
    		map.get(user).removeAttribute("user");
    		map.get(user).invalidate();
    		map.remove(user);
    	}
    	map.put(user, session);
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("id为"+se.getSession().getId()+"的session创建了");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		for(TB_User user:map.keySet()) {
			if(map.get(user).equals(se.getSession())) {
				map.remove(user);
			}
		}
		System.out.println("id为"+se.getSession().getId()+"的session注销了");
	}
	
}
