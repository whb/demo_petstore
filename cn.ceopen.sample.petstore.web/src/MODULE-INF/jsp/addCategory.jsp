<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><bean:message key="application.title"/></title>

<script type="text/javascript">
	function cancel(){
            document.presForm.action="${ctx}";
	     document.presForm.submit();
		}
</script>
</head>

<body>
<div id="content">
<h1><bean:message key="category.title"/></h1>

<form name="presForm" action="${ctx}/categoryAction.do?method=save" method="post">
	<bean:message key="category.id"/>:<input type="text" id="categoryId"  name="categoryId" /><br/>  
	<bean:message key="category.name"/>：<input type="text" id="categoryName" name="categoryName" /><br />
	<bean:message key="category.des"/>: <input type="text" id="categoryDes" name="categoryDes" /><br />
	<input name="qued" type="submit" value="<bean:message key="submit"/>" />
	<input name="qued" type="reset" value="<bean:message key="reset"/>" />
	<input name="qued" type="button" value="<bean:message key="cancel"/>" onClick="cancel()"/>
</form>
</div>
</body>
</html>
