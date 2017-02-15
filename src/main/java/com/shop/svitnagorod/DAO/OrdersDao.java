package com.shop.svitnagorod.DAO;

import java.util.List;

import com.shop.svitnagorod.model.Orders;

public interface OrdersDao {

  void save(Orders order);

  List<Orders> findAllOrders();

  Orders findById(int id);

  List<Orders> findByUserId(int userId);

}
