package com.shop.svitnagorod.service;

import java.util.List;

import com.shop.svitnagorod.model.Orders;

public interface OrdersService {

  void save(Orders order);

  List<Orders> findAll();

  Orders findById(int id);

  List<Orders> findByUserId(int userId);

}
