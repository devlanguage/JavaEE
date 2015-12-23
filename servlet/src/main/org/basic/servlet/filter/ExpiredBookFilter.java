/**
 * Copyright reserved by Tellabs Communication Corp. LTD. The file
 * org.basic.book.ui.servlet.ExpiredBookFilter.java is created on 2008-6-13
 */
package org.basic.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 
 */
public class ExpiredBookFilter implements Filter {

    public void destroy() {

        System.out.println("Filter are destroied");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

    }

    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("Filter are inited");
    }

}
