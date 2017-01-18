package com.shop.svitnagorod.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shop.svitnagorod.model.Category;
import com.shop.svitnagorod.model.Product;
import com.shop.svitnagorod.service.CategoryService;

@Controller
@RequestMapping("/admin")
public class AdminController {

  @Autowired
  CategoryService categoryService;

  @RequestMapping(value = { "/welcome" }, method = RequestMethod.GET)
  public String loginPage(ModelMap model) {
    System.out.println("Before");
    Category category = new Category("Computer");
    Product pc = new Product("DELL PC", "Quad-core PC", 1200, category);

    Set<Product> products = new HashSet<Product>();
    products.add(pc);
    category.setProducts(products);
    System.out.println("Before service");
    categoryService.save(category);
    System.out.println("After service");
    return "admin";
  }

}
