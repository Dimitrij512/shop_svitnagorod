package com.shop.svitnagorod.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class LoginLogoutController {

  private static final String SUCCES = "succes";

  @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
  public String getLoginPage(ModelMap model, @ModelAttribute("error") String error) {

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth instanceof AnonymousAuthenticationToken) {
      return "login";
    }

    if (error != null) {
      model.addAttribute("error", "Invalid username and password!");
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
    return "redirect:/login?logout";
  }

}
