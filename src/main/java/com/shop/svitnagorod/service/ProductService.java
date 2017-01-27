package com.shop.svitnagorod.service;

import java.util.List;

import com.shop.svitnagorod.model.Product;

public interface ProductService {

	void save(Product product);

	void delete(int id);

	List<Product> findAllProducts();

}
