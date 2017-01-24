package com.shop.svitnagorod.controller;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shop.svitnagorod.DTO.UserDTO;
import com.shop.svitnagorod.service.UserService;

@Controller
@RequestMapping("/")
public class GuestController {

  private static final String REGISTRATION = "registration";
  private BCryptPasswordEncoder cryptor = new BCryptPasswordEncoder();

  // @Autowired
  // UserValidator userValidator;

  @Autowired
  UserService userService;

  // @InitBinder
  // public void initBinder(WebDataBinder binder) {
  // binder.addValidators(userValidator);
  // }

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
    model.addAttribute(REGISTRATION, new UserDTO());
    return "createUpdateRegistration";
  }

  @RequestMapping(value = { "/registration" }, method = RequestMethod.POST)
  public String createUser(@ModelAttribute(REGISTRATION) UserDTO userDTO, Model model) {
    // if (bindingResult.hasErrors()) {
    // model.addAttribute(REGISTRATION, userDTO);
    // return "createUpdateRegistration";
    // }
    System.out.println("controller");
    String userPassword = userDTO.getPassword();
    userDTO.setPassword(cryptor.encode(userPassword));
    System.out.println("befor service");
    userService.save(userDTO);
    return "redirect:/registration?registrationSuccess=true";
  }

  @RequestMapping(value = { "/users/{id}/avatar" }, method = RequestMethod.GET)
  public void getUserAvatar(HttpServletResponse response, @PathVariable int id) {
    System.out.println("ID user" + id);
    System.out.println("--------------------------------");
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

}
