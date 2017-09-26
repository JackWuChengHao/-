package com.fliter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class allow_All_domain
 */
//@WebFilter("/allow_All_domain")
public class allow_All_domain implements Filter {

    /**
     * Default constructor. 
     */
    public allow_All_domain() {
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
		// place your code here
		HttpServletResponse httpresponse = (HttpServletResponse)response;
		httpresponse.setHeader("Access-Control-Allow-Origin", "*");
		httpresponse.setHeader("Access-Control-Allow-Methods", "*");
		httpresponse.setHeader("Access-Control-Max-Age", "3600");
		httpresponse.setHeader("Access-Control-Allow-Headers",
	                "Origin, X-Requested-With, Content-Type, Accept");
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
