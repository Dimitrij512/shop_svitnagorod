package com.shop.svitnagorod.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.shop.svitnagorod.DAO.ProductDao;
import com.shop.svitnagorod.DTO.ProductDTO;
import com.shop.svitnagorod.model.Product;

@Service
public class ProductSrviceImpl implements ProductService {
  @Autowired
  ProductDao dao;
  @Autowired
  GeneralService genService;

  @Transactional
  @Override
  public void save(ProductDTO productDTO) {
    Product product = new Product();
    product.setId(productDTO.getId());
    product.setName(productDTO.getName());
    product.setDescription(productDTO.getDescription());
    product.setPrice(productDTO.getPrice());
    product.setCategory_id(productDTO.getCategory_id());
    MultipartFile image = productDTO.getImage();
    try {
      if (image.isEmpty()) {
        product.setImage(genService.getDefoultImageProduct());
      } else {
        product.setImage(image.getBytes());
      }
      dao.save(product);
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
  public List<Product> findAllProducts() {
    return dao.findAllProducts();
  }

  @Transactional
  @Override
  public Product findById(int id) {
    return dao.findById(id);
  }

  @Transactional
  @Override
  public List<Product> findProductsByCategoryID(int id) {

    return dao.findProductsByCategoryID(id);
  }

}
