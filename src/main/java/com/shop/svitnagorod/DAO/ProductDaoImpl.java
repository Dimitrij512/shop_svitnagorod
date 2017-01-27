package com.shop.svitnagorod.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.shop.svitnagorod.model.Product;

@Repository
public class ProductDaoImpl extends AbstractDao<Integer, Product>
    implements ProductDao {

	@Override
	public void save(Product product) {
		persist(product);
	}

	@Override
	public void delete(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		Product product = (Product) crit.uniqueResult();
		delete(product);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAllProducts() {
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.desc("id"));
		return (List<Product>) crit.list();
	}

}
