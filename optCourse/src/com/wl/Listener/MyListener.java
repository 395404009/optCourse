package com.wl.Listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyListener implements HttpSessionListener,ServletContextListener{

	
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		//获得application对象
		ServletContext sc  = arg0.getSession().getServletContext();
		//获得count
		
		int count = (int)sc.getAttribute("count");
		//count自增
		sc.setAttribute("count", ++count);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		//获得application对象
		ServletContext sc  = arg0.getSession().getServletContext();
		//获得count
		
		int count = (int)sc.getAttribute("count");
		//count自减
		sc.setAttribute("count", --count);
				
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		//创建application对象
		ServletContext sc = arg0.getServletContext();
		//向application添加在线人数
		sc.setAttribute("count", 0);
	}

}
