package com.shop.svitnagorod.DAO;

import org.springframework.stereotype.Repository;

import com.shop.svitnagorod.model.Category;

@Repository
public class CategoryDaoImpl extends AbstractDao<Integer, Category> implements CategoryDao {

  @Override
  public void save(Category category) {
    System.out.println("Dao save");
    persist(category);
    System.out.println("After dao save");
  }

}
