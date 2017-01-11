package com.shop.svitnagorod.configuration;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {
  private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

  public RedirectStrategy getRedirectStrategy() {
    return redirectStrategy;
  }

  public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
    this.redirectStrategy = redirectStrategy;
  }

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws IOException, ServletException {

    handle(request, response, authentication);
    clearAuthenticationAttributes(request);

  }

  private void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
      throws IOException, ServletException {
    String targetUrl = determineTargetUrl(authentication);
    if (response.isCommitted()) {
      return;
    }
    redirectStrategy.sendRedirect(request, response, targetUrl);
  }

  private String determineTargetUrl(Authentication authentication) {

    boolean isUser = false;
    boolean isAdmin = false;
    Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
    for (GrantedAuthority grantedAuthority : authorities) {
      System.out.println(grantedAuthority.getAuthority());
      System.out.println(grantedAuthority.getAuthority().equals("ADMIN"));
      if (grantedAuthority.getAuthority().equals("USER")) {
        isUser = true;
        break;
      } else if (grantedAuthority.getAuthority().equals("ADMIN")) {

        isAdmin = true;
        break;
      }
    }
    if (isUser) {
      return "/user/welcome";
    } else if (isAdmin) {
      return "/admin/welcome";
    } else {
      throw new IllegalStateException();
    }
  }

  private void clearAuthenticationAttributes(HttpServletRequest request) {

    HttpSession session = request.getSession(false);
    if (session == null) {
      return;
    }
    session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
  }
}
