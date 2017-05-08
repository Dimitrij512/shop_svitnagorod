package com.shop.svitnagorod.DAO;

import java.util.List;

import com.shop.svitnagorod.model.SuperCategory;

public interface SuperCategoryDAO {

	void save(SuperCategory superCategory);

	void delete(int id);

	SuperCategory findById(Integer id);

	List<SuperCategory> findAll();

}
