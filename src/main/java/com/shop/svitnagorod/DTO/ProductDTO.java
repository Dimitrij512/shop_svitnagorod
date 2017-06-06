package com.shop.svitnagorod.DTO;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.web.multipart.MultipartFile;

import com.shop.svitnagorod.model.Category;

public class ProductDTO implements Serializable {

	private static final long serialVersionUID = -846256523776995760L;

	private int id;
	private String name;
	private String description;
	private float price;
	private Category category;
	//private int category_id;
	private MultipartFile image;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	//  public int getCategory_id() {
	//    return category_id;
	//  }
	//
	//  public void setCategory_id(int category_id) {
	//    this.category_id = category_id;
	//  }

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
