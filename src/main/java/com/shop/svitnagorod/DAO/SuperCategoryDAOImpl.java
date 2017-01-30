package com.shop.svitnagorod.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.shop.svitnagorod.model.SuperCategory;

@Repository
public class SuperCategoryDAOImpl extends AbstractDao<Integer, SuperCategory> implements SuperCategoryDAO {

  @Override
  public void save(SuperCategory superCategory) {
    persist(superCategory);
  }

  @Override
  public void delete(int id) {
    Criteria crit = createEntityCriteria();
    crit.add(Restrictions.eq("id", id));
    SuperCategory superCategory = (SuperCategory) crit.uniqueResult();
    delete(superCategory);

  }

  @Override
  public SuperCategory findById(Integer id) {
    return getById(id);
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<SuperCategory> findAll() {
    Criteria crit = createEntityCriteria();
    crit.addOrder(Order.desc("id"));
    return (List<SuperCategory>) crit.list();
  }

}
