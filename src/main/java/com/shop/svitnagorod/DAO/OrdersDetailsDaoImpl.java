package com.shop.svitnagorod.DAO;

import org.springframework.stereotype.Repository;

import com.shop.svitnagorod.model.OrderDetails;

@Repository
public class OrdersDetailsDaoImpl extends AbstractDao<Integer, OrderDetails> implements OrdersDetailsDao {

  @Override
  public void save(OrderDetails orderDetails) {
    persist(orderDetails);
  }

}
