/**
 * @{#} CatalogDao.java Create on 2008-6-4 下午03:21:31
 *
 * Copyright (c) 2006- by CE.
 */
package cn.ceopen.sample.petstore.dao;

import java.io.Serializable;
import java.util.List;

import cn.ceopen.sample.petstore.model.Category;

/**
 * Catalog DAO 接口.
 * <p>
 * 该DAO包含Category相关的数据访问逻辑
 * 
 * 
 * @version 1.0
 * @since JDK1.5
 */
public interface CatalogDao {

	
	public List<Category> getCategoryList();
	public void saveCategory(Category category);
	public void deleteCategoryById(String categoryId);
	public void deleteCategoryByIds(Serializable[] ids);
	public void saveOrUpdate(Category category);
	public Category getCategory(String categoryId);
}
