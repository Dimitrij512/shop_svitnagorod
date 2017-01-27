package com.shop.svitnagorod.service;

import java.util.List;

import com.shop.svitnagorod.DTO.ProductDTO;
import com.shop.svitnagorod.model.Product;

public interface ProductService {

  void save(ProductDTO productDTO);

  void delete(int id);

  List<Product> findAllProducts();

  Product findById(int id);

}
