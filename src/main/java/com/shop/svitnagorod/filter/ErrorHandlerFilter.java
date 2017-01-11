package com.shop.svitnagorod.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

public class ErrorHandlerFilter implements Filter {

  private static final Logger LOGGER = Logger.getLogger(ErrorHandlerFilter.class);
  private final String pathToErrorJSP = "/WEB-INF/views/pages/error.jsp";

  @Override
  public void destroy() {
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
      throws IOException, ServletException {

    try {
      filterChain.doFilter(request, response);
    } catch (Exception ex) {
      request.getRequestDispatcher(pathToErrorJSP).forward(request, response);
      System.out.println("filter");
      LOGGER.error("Error was cought with filter", ex);
    }
  }

  @Override
  public void init(FilterConfig arg0) throws ServletException {
  }

}
