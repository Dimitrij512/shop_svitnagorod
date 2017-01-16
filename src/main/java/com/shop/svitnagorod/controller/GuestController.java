package com.shop.svitnagorod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shop.svitnagorod.model.User;
import com.shop.svitnagorod.service.UserService;
import com.shop.svitnagorod.validator.UserValidator;

@Controller
@RequestMapping("/")
public class GuestController {

  private static final String REGISTRATION = "registration";
  private BCryptPasswordEncoder cryptor = new BCryptPasswordEncoder();

  @Autowired
  UserValidator userValidator;

  @Autowired
  UserService userService;

  @InitBinder
  public void initBinder(WebDataBinder binder) {
    binder.addValidators(userValidator);
  }

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
  public String createUser(@Validated @ModelAttribute(REGISTRATION) User user, BindingResult bindingResult,
      Model model) {
    if (bindingResult.hasErrors()) {
      model.addAttribute(REGISTRATION, user);
      return "createUpdateRegistration";
    }
    String userPassword = user.getPassword();
    user.setPassword(cryptor.encode(userPassword));
    userService.save(user);
    return "redirect:/registration?registrationSuccess=true";
  }

}
