package com.shop.svitnagorod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shop.svitnagorod.service.CategoryService;
import com.shop.svitnagorod.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

  public static final String USERS = "users";
  public static final String CATEGORIES = "categories";

  @Autowired
  CategoryService categoryService;
  @Autowired
  UserService userService;

  @RequestMapping(value = { "/welcome" }, method = RequestMethod.GET)
  public String loginPage(Model model) {
    // System.out.println("Before");
    //
    // Category category = new Category();
    // category.setName("categoryNew222");
    //
    // Product pr = new Product();
    // pr.setName("111noteNote1111");
    // pr.setDescription("aasfasfasf");
    // pr.setPrice(500);
    //
    // Product pr2 = new Product();
    // pr2.setName("222noteNote222");
    // pr2.setDescription("aasf2222fasf");
    // pr2.setPrice(1500);
    //
    // HashSet<Product> productList = new HashSet<Product>();
    //
    // productList.add(pr);
    // productList.add(pr2);
    // category.setProducts(productList);
    //
    // categoryService.save(category);
    // System.out.println("After service");
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
    return "managementCategories";
  }

}
