package cn.ceopen.sample.petstore.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import cn.ceopen.sample.petstore.dao.CatalogDao;
import cn.ceopen.sample.petstore.dao.ProductDao;
import cn.ceopen.sample.petstore.exception.MyPetStoreException;
import cn.ceopen.sample.petstore.model.Category;
import cn.ceopen.sample.petstore.service.CatalogService;
import cn.ceopen.sample.petstore.vo.CategoryVo;
import cn.ceopen.sample.petstore.vo.ProductVo;

import com.sitechasia.webx.core.utils.dozer.DozerConvertUtil;

/**
 * Catalog Service 接口实现类.
 * 
 * @see CatalogService
 * 
 * @version 1.0
 * @since JDK1.5
 */

public class CatalogServiceImpl implements CatalogService {

	private CatalogDao catalogDao;
	private DozerConvertUtil dozerConvertUtil;
	private ProductDao productDao;
	static Logger logger = Logger.getLogger(CatalogServiceImpl.class.getName());

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	// private List mappingFiles;
	//
	// // 注册dozer mapping files
	// public void setMappingFiles(List mappingFiles) {
	// this.mappingFiles = mappingFiles;
	// }

	// 注册dozerConvertUtil
	public void setDozerConvertUtil(DozerConvertUtil dozerConvertUtil) {
		this.dozerConvertUtil = dozerConvertUtil;
	}

	public DozerConvertUtil getDozerConvertUtil() {

		// try {
		// dozerConvertUtil.setMappingFiles(this.mappingFiles);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		return dozerConvertUtil;
	}

	// 注册CatalogDao
	public void setCatalogDao(CatalogDao newCatalogDao) {
		this.catalogDao = newCatalogDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mypetstore.service.CatalogService#getCategoryList()
	 */
	public List<CategoryVo> getCategoryList() throws MyPetStoreException {
		try {
			System.out
					.println(catalogDao.getCategoryList().size() + "====size");
			return dozerConvertUtil.domainObjectsToViewObjects(catalogDao
					.getCategoryList(), CategoryVo.class);
		} catch (Exception e) {
			String msg = "Could not get category list " + e.toString();
			throw new MyPetStoreException(msg, e);
		}
	}

	public void addCategory(CategoryVo categoryVo) {
		Category c = new Category();
		dozerConvertUtil.viewObjectToDomainObject(categoryVo, c);
		catalogDao.saveCategory(c);
		logger.info("saved category from log4j");
	}

	public void deleteCategoryById(String categoryId) {
		logger.info("deleting category by id from log4j");
		this.catalogDao.deleteCategoryById(categoryId);
	}

	public void deleteCateogries(Serializable[] ids) {
		logger.info("deleting category by id from log4j");
		catalogDao.deleteCategoryByIds(ids);
	}

	public void saveOrUpdate(CategoryVo categoryVo) {
		Category c = new Category();
		dozerConvertUtil.viewObjectToDomainObject(categoryVo, c);
		catalogDao.saveOrUpdate(c);
		logger.info("updated category from log4j");
	}

	public CategoryVo getCategory(String categoryId) {
		CategoryVo categoryVo = new CategoryVo();
		Category category = this.catalogDao.getCategory(categoryId);
		dozerConvertUtil.domainObjectToViewObject(category, categoryVo);
		return categoryVo;
	}

	public List<ProductVo> searchProductList(String keywords) {
		if (keywords != null && !keywords.isEmpty()) {
			List productlist = productDao.searchProductList(keywords);
			return dozerConvertUtil.domainObjectsToViewObjects(productlist,
					ProductVo.class);
		} else {
			return new ArrayList();
		}
	}
}
