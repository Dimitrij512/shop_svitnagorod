package com.shop.svitnagorod.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.shop.svitnagorod.model.Orders;

@Repository
public class OrdersDaoImpl extends AbstractDao<Integer, Orders> implements OrdersDao {

  @Override
  public void save(Orders order) {
    persist(order);
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Orders> findAllOrders() {
    Criteria crit = createEntityCriteria();
    crit.addOrder(Order.desc("id"));
    List<Orders> ordersList = (List<Orders>) crit.list();
    for (Orders order : ordersList) {
      Hibernate.initialize(order.getOrderDetails());
    }
    return ordersList;
  }

  @Override
  public Orders findById(int id) {
    Orders order = getById(id);
    if (order != null) {
      Hibernate.initialize(order.getOrderDetails());
    }
    return order;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Orders> findByUserId(int userId) {
    Criteria crit = createEntityCriteria();
    crit.add(Restrictions.eq("user_id", userId));
    List<Orders> ordersList = (List<Orders>) crit.list();
    for (Orders order : ordersList) {
      Hibernate.initialize(order.getOrderDetails());
    }
    return ordersList;
  }
}
