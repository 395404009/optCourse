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
		//���application����
		ServletContext sc  = arg0.getSession().getServletContext();
		//���count
		
		int count = (int)sc.getAttribute("count");
		//count����
		sc.setAttribute("count", ++count);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		//���application����
		ServletContext sc  = arg0.getSession().getServletContext();
		//���count
		
		int count = (int)sc.getAttribute("count");
		//count�Լ�
		sc.setAttribute("count", --count);
				
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		//����application����
		ServletContext sc = arg0.getServletContext();
		//��application�����������
		sc.setAttribute("count", 0);
	}

}
