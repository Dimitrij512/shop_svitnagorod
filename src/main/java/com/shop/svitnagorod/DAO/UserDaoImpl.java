package com.shop.svitnagorod.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.shop.svitnagorod.model.Users;

@Repository
public class UserDaoImpl extends AbstractDao<Integer, Users> implements UserDao {

	@Override
	public void save(Users user) {
		persist(user);
	}

	@Override
	public Users findById(Integer id) {
		return getById(id);
	}

	@Override
	public Users findByLogin(String login) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("login", login));
		Users user = (Users) crit.uniqueResult();
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> findAllUsers() {
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.desc("id"));
		return (List<Users>) crit.list();
	}

	@Override
	public void delete(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		Users user = (Users) crit.uniqueResult();
		delete(user);
	}

}
