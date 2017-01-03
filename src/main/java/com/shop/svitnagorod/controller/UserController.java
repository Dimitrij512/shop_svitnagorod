package com.shop.svitnagorod.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {

  @RequestMapping(value = { "/welcome" }, method = RequestMethod.GET)
  public String loginPage(ModelMap model) {
    return "user";
  }

}