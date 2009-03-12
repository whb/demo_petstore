<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%@ include file="/commons/head.jsp"%>
<bean:define id="category" name="catalogForm" property="category"/>
<bean:define id="productList" name="catalogForm" property="productList" />
<html>
<head>
<title>product list
</title>
</head>
<body>
<h1 align="center"><bean:message key="product.list" /></h1>
<div id="Catalog">
	<center>
			<ec:table useAjax="false" items="productList" var="product" view="ssview"
				title=""
				action=""
				csvFileName="product.csv"
				xlsFileName="product.xls"
				pdfFileName="product.pdf"
				classic="false"
				resizeColWidth="true"
				rowsDisplayed="5"
				listWidth="" 
				retrieveRowsCallback="process"
				toolbarContent="firstpage|prevpage|pagesnum|nextpage|lastpage|pagejump|totalcount|refresh">
				<ec:row>
					<ec:column property="productId" title="Product ID " width="">
						<a
							href="">${product.productId}</a>
					</ec:column>
					<ec:column property="name" title="Name" width="">
					</ec:column>
				</ec:row>
			</ec:table>
	</center>

</div>

</body>
</html>



