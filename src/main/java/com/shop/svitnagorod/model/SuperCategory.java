package com.shop.svitnagorod.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

@Entity(name = "super_category")
public class SuperCategory implements Serializable {

	private static final long serialVersionUID = 7566134743107664993L;
	private int id;
	private String name;
	private List<Category> categories;
	private byte[] image;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@NotBlank(message = "Заповніть поле назви категорії")
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	//@JoinColumn(name = "super_category_id")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "superCategory", cascade = CascadeType.REMOVE)
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	@Column(name = "image")
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
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
