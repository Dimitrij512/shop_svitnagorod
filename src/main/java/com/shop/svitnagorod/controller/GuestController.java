package com.shop.svitnagorod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shop.svitnagorod.model.User;
import com.shop.svitnagorod.service.UserService;

@Controller
@RequestMapping("/")
public class GuestController {

  BCryptPasswordEncoder cryptor = new BCryptPasswordEncoder();

  @Autowired
  UserService userService;

  private static final String REGISTRATION = "registration";

  @RequestMapping(value = { "/" }, method = RequestMethod.GET)
  public String homePage(Model model) {
    return "home";
  }

  @RequestMapping(value = { "/products" }, method = RequestMethod.GET)
  public String productsPage(Model model) {
    return "products";
  }

  @RequestMapping(value = { "/contactus" }, method = RequestMethod.GET)
  public String contactUsPage(Model model) {
    return "contactus";
  }

  @RequestMapping(value = { "/registration" }, method = RequestMethod.GET)
  public String getRegistration(Model model) {
    model.addAttribute(REGISTRATION, new User());
    return "createUpdateRegistration";
  }

  @RequestMapping(value = { "/registration" }, method = RequestMethod.POST)
  public String createUser(@ModelAttribute(REGISTRATION) User user) {
    String userPassword = user.getPassword();
    user.setPassword(cryptor.encode(userPassword));
    userService.save(user);
    return "redirect:/registration?registrationSuccess=true";
  }

}
