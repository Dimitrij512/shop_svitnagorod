package com.shop.svitnagorod.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.shop.svitnagorod.DTO.OrderDetailsDTO;
import com.shop.svitnagorod.model.OrderDetails;
import com.shop.svitnagorod.model.Orders;
import com.shop.svitnagorod.model.Product;
import com.shop.svitnagorod.model.Users;
import com.shop.svitnagorod.service.MailService;
import com.shop.svitnagorod.service.OrdersService;
import com.shop.svitnagorod.service.ProductService;
import com.shop.svitnagorod.service.UserService;

@Controller
@Scope("session")
@RequestMapping("/")
public class OrdersController {
  @Autowired
  ApplicationContext appContext;
  @Autowired
  ProductService productService;
  @Autowired
  UserService userService;
  @Autowired
  OrdersService orderService;
  @Autowired
  MailService mailService;

  private static final String PRODUCTS = "products";
  private static final String ORDER = "order";
  private static final String ORDERS = "orders";

  private List<OrderDetails> listOrderDetails = new ArrayList<OrderDetails>();

  @GetMapping("/basket")
  public String showAllProductsFromBasket(Model model) {
    List<Product> listProducts = new ArrayList<Product>();

    if (!listOrderDetails.isEmpty()) {
      for (int i = 0; i < listOrderDetails.size(); i++) {
        Product product = productService.findById(listOrderDetails.get(i).getProduct().getId());
        listProducts.add(product);
      }
    }
    model.addAttribute(PRODUCTS, listProducts);
    return "basket";
  }

  @RequestMapping(value = "/addProductToBasket", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = {
      "text/html; charset=UTF-8" })
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public @ResponseBody String addProductToBusket(@RequestBody int id) {

    if (!listOrderDetails.isEmpty()) {
      for (int i = 0; i < listOrderDetails.size(); i++) {
        if (listOrderDetails.get(i).getProduct().getId() == id) {
          return appContext.getMessage("Item.already.exist", null, null);
        }
      }
    }
    OrderDetails orderDetails = new OrderDetails();
    orderDetails.setProduct(productService.findById(id));
    listOrderDetails.add(orderDetails);

    return appContext.getMessage("Item.succes", null, null);
  }

  @DeleteMapping("/deletFromBasket")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteProduct(@RequestBody int id) {

    if (!listOrderDetails.isEmpty()) {
      for (int i = 0; i < listOrderDetails.size(); i++) {
        if (listOrderDetails.get(i).getProduct().getId() == id) {
          listOrderDetails.remove(i);
        }
      }
    }
  }

  @GetMapping("/getOrder")
  public String getOrder(Model model) {

    Orders order = new Orders();
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (!(authentication instanceof AnonymousAuthenticationToken)) {
      Users user = userService.findByLogin(authentication.getName());
      order.setName(user.getName());
      order.setEmail(user.getLogin());
      order.setPhone(user.getPhone());
    }
    model.addAttribute(ORDER, order);

    return "order";
  }

  @PostMapping("/getOrder")
  public String createOrder(@ModelAttribute(ORDER) Orders order) {

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (!(authentication instanceof AnonymousAuthenticationToken)) {
      Users user = userService.findByLogin(authentication.getName());
      order.setUser_id(user.getId());
    }
    if (!listOrderDetails.isEmpty()) {
      for (int i = 0; i < listOrderDetails.size(); i++) {
        listOrderDetails.get(i).setOrder(order);
      }
      order.setOrderDetails(listOrderDetails);
      orderService.save(order);
      listOrderDetails.clear();

      // mailService.sendMail(order.getEmail(), "text message");
    }
    return "redirect:/basket";
  }

  @RequestMapping(value = "/setCountProduct", headers = "Accept=*/*", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void setCountProduct(@RequestBody OrderDetailsDTO detailsDTO) {

    for (int i = 0; i < listOrderDetails.size(); i++) {
      if (listOrderDetails.get(i).getProduct().getId() == detailsDTO.getProduct_id()) {
        listOrderDetails.get(i).setCount(detailsDTO.getCount());
      }
    }
  }

  @GetMapping("/viewOrder/{id}")
  public String getOrderByUserId(@PathVariable int id, Model model) {

    model.addAttribute(ORDERS, orderService.findByUserId(id));

    return "orders";
  }
}
