/**
 * @{#} Category.java Create on 2008-6-4 下午03:21:31
 *
 * Copyright (c) 2006- by CE.
 */
package cn.ceopen.sample.petstore.model;

import java.util.HashSet;
import java.util.Set;

import com.sitechasia.webx.core.model.IDomainObject;

/**
 * Category domain object.
 * 
 * 
 * @version 1.0
 * @since JDK1.5
 */
public class Category implements IDomainObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String categoryId;
	private String categoryName;
	private String categoryDes;
	private Set<Product> products = new HashSet<Product>();  

	public Category() {
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String newCategoryId) {
		this.categoryId = newCategoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDes() {
		return categoryDes;
	}

	public void setCategoryDes(String categoryDes) {
		this.categoryDes = categoryDes;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
