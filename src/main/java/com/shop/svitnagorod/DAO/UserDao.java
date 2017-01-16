package com.shop.svitnagorod.DAO;

import com.shop.svitnagorod.model.User;

public interface UserDao {

  void save(User user);

  User findById(Integer id);

  User findByLogin(String login);
}
