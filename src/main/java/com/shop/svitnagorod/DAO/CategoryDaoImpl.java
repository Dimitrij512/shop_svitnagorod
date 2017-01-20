package com.shop.svitnagorod.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.shop.svitnagorod.model.Category;

@Repository
public class CategoryDaoImpl extends AbstractDao<Integer, Category> implements CategoryDao {

  @Override
  public void save(Category category) {
    persist(category);
  }

  @Override
  public void delete(int id) {
    Criteria crit = createEntityCriteria();
    crit.add(Restrictions.eq("id", id));
    Category category = (Category) crit.uniqueResult();
    System.out.println("NAME " + category.getName());
    delete(category);

  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Category> findAllCategories() {
    Criteria crit = createEntityCriteria();
    crit.addOrder(Order.desc("id"));
    return (List<Category>) crit.list();
  }

}
