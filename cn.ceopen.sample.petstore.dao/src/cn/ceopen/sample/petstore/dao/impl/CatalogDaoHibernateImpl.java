/**
 * @{#} CatalogDaoHibernateImpl.java Create on 2008-6-4 下午03:21:31
 *
 * Copyright (c) 2006- by CE.
 */
package cn.ceopen.sample.petstore.dao.impl;

import java.io.Serializable;
import java.util.List;

import cn.ceopen.sample.petstore.dao.CatalogDao;
import cn.ceopen.sample.petstore.model.Category;

import com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao;

/**
 * Catalog DAO 接口实现类.
 * 
 * @see CatalogDao
 * 
 * @version 1.0
 * @since JDK1.5
 */
public class CatalogDaoHibernateImpl extends BaseHibernateDomainDao<Category>
		implements CatalogDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see mypetstore.dao.CatalogDao#getCategoryList()
	 */
	public List<Category> getCategoryList() {
		System.out.println("=====categoryList.size: " + this.findAll().size());
		return this.findAll();
	}


	public void saveCategory(Category category) {
		// TODO Auto-generated method stub
		
	System.out.println(category.getCategoryDes()+"==="+category.getCategoryName()+"===dao");
		this.save(category);
	}


	public void deleteCategoryById(String categoryId) {
		// TODO Auto-generated method stub
		System.out.println(categoryId+"======from dao delete");
		this.doDeleteById(categoryId);
	}
	
	public void saveOrUpdate(Category category){
		this.getHibernateTemplate().saveOrUpdate(category);
	}


	public Category getCategory(String categoryId) {
		// TODO Auto-generated method stub
		return this.get(categoryId);
	}

	public void deleteCategoryByIds(Serializable[] ids) {
		// TODO Auto-generated method stub
		this.deleteByIds(ids);
	}


}
