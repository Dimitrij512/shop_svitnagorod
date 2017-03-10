package com.shop.svitnagorod.service;

import java.util.List;

import com.shop.svitnagorod.DTO.BannerDTO;
import com.shop.svitnagorod.model.Banner;

public interface BannerService {

  void save(BannerDTO bannerDTO);

  void delete(int id);

  Banner findById(Integer id);

  List<Banner> findAll();

  List<Banner> findEnabled();

}
