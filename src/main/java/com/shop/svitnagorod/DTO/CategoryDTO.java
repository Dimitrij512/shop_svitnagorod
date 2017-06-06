package com.shop.svitnagorod.DTO;

import java.io.Serializable;
import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.web.multipart.MultipartFile;

import com.shop.svitnagorod.model.Product;
import com.shop.svitnagorod.model.SuperCategory;

public class CategoryDTO implements Serializable {
	private static final long serialVersionUID = 1788778762096872138L;

	private int id;
	private String name;
	private Set<Product> products;
	private SuperCategory superCategory;
	//private int super_category_id;
	private MultipartFile image;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SuperCategory getSuperCategory() {
		return superCategory;
	}

	public void setSuperCategory(SuperCategory superCategory) {
		this.superCategory = superCategory;
	}

	//  public int getSuper_category_id() {
	//    return super_category_id;
	//  }
	//
	//  public void setSuper_category_id(int super_category_id) {
	//    this.super_category_id = super_category_id;
	//  }

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, true);

	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, true);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
