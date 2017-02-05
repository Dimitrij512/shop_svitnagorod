package com.shop.svitnagorod.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.shop.svitnagorod.model.Category;
import com.shop.svitnagorod.model.SuperCategory;

@Repository
public class SuperCategoryDAOImpl extends AbstractDao<Integer, SuperCategory>
    implements SuperCategoryDAO {

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
		SuperCategory supCat = getById(id);
		if (supCat != null) {
			Hibernate.initialize(supCat.getCategories());
			List<Category> listCategories = supCat.getCategories();
			for (Category cat : listCategories) {
				Hibernate.initialize(cat.getProducts());
			}
		}
		return supCat;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SuperCategory> findAll() {
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.desc("id"));
		List<SuperCategory> listSuperCategory = (List<SuperCategory>) crit.list();
		for (SuperCategory supCat : listSuperCategory) {

			Hibernate.initialize(supCat.getCategories());
			List<Category> listCategry = supCat.getCategories();
			for (Category cat : listCategry) {
				Hibernate.initialize(cat.getProducts());
			}
		}

		return listSuperCategory;
	}

}
