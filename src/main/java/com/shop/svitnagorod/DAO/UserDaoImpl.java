package com.shop.svitnagorod.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.shop.svitnagorod.model.User;

@Repository
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

  @Override
  public void save(User user) {
    System.out.println("Persist dao save before");
    persist(user);
  }

  @Override
  public User findById(Integer id) {
    return getById(id);
  }

  @Override
  public User findByLogin(String login) {
    Criteria crit = createEntityCriteria();
    crit.add(Restrictions.eq("login", login));
    User user = (User) crit.uniqueResult();
    return user;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<User> findAllUsers() {
    Criteria crit = createEntityCriteria();
    crit.addOrder(Order.desc("id"));
    return (List<User>) crit.list();
  }

  @Override
  public void delete(int id) {
    Criteria crit = createEntityCriteria();
    crit.add(Restrictions.eq("id", id));
    User user = (User) crit.uniqueResult();
    delete(user);
  }

}
