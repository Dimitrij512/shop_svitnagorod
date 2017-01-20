package com.shop.svitnagorod.DAO;

import java.util.List;

import com.shop.svitnagorod.model.User;

public interface UserDao {

  void save(User user);

  void delete(int id);

  User findById(Integer id);

  User findByLogin(String login);

  List<User> findAllUsers();
}
