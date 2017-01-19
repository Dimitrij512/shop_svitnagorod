package com.shop.svitnagorod.service;

import java.util.List;

import com.shop.svitnagorod.model.Category;

public interface CategoryService {
  void save(Category category);

  List<Category> findAllCategory();
}
