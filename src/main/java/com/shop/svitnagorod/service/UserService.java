package com.shop.svitnagorod.service;

import java.util.List;

import com.shop.svitnagorod.DTO.UserDTO;
import com.shop.svitnagorod.model.User;

public interface UserService {

  void save(UserDTO userDTO);

  void delete(int id);

  User findById(int id);

  User findByLogin(String login);

  boolean isUserUnique(String login, Integer id);

  List<User> findAllUser();

}
