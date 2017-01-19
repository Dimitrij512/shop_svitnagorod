package com.shop.svitnagorod.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.shop.svitnagorod.model.Category;

@Repository
public class CategoryDaoImpl extends AbstractDao<Integer, Category> implements CategoryDao {

  @Override
  public void save(Category category) {
    persist(category);
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Category> findAllCategories() {
    Criteria crit = createEntityCriteria();
    crit.addOrder(Order.desc("id"));
    return (List<Category>) crit.list();
  }

}
