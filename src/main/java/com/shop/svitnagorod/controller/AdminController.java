package com.shop.svitnagorod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shop.svitnagorod.model.Category;
import com.shop.svitnagorod.service.CategoryService;
import com.shop.svitnagorod.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

  public static final String USERS = "users";
  public static final String CATEGORIES = "categories";
  public static final String CATEGORY = "category";

  @Autowired
  CategoryService categoryService;
  @Autowired
  UserService userService;

  @RequestMapping(value = { "/welcome" }, method = RequestMethod.GET)
  public String loginPage(Model model) {

    return "admin";
  }

  @RequestMapping(value = { "/settingWebsite" }, method = RequestMethod.GET)
  public String settingWebsite(Model model) {

    return "settingWebSite";
  }

  @RequestMapping(value = { "/settingWebsite/users" }, method = RequestMethod.GET)
  public String managementUsers(Model model) {
    model.addAttribute(USERS, userService.findAllUser());

    return "managementUsers";
  }

  @RequestMapping(value = { "/settingWebsite/categories" }, method = RequestMethod.GET)
  public String managementCategory(Model model) {
    model.addAttribute(CATEGORIES, categoryService.findAllCategory());
    model.addAttribute(CATEGORY, new Category());

    return "managementCategories";
  }

  @RequestMapping(value = { "/settingWebsite/categories" }, method = RequestMethod.POST)
  public String addCategory(@ModelAttribute(CATEGORIES) Category category) {
    categoryService.save(category);

    return "redirect:/admin/settingWebsite/categories";
  }

}
