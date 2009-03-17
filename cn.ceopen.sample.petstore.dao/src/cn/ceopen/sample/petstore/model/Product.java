/**
 * @{#} Product.java Create on 2008-6-4 下午03:21:31
 *
 * Copyright (c) 2006- by CE.
 */
package cn.ceopen.sample.petstore.model;

import com.sitechasia.webx.core.model.IDomainObject;

/**
 * Product domain object.
 *
 * 
 * @version 1.0
 * @since JDK1.5
 */
@SuppressWarnings("serial")
public class Product implements IDomainObject{

	private String productId;
	private Category category;
	private String name;
	private String descriptionWithImage;
	private String description;
	private String image;

	public Product() {
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String newProductId) {
		this.productId = newProductId;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public String getDescriptionWithImage() {
		return this.descriptionWithImage;
	}

	public void setDescriptionWithImage(String newDespWithImage) {
		this.parseDescription(newDespWithImage);
	}

	public String getDescription() {
		return description;
	}

	public String getImage() {
		return this.image;
	}

	/**
	 *
	 * 填充商品描述
	 *
	 * @param desp
	 *            商品描述
	 */
	private void parseDescription(String desp) {
		if (desp != null && desp.indexOf(">") > 0) {
			this.image = desp.substring(0, desp.indexOf(">"));
			this.description = desp.substring(desp.indexOf(">") + 1);
		} else {
			this.description = desp;
		}
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
