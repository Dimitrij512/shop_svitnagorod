package com.shop.svitnagorod.DAO;

import java.util.List;

import com.shop.svitnagorod.model.Category;

public interface CategoryDao {
  void save(Category category);

  List<Category> findAllCategories();
}
