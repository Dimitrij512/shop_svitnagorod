package com.shop.svitnagorod.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.svitnagorod.DAO.UserDao;
import com.shop.svitnagorod.model.User;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  UserDao dao;

  @Transactional
  @Override
  public void save(User user) {
    try {
      dao.save(user);
    } catch (DataAccessException dae) {
      System.out.println(dae);
      throw dae;
    }
  }

}
