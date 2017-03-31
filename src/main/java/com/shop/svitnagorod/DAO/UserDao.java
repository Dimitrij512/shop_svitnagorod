package com.shop.svitnagorod.DAO;

import java.util.List;

import com.shop.svitnagorod.model.Users;

public interface UserDao {

  void save(Users user);

  void delete(int id);

  Users findById(Integer id);

  Users findByLogin(String login);

  List<Users> findAllUsers();
}
