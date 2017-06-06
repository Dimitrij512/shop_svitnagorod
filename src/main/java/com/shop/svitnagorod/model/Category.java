package com.shop.svitnagorod.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
public class Category implements Serializable {

	private static final long serialVersionUID = 1788778762096872138L;

	private int id;
	private String name;
	private SuperCategory superCategory;
	private Set<Product> products;
	private byte[] image;
	//private int super_category_id;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//	@OneToMany
	//	@JoinColumn(name = "category_id")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.REMOVE)
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "super_category_id", nullable = false)
	public SuperCategory getSuperCategory() {
		return superCategory;
	}

	public void setSuperCategory(SuperCategory superCategory) {
		this.superCategory = superCategory;
	}
	//	@Column(name = "super_category_id")
	//	public int getSuper_category_id() {
	//		return super_category_id;
	//	}
	//
	//	public void setSuper_category_id(int super_category_id) {
	//		this.super_category_id = super_category_id;
	//	}

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
