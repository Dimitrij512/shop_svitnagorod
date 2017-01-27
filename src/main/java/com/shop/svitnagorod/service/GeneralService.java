package com.shop.svitnagorod.service;

public interface GeneralService {
  String getPrincipal();

  byte[] resizeImage(byte[] data, int width, int height);

  byte[] getDefoultImageUser();

  byte[] getDefoultImageProduct();

}
