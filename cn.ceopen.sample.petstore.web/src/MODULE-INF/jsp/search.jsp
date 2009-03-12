<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ include file="../commons/taglibs.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<body>

  <div id="Search">
    <div id="SearchContent">
      <html:form method="post" action="/searchProducts.dol?method=searchProducts">
        <input name="keyword" size="14"/>&nbsp;<input type="submit" name="SearchButton"
        value="Search"/>
      </html:form>
    </div>
  </div>

</html>