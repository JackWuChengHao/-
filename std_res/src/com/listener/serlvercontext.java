package com.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class serlvercontext
 *
 */
//@WebListener
public class serlvercontext implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public serlvercontext() {
        // TODO Auto-generated constructor stub
    	System.out.println("new ServletContextListener");
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	System.out.println("new destoryServletContextListener");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	System.out.println("contextInitialized");
    }
	
}
