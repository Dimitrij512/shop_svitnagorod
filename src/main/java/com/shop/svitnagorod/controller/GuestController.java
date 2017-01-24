package com.shop.svitnagorod.controller;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
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
  private static final String USERDATA = "userData";

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

  @RequestMapping(value = { "/usersInfo/{name}/avatar" }, method = RequestMethod.GET)
  public void getUserAvatarByLogin(HttpServletResponse response, @PathVariable String name) {

    System.out.println("Name : " + name);
    byte[] data = userService.findByLogin(name).getAvatar();
    InputStream image = null;
    if (data != null) {
      image = new ByteArrayInputStream(userService.findByLogin(name).getAvatar());
    }
    byte[] avatar = null;

    try {

      BufferedImage img = null;
      Image scaledImage = null;
      BufferedImage imageBuff = null;
      ByteArrayOutputStream buffer = null;

      if (data != null) {
        img = ImageIO.read(image);
        scaledImage = img.getScaledInstance(45, 50, Image.SCALE_SMOOTH);
        imageBuff = new BufferedImage(45, 50, BufferedImage.TYPE_INT_RGB);
        imageBuff.getGraphics().drawImage(scaledImage, 0, 0, new Color(0, 0, 0), null);
        buffer = new ByteArrayOutputStream();
        ImageIO.write(imageBuff, "jpg", buffer);
        avatar = buffer.toByteArray();
      }

    } catch (IOException e1) {

      e1.printStackTrace();
    }

    if (avatar != null) {
      response.setContentType(MediaType.IMAGE_JPEG_VALUE);
      response.setContentLength(avatar.length);
      try (ServletOutputStream outputStream = response.getOutputStream()) {
        FileCopyUtils.copy(avatar, outputStream);
      } catch (IOException e) {
      }
    }
  }

}
