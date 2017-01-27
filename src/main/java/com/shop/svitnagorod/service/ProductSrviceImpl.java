package com.shop.svitnagorod.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.svitnagorod.DAO.ProductDao;
import com.shop.svitnagorod.model.Product;

@Service
public class ProductSrviceImpl implements ProductService {
	@Autowired
	ProductDao dao;

	@Transactional
	@Override
	public void save(Product product) {
		dao.save(product);

	}

	@Transactional
	@Override
	public void delete(int id) {
		dao.delete(id);

	}

	@Transactional
	@Override
	public List<Product> findAllProducts() {
		return dao.findAllProducts();
	}

}
