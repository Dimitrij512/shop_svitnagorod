package com.shop.svitnagorod.service;

import com.shop.svitnagorod.model.User;

public interface UserService {

  void save(User user);

  User findById(int id);

  User findByLogin(String login);

  boolean isUserUnique(String login, Integer id);

}
