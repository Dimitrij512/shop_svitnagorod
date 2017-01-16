package com.shop.svitnagorod.DAO;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.shop.svitnagorod.model.User;

@Repository
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

  @Override
  public void save(User user) {
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

}
