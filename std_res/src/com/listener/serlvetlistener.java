package com.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Application Lifecycle Listener implementation class serlvetlistener
 *
 */
//@WebListener
public class serlvetlistener implements ServletRequestListener {

    /**
     * Default constructor. 
     */
    public serlvetlistener() {
        // TODO Auto-generated constructor stub
    	System.out.println("new ServletRequestListener");
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
    	System.out.println("requestDestroyed");
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
    	System.out.println("requestInitialized");
    }
	
}
