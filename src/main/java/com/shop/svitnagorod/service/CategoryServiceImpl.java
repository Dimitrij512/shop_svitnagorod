package com.shop.svitnagorod.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.svitnagorod.DAO.CategoryDao;
import com.shop.svitnagorod.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService {
  @Autowired
  CategoryDao dao;

  @Override
  public void save(Category category) {
    System.out.println("Service save");
    dao.save(category);
  }

}
