package com.shop.svitnagorod.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class LoginLogoutController {

  private static final String SUCCES = "succes";

  @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
  public String getLoginPage(Model model) {

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth instanceof AnonymousAuthenticationToken) {
      return "login";
    }
    model.addAttribute(SUCCES, auth.isAuthenticated());

    return "login";
  }

  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public String getLogoutPage(HttpServletRequest request, HttpServletResponse response) {

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth != null) {
      new SecurityContextLogoutHandler().logout(request, response, auth);
    }
    return "redirect:/login";
  }

  @RequestMapping(value = "/403", method = RequestMethod.GET)
  public String error403(Model model) {

    model.addAttribute("message", "You don't have permission to access this page");

    return "error";
  }

}
