package cn.ceopen.sample.petstore.service;

import java.io.Serializable;
import java.util.List;

import cn.ceopen.sample.petstore.exception.MyPetStoreException;
import cn.ceopen.sample.petstore.vo.CategoryVo;
import cn.ceopen.sample.petstore.vo.ProductVo;

/**
 * Catalog Service 接口.
 * <p>
 * 该Service包含catalog目录相关的业务服务
 * 
 * @author zhou wei
 * @version 1.0
 * @since JDK1.5
 */
public interface CatalogService {

	/**
	 * 
	 * 获得CategoryVo结果集
	 * 
	 * @return List<CategoryVo>
	 * @throws MyPetStoreException
	 * @see MyPetStoreException
	 */
	public List<CategoryVo> getCategoryList() throws MyPetStoreException;

	public void addCategory(CategoryVo categoryVo);

	public void deleteCategoryById(String categoryId);

	public void deleteCateogries(Serializable[] ids);

	public void saveOrUpdate(CategoryVo category);

	public CategoryVo getCategory(String categoryId);

	public List<ProductVo> searchProductList(String keywords);
}
