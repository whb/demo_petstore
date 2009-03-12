<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div id="Catalog">
  <form action="categoryAction.do?method=doEdit" method="post">
  
    <h3 align="center"><bean:message key="category.list" /></h3>
    
    <table align="center">
	      <tr>
	        <td><bean:message key="category.id"/>:</td><td> 
	        	<input id="categoryId" readonly name="categoryId" value="${currentEntity.categoryId}">      	
	        </td>
	      </tr>
	      <tr>
		      <td><bean:message key="category.name"/>:</td><td>      	
		      	<input id="name"  name="categoryName" value="${currentEntity.categoryName}">     	
		      </td>
	      </tr>
	      <tr>
		      <td><bean:message key="category.des"/>:</td><td>      	
		      	<input id="description"  name="categoryDes" value="${currentEntity.categoryDes}">    	
		      </td>
	      </tr>
	      </table>
  			 <br>
  		<table align="center">	 
	      <input type="submit" name="submit" value="<bean:message key="category.saved"/>"/>
  		</table>
  </form>
</div>
