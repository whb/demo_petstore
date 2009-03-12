package cn.ceopen.sample.petstore.vo;

import com.sitechasia.webx.core.model.IViewObject;

public class CategoryVo implements IViewObject {

	private static final long serialVersionUID = -3180163464235838668L;

	private String categoryId;

	private String categoryName;

	private String categoryDes;

	public boolean validate() {
		return true;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "categoryId: " + categoryId + " categoryName: " + categoryName + " categoryDes: " + categoryDes;
	}
}
