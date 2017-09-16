package xw.stdres;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class filter2
 */
//@WebFilter("/filter2")
public class filter2 implements Filter {

    /**
     * Default constructor. 
     */
    public filter2() {
        // TODO Auto-generated constructor stub
    	System.out.println("new filter 2");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy filter 2");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletResponse httpresponse = (HttpServletResponse)response;
		HttpServletRequest httprequest= (HttpServletRequest)request;
		// place your code here
		System.out.println("filter 2");
		if("xiaowu".equals(httprequest.getParameter("user"))) 
			chain.doFilter(request, response);
		else {
			httprequest.getRequestDispatcher("/error").forward(request, response);
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init filter 2");
	}

}
