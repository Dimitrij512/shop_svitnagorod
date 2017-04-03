package com.shop.svitnagorod.controller;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.shop.svitnagorod.DTO.UserDTO;
import com.shop.svitnagorod.model.Notification;
import com.shop.svitnagorod.model.OrderMessage;
import com.shop.svitnagorod.model.Users;
import com.shop.svitnagorod.service.BannerService;
import com.shop.svitnagorod.service.CategoryService;
import com.shop.svitnagorod.service.GeneralService;
import com.shop.svitnagorod.service.MailService;
import com.shop.svitnagorod.service.OrderDetailsService;
import com.shop.svitnagorod.service.OrdersService;
import com.shop.svitnagorod.service.ProductService;
import com.shop.svitnagorod.service.SuperCategoryService;
import com.shop.svitnagorod.service.UserService;
import com.shop.svitnagorod.validator.UserValidator;

@Controller
@RequestMapping("/")
public class GuestController {
  private static final String REGISTRATION = "registration";

  // private BCryptPasswordEncoder cryptor = new BCryptPasswordEncoder();

  @Autowired
  UserValidator userValidator;

  @Autowired
  SuperCategoryService superCategoryService;

  @Autowired
  CategoryService categoryService;

  @Autowired
  UserService userService;
  @Autowired
  GeneralService generalService;

  @Autowired
  ProductService productSrvice;

  @Autowired
  OrdersService orderService;

  @Autowired
  OrderDetailsService orderDetailsServic;

  @Autowired
  BannerService bannerService;

  @Autowired
  MailService mailService;

  @Autowired
  Facebook facebook;
  @Autowired
  ProviderSignInUtils providerSignInUtils;

  private static final String BANNERS = "banners";
  private static final String CATEGORYES = "categoryes";
  private static final String PRODUCTS = "products";
  private static final String PRODUCT = "product";
  private static final String CATEGORYNAME = "categoryName";

  @InitBinder
  public void initBinder(WebDataBinder binder) {

    binder.addValidators(userValidator);
  }

  @GetMapping("/")
  public String homePage(Model model) {

    model.addAttribute(BANNERS, bannerService.findEnabled());
    model.addAttribute(CATEGORYES, categoryService.findAllCategory());
    model.addAttribute(PRODUCTS, productSrvice.findAllProducts());

    return "home";
  }

  @GetMapping("/products/{id}")
  public String productsByCategoryID(@PathVariable int id, Model model) {

    model.addAttribute(CATEGORYNAME, categoryService.findById(id).getName());
    model.addAttribute(PRODUCTS, productSrvice.findProductsByCategoryID(id));

    return "products";
  }

  @GetMapping("/productDetail/{id}")
  public String productDetail(@PathVariable int id, Model model) {

    model.addAttribute(PRODUCT, productSrvice.findById(id));

    return "productDetail";
  }

  @GetMapping("/contactus")
  public String contactUsPage(Model model) {

    return "contactus";
  }

  @RequestMapping(value = { "/registration" }, method = RequestMethod.GET)
  public String getRegistration(Model model) {

    model.addAttribute(REGISTRATION, new UserDTO());

    return "createUpdateRegistration";
  }

  @GetMapping("/facebook/signup")
  public String signup(WebRequest request, HttpServletRequest requsts, Model model) {
    Connection<?> connection = providerSignInUtils.getConnectionFromSession(request);
    Users users = null;
    if (connection != null) {

      facebook = (Facebook) connection.getApi();
      String[] fields = { "id", "email", "age_range", "birthday", "first_name", "last_name", "gender" };
      User userProfile = facebook.fetchObject("me", User.class, fields);
      users = userService.findByLogin(userProfile.getEmail());
      if (users == null) {
        users = new Users();
        users.setLogin(userProfile.getEmail());
        users.setName(userProfile.getFirstName());
        users.setSurname(userProfile.getLastName());
        users.setRole("CUSTOMER");
        users.setPassword(randomAlphabetic(15));
        users.setAvatar(facebook.userOperations().getUserProfileImage());

        userService.saveUser(users);
        // mailService.sendRegistrationMail(users.getLogin(), users.getName(),
        // users.getSurname());
      }
    }
    userService.authenticateUserAndSetSession(users, requsts);

    return "redirect:/";
  }

