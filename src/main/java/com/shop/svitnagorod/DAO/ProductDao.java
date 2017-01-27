package com.shop.svitnagorod.DAO;

import java.util.List;

import com.shop.svitnagorod.model.Product;

public interface ProductDao {
  void save(Product product);

  void delete(int id);

  List<Product> findAllProducts();

  Product findById(int id);
}
