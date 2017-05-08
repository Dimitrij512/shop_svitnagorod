package com.shop.svitnagorod.service;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.shop.svitnagorod.DAO.SuperCategoryDAO;
import com.shop.svitnagorod.DTO.SuperCategoryDTO;
import com.shop.svitnagorod.model.SuperCategory;

@Service
public class SuperCategoryServiceImpl implements SuperCategoryService {
	Logger LOGGER = Logger.getLogger(SuperCategoryServiceImpl.class);

	@Autowired
	GeneralService genService;
	@Autowired
	SuperCategoryDAO dao;

	@Transactional
	@Override
	public void save(SuperCategoryDTO superCategoryDTO) {
		SuperCategory superCategory = new SuperCategory();
		superCategory.setId(superCategoryDTO.getId());
		superCategory.setName(superCategoryDTO.getName());
		MultipartFile image = superCategoryDTO.getImage();
		try {
			if (image.isEmpty()) {
				superCategory.setImage(genService.getDefoultImageProduct());
			} else {
				superCategory.setImage(image.getBytes());
			}
			dao.save(superCategory);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Transactional
	@Override
	public void update(SuperCategoryDTO superCategoryDTO) {
		SuperCategory entity = null;

		try {

			entity = dao.findById(superCategoryDTO.getId());

		} catch (DataAccessException dae) {
			LOGGER.error("Unable to get superCategory with id : " + entity.getId(), dae);
			throw dae;
		}
		entity.setName(superCategoryDTO.getName());
		MultipartFile image = superCategoryDTO.getImage();
		try {
			if (!image.isEmpty()) {
				entity.setImage(image.getBytes());
				//entityentity.setImage(genService.getDefoultImageProduct());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Transactional
	@Override
	public void delete(int id) {
		dao.delete(id);

	}

	@Transactional
	@Override
	public List<SuperCategory> findAllCategory() {
		return dao.findAll();
	}

	@Transactional
	@Override
	public SuperCategory findById(int id) {
		return dao.findById(id);
	}

}
