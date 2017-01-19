package com.shop.svitnagorod.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements Serializable {

  private static final long serialVersionUID = -846256523776995760L;

  private long id;
  private String name;
  private String description;
  private float price;
  private Category category;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @ManyToOne
  @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
  public Category geCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  @Column(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Column(name = "description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Column(name = "price")
  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }
}
