package com.shop.svitnagorod.service.facebookOAuth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.svitnagorod.DAO.UserDao;
import com.shop.svitnagorod.model.User;

@Service
public class FacebookConnectionSignup implements ConnectionSignUp {

  @Autowired
  UserDao userDAO;

  @Transactional
  @Override
  public String execute(Connection<?> connection) {
    String username = connection.getDisplayName();
    User user = userDAO.findByLogin(username);

    if (user == null) {
      user = new User();
      user.setLogin(connection.getDisplayName());
      user.setName("Face");
      user.setSurname("Book");
      user.setPassword("132");
      user.setRole("CUSTOMER");
      user.setPhone("123");
      ;
    }
    return user.getLogin();
  }

}
