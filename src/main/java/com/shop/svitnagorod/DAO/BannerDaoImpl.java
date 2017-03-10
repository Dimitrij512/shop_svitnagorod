package com.shop.svitnagorod.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.shop.svitnagorod.model.Banner;

@Repository
public class BannerDaoImpl extends AbstractDao<Integer, Banner> implements BannerDao {

  @Override
  public void save(Banner banner) {
    persist(banner);
  }

  @Override
  public void delete(int id) {
    Criteria crit = createEntityCriteria();
    crit.add(Restrictions.eq("id", id));
    Banner banner = (Banner) crit.uniqueResult();
    delete(banner);
  }

  @Override
  public Banner findById(Integer id) {
    return getById(id);
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Banner> findAll() {
    Criteria crit = createEntityCriteria();
    crit.addOrder(Order.desc("id"));
    return (List<Banner>) crit.list();
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<Banner> findEnabled() {
    Criteria crit = createEntityCriteria();
    crit.add(Restrictions.eq("enable", true));
    return (List<Banner>) crit.list();
  }

}
