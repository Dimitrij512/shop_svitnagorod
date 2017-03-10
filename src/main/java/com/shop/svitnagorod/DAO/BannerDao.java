package com.shop.svitnagorod.DAO;

import java.util.List;

import com.shop.svitnagorod.model.Banner;

public interface BannerDao {

  void save(Banner banner);

  void delete(int id);

  Banner findById(Integer id);

  List<Banner> findAll();

  List<Banner> findEnabled();

}
