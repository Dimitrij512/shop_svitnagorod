package com.shop.svitnagorod.service;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class GeneralSerivceImpl implements GeneralService {

  @Autowired
  ServletContext context;

  @Override
  public String getPrincipal() {
    String userName = null;
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    if (principal instanceof UserDetails) {
      userName = ((UserDetails) principal).getUsername();
    } else {
      userName = principal.toString();
    }
    return userName;
  }

  @Override
  public byte[] resizeImage(byte[] data, int width, int height) {
    byte[] imageByte = null;

    if (data == null) {
      data = getDefoultImageUser();
    }

    try (InputStream image = new ByteArrayInputStream(data);
        ByteArrayOutputStream buffer = new ByteArrayOutputStream()) {
      BufferedImage img = ImageIO.read(image);
      BufferedImage imageBuff = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
      Image scaledImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
      imageBuff.getGraphics().drawImage(scaledImage, 0, 0, new Color(0, 0, 0), null);
      ImageIO.write(imageBuff, "jpg", buffer);
      imageByte = buffer.toByteArray();

    } catch (IOException e1) {
      e1.printStackTrace();
    }
    return imageByte;
  }

  public byte[] getDefoultImageUser() {
    String defoultImage = context.getRealPath("/static/img/defoultUser.jpg");
    byte data[] = null;
    try {
      BufferedImage defoultUser = ImageIO.read(new File(defoultImage));
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      ImageIO.write(defoultUser, "jpg", baos);
      baos.flush();
      data = baos.toByteArray();
      baos.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return data;
  }
}
