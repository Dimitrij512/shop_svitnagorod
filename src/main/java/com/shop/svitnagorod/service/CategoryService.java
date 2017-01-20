package com.shop.svitnagorod.service;

import java.util.List;

import com.shop.svitnagorod.model.Category;

public interface CategoryService {

  void save(Category category);

  void delete(int id);

  List<Category> findAllCategory();
}
