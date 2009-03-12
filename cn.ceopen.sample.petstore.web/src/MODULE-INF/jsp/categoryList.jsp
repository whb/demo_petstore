<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><bean:message key="application.title" /></title>

<script type="text/javascript">
	function deleteCategory(){
		var categoryIds=document.getElementsByName("id");
		var ids="";
		for (var i=0; i<categoryIds.length; i++){
			if (categoryIds[i].type=="checkbox"&&categoryIds[i].checked==true){
				ids+=categoryIds[i].value + ";";
			}
		}
	
		if(ids=="")
		{
			alert("请选择要删除的信息!");
			return;
		}
		document.getElementsByName("categoryIds")[0].value=ids;
		document.presForm.action="${ctx}/categoryAction.do?method=deleteCategories";
	    document.presForm.submit();
	}
	function addCategory(){
            document.presForm.action="${ctx}/jsp/addCategory.jsp";
	     document.presForm.submit();
		}
</script>
</head>

<body>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String sLang = request.getLocale().getLanguage();
	String fileName;
	java.util.List supported = new java.util.ArrayList();
	supported.add("zh");
	supported.add("en");
	if (supported.contains(sLang)) {
		fileName = "extremecomponents_msg_" + sLang + ".js";
	} else {
		fileName = "extremecomponents_msg_zh.js";
	}
%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="contextPath" value="<%=basePath%>" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/extremecomponents/css/extremecomponents_style.css" />
<script type="text/javascript"
	src="${ctx}/extremecomponents/js/prototype_mini.js"></script>
<script type="text/javascript"
	src="${ctx}/extremecomponents/js/<%=fileName%>"></script>
<script type="text/javascript"
	src="${ctx}/extremecomponents/js/extremecomponents.js"></script>
<script type="text/javascript"
	src="${ctx}/scripts/validation/validate.js"></script>

<h1 align="center"><bean:message key="category.list" /></h1>

<ec:table items="catalogList" var="category" view="ssview"
	title="${category.categoryName}" action="" csvFileName="category.csv"
	xlsFileName="category.xls" pdfFileName="category.pdf" classic="false"
	useAjax="false" pageSizeList="true" resizeColWidth="true" rowsDisplayed="10" listWidth="100%"
	retrieveRowsCallback="process" toolbarLocation="top"
	toolbarContent="firstpage|prevpage|pagesnum|nextpage|lastpage|pagejump|totalcount|refresh">
	<ec:row>
		<ec:column alias="id" cell="checkbox" headerCell="checkbox"
			property="categoryId" value="${category.categoryId}" width="5%"
			tagAttributes="align='center'" />
		<ec:column property="rowcount11" cell="rowCount" sortable="false"
			title="行号" width="5%" filterable="false"
			tagAttributes="align='center'" />
		<ec:column property="categoryId" title="Category ID " width="">
		</ec:column>
		<ec:column property="categoryName" title="Category Name" width="">
		</ec:column>
		<ec:column property="categoryDes" title="Category Des" width="">
		</ec:column>
		<ec:column property="o" title="Operation" width="">
			<a
				href="${ctx}/categoryAction.do?method=delCategory&categoryId=${category.categoryId}"><bean:message key="category.delete"/></a>
			<a	
				href="${ctx}/categoryAction.do?method=update&categoryId=${category.categoryId}"><bean:message key="category.update"/></a>
	</ec:column>
	</ec:row>
</ec:table>
<center>
<form id="presForm" name="presForm" action="" method="post">

<input	type="hidden" name="categoryIds" value="" />
<input	type="submit" value="<bean:message key="category.add"/>" onClick="addCategory()"/>
<input type="button" value="<bean:message key="category.delete"/>" onClick="deleteCategory()"/></form>
<div id="Search">
    <div id="SearchContent">
      <html:form method="post" action="/searchProducts.dol?method=searchProducts">
        <input name="keyword" size="14"/>&nbsp;
        <input type="submit" name="SearchButton" value="<bean:message key="product.search"/>"/>(<bean:message key="e.g"/> fish,dog,cat,bird)
      </html:form>
    </div>
  </div>

</center>

</body>
</html>
