package com.shop.svitnagorod.DAO;

import org.springframework.stereotype.Repository;

import com.shop.svitnagorod.model.User;

@Repository
public class UserDaoImpl extends AbstractDao<String, User> implements UserDao {

  @Override
  public void save(User user) {
    System.out.println("UserDaoimp befor");
    persist(user);
    System.out.println("after method persist");
  }

}
