package com.hotel.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.sun.istack.internal.logging.Logger;

/**
 * Servlet Filter implementation class Reg
 */
//@WebFilter("/CharacterEncodingFilter")
public class CharacterEncodingFilter implements Filter {
    //private final Logger logger=Logger.getLogger(componentClass)
	private String charset =null;
    /**
     * Default constructor. 
     */
    public CharacterEncodingFilter() {
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
		
        if (charset != null) {
        	request.setCharacterEncoding(charset);
        	response.setCharacterEncoding(charset); 
        }
        chain.doFilter(request, response);

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		//读取初始化参数
        String initParam = fConfig.getInitParameter("charset");
        if ( initParam != null &&  initParam.trim().length() >0 ) {
              charset = initParam;
      }


	}

}
