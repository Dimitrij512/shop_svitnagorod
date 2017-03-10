package com.shop.svitnagorod.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.shop.svitnagorod.DAO.BannerDao;
import com.shop.svitnagorod.DTO.BannerDTO;
import com.shop.svitnagorod.model.Banner;

@Service
public class BannerServiceImpl implements BannerService {
  @Autowired
  BannerDao dao;

  @Transactional
  @Override
  public void save(BannerDTO bannerDTO) {
    Banner banner = new Banner();

    banner.setId(bannerDTO.getId());
    banner.setTitle(bannerDTO.getTitle());
    banner.setSubtitle(bannerDTO.getSubtitle());
    banner.setEnable(true);
    MultipartFile image = bannerDTO.getImage();
    try {
      banner.setImage(image.getBytes());

    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      dao.save(banner);
    } catch (DataAccessException dae) {
      System.out.println(dae);
      throw dae;
    }

  }

  @Transactional
  @Override
  public void delete(int id) {
    dao.delete(id);
  }

  @Transactional
  @Override
  public Banner findById(Integer id) {

    return dao.findById(id);
  }

  @Transactional
  @Override
  public List<Banner> findAll() {
    return dao.findAll();
  }

  @Transactional
  @Override
  public List<Banner> findEnabled() {
    return dao.findEnabled();
  }

}
