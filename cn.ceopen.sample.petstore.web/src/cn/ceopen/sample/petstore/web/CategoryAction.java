package cn.ceopen.sample.petstore.web;

import java.util.List;

import cn.ceopen.sample.petstore.service.CatalogService;
import cn.ceopen.sample.petstore.utils.StringFormat;
import cn.ceopen.sample.petstore.vo.CategoryVo;

import com.sitechasia.webx.core.annotation.Read;
import com.sitechasia.webx.core.web.struts1.action.BaseCRUDAction;

public class CategoryAction extends BaseCRUDAction<CategoryVo, Integer> {
	private CatalogService catalogService;

	public void setCatalogService(CatalogService catalogService) {
		this.catalogService = catalogService;
	}

	public String save(@Read CategoryVo category) {
		if (category.getCategoryName() != null
				&& category.getCategoryName().length() > 0) {
			catalogService.addCategory(category);
			List catalogList = catalogService.getCategoryList();
			this.getRequest().getSession().setAttribute("catalogList", catalogList);
			saveMessage("save.category.succeed", category.getCategoryName());
		} else {
			saveError("save.category.failed");
		}
		return "save";
	}
	
	public String list(){
		List list=catalogService.getCategoryList();
		this.getRequest().getSession().setAttribute("catalogList",list);
		return "save";	
	}
	
	public String delCategory(@Read CategoryVo category){
		this.catalogService.deleteCategoryById(category.getCategoryId());
		return "list";
	}
	
	public String deleteCategories() {
		String categoryIds = (String) this.getRequest().getParameter(
				"categoryIds");
		String[] ids = categoryIds.split(";");
		catalogService.deleteCateogries(ids);
		List<CategoryVo> catalogList = catalogService.getCategoryList();
		this.getRequest().getSession().setAttribute("catalogList", catalogList);
		return "save";
	}
	
	public String  update(@Read(key = "categoryId")
			String categoryId) {	
		CategoryVo categoryVo=catalogService.getCategory(categoryId);
		categoryVo.setCategoryDes(StringFormat.toHTMLString(categoryVo.getCategoryDes()));
		this.getRequest().setAttribute("currentEntity", categoryVo);
		return "update";
	}
	
	public String  doEdit(@Read
			CategoryVo categoryVo) {	
		System.out.println(categoryVo.getCategoryDes()+"==="+categoryVo.getCategoryId()+"==="+categoryVo.getCategoryName()+"========update after=======");
		catalogService.saveOrUpdate(categoryVo);
		return "list";
	}
}
