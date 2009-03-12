/**
 * @{#} ProductDaoHibernateImpl.java Create on 2008-6-4 下午03:21:31
 *
 * Copyright (c) 2006- by CE.
 */
package cn.ceopen.sample.petstore.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.ceopen.sample.petstore.dao.ProductDao;
import cn.ceopen.sample.petstore.model.Product;

import com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao;
import com.sitechasia.webx.core.dao.hibernate3.CommonHibernateDao;
import com.sitechasia.webx.core.dao.jdbc.CommonJdbcDao;


/**
 * Product DAO 接口实现类.
 * 
 * @see ProductDao
 * 
 * @version 1.0
 * @since JDK1.5
 */
public class ProductDaoHibernateImpl extends BaseHibernateDomainDao<Product>
		implements ProductDao {

	CommonHibernateDao commonHibernateDao;
	CommonJdbcDao commonJdbcDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see mypetstore.dao.ProductDao#searchProductList(java.util.List)
	 */
	public List searchProductList(final String keyword) {
		List list = new ArrayList();
		if (keyword != null && !keyword.isEmpty()) {

			StringBuffer sb = new StringBuffer(100);
			sb.append("select distinct * ");
			sb.append("from Product product ");
			sb.append("where ");

				sb.append("product.name like ");
				sb.append("'%").append(keyword).append("%' ");
				sb.append("OR ");
			
				sb.append("product.CATEGORY like ");
				sb.append("'%").append(keyword).append("%' ");
				sb.append("OR ");
			
				sb.append("product.DESCN like ");
				sb.append("'%").append(keyword).append("%' ");
				
				sb.append(" order by product.productId");
			list = commonJdbcDao.listBySql(sb.toString());
			//list=commonHibernateDao.listByHql(sb.toString(),0,0);
		}

		return list;
	}

	/**
	 * 
	 * 注册 CommonHibernateDao
	 * 
	 * @param commonHibernateDao
	 */
	public void setCommonHibernateDao(CommonHibernateDao commonHibernateDao) {
		this.commonHibernateDao = commonHibernateDao;
	}

	/**
	 * 
	 * 注册 CommonJdbcDao
	 * 
	 * @param commonJdbcDao
	 */
	public void setCommonJdbcDao(CommonJdbcDao commonJdbcDao) {
		this.commonJdbcDao = commonJdbcDao;
	}

}
