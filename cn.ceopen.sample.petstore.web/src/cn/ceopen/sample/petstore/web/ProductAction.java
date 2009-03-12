/**
 * Create time Jul 10, 2008 9:44:49 AM
 */
package cn.ceopen.sample.petstore.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import cn.ceopen.sample.petstore.form.CatalogForm;
import cn.ceopen.sample.petstore.service.CatalogService;
import cn.ceopen.sample.petstore.vo.CategoryVo;
import cn.ceopen.sample.petstore.vo.ProductVo;


public class ProductAction extends DispatchAction {
	private CatalogService catalogService;

	public void setCatalogService(CatalogService catalogService) {
		this.catalogService = catalogService;
	}

	/**
	 * 方法说明：得到返回符合条件的查询结果的动�?,用extrme标签来展示这些记�?
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward searchProducts(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CatalogForm catalogForm = (CatalogForm) form;
		String keyword = catalogForm.getKeyword();
		
		if (keyword == null || keyword.length() < 1) {
			request
					.setAttribute("message",
							"Please enter a keyword to search for, then press the search button.");
			return mapping.findForward("failure");
		} else {
			List allProductList = catalogService.searchProductList(keyword);
			catalogForm.setProductList(allProductList);
			return mapping.findForward("success");
		}
	}
}
