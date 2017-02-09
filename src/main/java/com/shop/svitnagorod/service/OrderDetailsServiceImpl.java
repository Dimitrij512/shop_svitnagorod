package com.shop.svitnagorod.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.svitnagorod.DAO.OrdersDetailsDao;
import com.shop.svitnagorod.model.OrderDetails;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {
  @Autowired
  OrdersDetailsDao dao;

  @Transactional
  @Override
  public void save(OrderDetails orderDetails) {
    dao.save(orderDetails);
  }

}
