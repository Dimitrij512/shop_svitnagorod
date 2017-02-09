package com.shop.svitnagorod.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.svitnagorod.DAO.OrdersDao;
import com.shop.svitnagorod.model.Orders;

@Service
public class OrdersServiceImpl implements OrdersService {
  @Autowired
  OrdersDao dao;

  @Transactional
  @Override
  public void save(Orders order) {
    dao.save(order);
  }

  @Transactional
  @Override
  public List<Orders> findAll() {
    return dao.findAllOrders();
  }

  @Transactional
  @Override
  public Orders findById(int id) {
    return dao.findById(id);
  }

}