  @PostMapping("/registration")
  public String createUser(@ModelAttribute(REGISTRATION) @Validated UserDTO userDTO, BindingResult bindingResult,
      Model model) {
    if (bindingResult.hasErrors()) {
      model.addAttribute(REGISTRATION, userDTO);
      return "createUpdateRegistration";
    }

    String userPassword = userDTO.getPassword();
    userDTO.setPassword(userPassword);
    userService.save(userDTO);
    // mailService.sendRegistrationMail(userDTO.getLogin(), userDTO.getName(),
    // userDTO.getSurname());

    return "redirect:/registration?registrationSuccess=true";
  }

  @GetMapping("/users/{id}/avatar")
  public void getUserAvatar(HttpServletResponse response, @PathVariable int id) {
    byte[] data = userService.findById(id).getAvatar();

    if (data != null) {
      response.setContentType(MediaType.IMAGE_JPEG_VALUE);
      response.setContentLength(data.length);
      try (ServletOutputStream outputStream = response.getOutputStream()) {
        FileCopyUtils.copy(data, outputStream);
      } catch (IOException e) {
      }
    }
  }

  @GetMapping("/usersInfo/{name}/avatar")
  public void getUserAvatarByLogin(HttpServletResponse response, @PathVariable String name) {
    byte[] data = userService.findByLogin(name).getAvatar();
    if (data != null) {
      response.setContentType(MediaType.IMAGE_JPEG_VALUE);
      response.setContentLength(data.length);
      try (ServletOutputStream outputStream = response.getOutputStream()) {
        FileCopyUtils.copy(data, outputStream);
      } catch (IOException e) {
      }
    }
  }

  @GetMapping("/productInfo/{id}/image")
  public void getProductImage(HttpServletResponse response, @PathVariable int id) {
    byte[] data = productSrvice.findById(id).getImage();
    if (data != null) {
      response.setContentType(MediaType.IMAGE_JPEG_VALUE);
      response.setContentLength(data.length);
      try (ServletOutputStream outputStream = response.getOutputStream()) {
        FileCopyUtils.copy(data, outputStream);
      } catch (IOException e) {
      }
    }
  }

  @GetMapping("/superCategoryInfo/{id}/image")
  public void getSuperCategoryImage(HttpServletResponse response, @PathVariable int id) {
    byte[] data = superCategoryService.findById(id).getImage();
    if (data != null) {
      response.setContentType(MediaType.IMAGE_JPEG_VALUE);
      response.setContentLength(data.length);
      try (ServletOutputStream outputStream = response.getOutputStream()) {
        FileCopyUtils.copy(data, outputStream);
      } catch (IOException e) {
      }
    }
  }

  @GetMapping("/categoryInfo/{id}/image")
  public void getCategoryImage(HttpServletResponse response, @PathVariable int id) {
    byte[] data = categoryService.findById(id).getImage();
    if (data != null) {
      response.setContentType(MediaType.IMAGE_JPEG_VALUE);
      response.setContentLength(data.length);
      try (ServletOutputStream outputStream = response.getOutputStream()) {
        FileCopyUtils.copy(data, outputStream);
      } catch (IOException e) {
      }
    }
  }

  @GetMapping("/bannerInfo/{id}/image")
  public void getBannerImage(HttpServletResponse response, @PathVariable int id) {
    byte[] data = bannerService.findById(id).getImage();
    if (data != null) {
      response.setContentType(MediaType.IMAGE_JPEG_VALUE);
      response.setContentLength(data.length);
      try (ServletOutputStream outputStream = response.getOutputStream()) {
        FileCopyUtils.copy(data, outputStream);
      } catch (IOException e) {
      }
    }
  }

  @MessageMapping("/newOrderNotification")
  @SendTo("/adminNotification")
  public Notification greeting(OrderMessage orderMessage) {
    return new Notification(orderMessage.getMessage());
  }
}
