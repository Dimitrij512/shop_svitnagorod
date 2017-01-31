package com.shop.svitnagorod.service;

import java.util.List;

import com.shop.svitnagorod.DTO.CategoryDTO;
import com.shop.svitnagorod.model.Category;

public interface CategoryService {

  void save(CategoryDTO categoryDTO);

  void delete(int id);

  List<Category> findAllCategory();

  Category findById(int id);
}
