package com.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class sessionlistener
 *
 */
//@WebListener
public class sessionlistener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public sessionlistener() {
    	System.out.println("new sessionlistener");
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.println("session created");
    	se.getSession().setAttribute("user", "xiaowu");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.println("session destory");
    }
	
}
