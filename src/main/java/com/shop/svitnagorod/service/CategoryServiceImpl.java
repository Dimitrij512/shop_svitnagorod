package com.shop.svitnagorod.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.shop.svitnagorod.DAO.CategoryDao;
import com.shop.svitnagorod.DTO.CategoryDTO;
import com.shop.svitnagorod.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryDao dao;

	@Autowired
	GeneralService genSrvice;

	@Transactional
	@Override
	public void save(CategoryDTO categoryDTO) {
		Category category = new Category();
		category.setId(categoryDTO.getId());
		category.setName(categoryDTO.getName());
		category.setProducts(categoryDTO.getProducts());
		category.setSuperCategory(categoryDTO.getSuperCategory());
		MultipartFile image = categoryDTO.getImage();
		try {
			if (image.isEmpty()) {
				category.setImage(genSrvice.getDefoultImageProduct());
			} else {
				category.setImage(image.getBytes());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		dao.save(category);
	}

	@Transactional
	@Override
	public void delete(int id) {
		dao.delete(id);
	}

	@Transactional
	@Override
	public List<Category> findAllCategory() {
		return dao.findAllCategories();
	}

	@Transactional
	@Override
	public Category findById(int id) {
		return dao.findById(id);
	}

}
