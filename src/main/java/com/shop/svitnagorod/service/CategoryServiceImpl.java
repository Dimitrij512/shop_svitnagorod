package com.shop.svitnagorod.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.svitnagorod.DAO.CategoryDao;
import com.shop.svitnagorod.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService {
  @Autowired
  CategoryDao dao;

  @Transactional
  @Override
  public void save(Category category) {
    dao.save(category);
  }

  @Transactional
  @Override
  public List<Category> findAllCategory() {
    return dao.findAllCategories();
  }

}
