package com.shop.svitnagorod.service;

import java.util.List;

import com.shop.svitnagorod.DTO.SuperCategoryDTO;
import com.shop.svitnagorod.model.SuperCategory;

public interface SuperCategoryService {

	void save(SuperCategoryDTO categoryDTO);

	void update(SuperCategoryDTO categoryDTO);

	void delete(int id);

	List<SuperCategory> findAllCategory();

	SuperCategory findById(int id);

}
