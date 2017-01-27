package com.shop.svitnagorod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.shop.svitnagorod.DTO.ProductDTO;
import com.shop.svitnagorod.model.Category;
import com.shop.svitnagorod.service.CategoryService;
import com.shop.svitnagorod.service.ProductService;
import com.shop.svitnagorod.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

  public static final String USERS = "users";
  public static final String CATEGORIES = "categories";
  public static final String CATEGORY = "category";
  public static final String PRODUCTS = "products";
  public static final String PRODUCT = "product";

  @Autowired
  ProductService productService;
  @Autowired
  CategoryService categoryService;
  @Autowired
  UserService userService;

  @RequestMapping(value = { "/welcome" }, method = RequestMethod.GET)
  public String loginPage(Model model) {

    return "admin";
  }

  @GetMapping("/settingWebsite")
  public String settingWebsite(Model model) {

    return "settingWebSite";
  }

  @GetMapping("/settingWebsite/users")
  public String managementUsers(Model model) {
    model.addAttribute(USERS, userService.findAllUser());

    return "managementUsers";
  }

  @GetMapping("/settingWebsite/categories")
  public String managementCategory(Model model) {
    model.addAttribute(CATEGORIES, categoryService.findAllCategory());
    model.addAttribute(CATEGORY, new Category());

    return "managementCategories";
  }

  @GetMapping("/settingWebsite/products")
  public String managementProduct(Model model) {
    System.out.println("Products are doing ...............");
    model.addAttribute(PRODUCTS, productService.findAllProducts());
    model.addAttribute(PRODUCT, new ProductDTO());
    model.addAttribute(CATEGORIES, categoryService.findAllCategory());
    ;

    return "managementProducts";
  }

  @RequestMapping(value = "/settingWebsite/products", method = RequestMethod.POST)
  public String addProduct(@ModelAttribute(PRODUCTS) ProductDTO productDTO) {
    System.out.println("Product are saving ...............");
    productService.save(productDTO);

    return "redirect:/admin/settingWebsite/products";
  }

  @PostMapping("/settingWebsite/categories")
  public String addCategory(@ModelAttribute(CATEGORIES) Category category) {
    categoryService.save(category);

    return "redirect:/admin/settingWebsite/categories";
  }

  @DeleteMapping("/settingWebsite/categories/delete")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteCategory(@RequestBody int id) {
    categoryService.delete(id);
  }

  @DeleteMapping("/settingWebsite/user/delete")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteUser(@RequestBody int id) {
    System.out.println("ID USER = " + id);
    userService.delete(id);
  }

  @DeleteMapping("/settingWebsite/products/delete")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteProduct(@RequestBody int id) {
    productService.delete(id);
  }

}
