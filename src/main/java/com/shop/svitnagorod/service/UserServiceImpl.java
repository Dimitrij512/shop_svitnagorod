package com.shop.svitnagorod.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.shop.svitnagorod.DAO.UserDao;
import com.shop.svitnagorod.DTO.UserDTO;
import com.shop.svitnagorod.model.User;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  UserDao dao;

  @Transactional
  @Override
  public void save(UserDTO userDTO) {
    User user = new User();
    user.setId(userDTO.getId());
    user.setSurname(userDTO.getSurname());
    user.setName(userDTO.getName());
    user.setLogin(userDTO.getLogin());
    user.setPassword(userDTO.getPassword());
    user.setRole(userDTO.getRole());
    MultipartFile avatar = userDTO.getAvatar();
    try {
      user.setAvatar(avatar.getBytes());
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    try {

      // user.setAvatar(avatar.getBytes());
      System.out.println("before Save");
      dao.save(user);

    } catch (DataAccessException dae) {

      System.out.println(dae);

    }
  }

  @Transactional
  @Override
  public User findById(int id) {
    return dao.findById(id);
  }

  @Transactional
  @Override
  public User findByLogin(String login) {

    return dao.findByLogin(login);
  }

  @Transactional
  @Override
  public boolean isUserUnique(String login, Integer id) {
    User user = null;
    user = findByLogin(login);
    return (user == null || ((id != null) && (user.getId() == id)));
  }

  @Transactional
  @Override
  public List<User> findAllUser() {

    return dao.findAllUsers();
  }

  @Transactional
  @Override
  public void delete(int id) {
    dao.delete(id);

  }

}
