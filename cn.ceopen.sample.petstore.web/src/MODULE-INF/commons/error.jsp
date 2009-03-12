<%@ page language="java" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ include file="/commons/taglibs.jsp"%>

<html>
<head>
<%
			if (request
			.getAttribute(com.sitechasia.webx.core.exception.support.StrutsExceptionHandler.WEBX_THE_EXCEPTION_KEY) == null)
		return;
%>
<%
			com.sitechasia.webx.core.exception.support.ExceptionWrapper wrapper = (com.sitechasia.webx.core.exception.support.ExceptionWrapper) request
			.getAttribute(com.sitechasia.webx.core.exception.support.StrutsExceptionHandler.WEBX_THE_EXCEPTION_KEY);
%>

<script>
<%
	if (wrapper.getCode() == null) {
	%>
	alert("you have a error:\r\n"+
  	"exception:"+"<%=wrapper.getCause().getClass().getName()%>"+"\r\n"+
  	"message:"+"<%=wrapper.getMessage()%>"+"\r\n");
	<%
	} else {
	%>
	alert("you have a error:\r\n"+
	"code:"+"<%=wrapper.getCode()%>"+"\r\n"+
  	"type:"+"<%=wrapper.getType()%>"+"\r\n"+
  	"severity:"+"<%=wrapper.getSeverity()%>"+"\r\n"+
  	"description:"+"<%=wrapper.getDescription()%>"+"\r\n"+
  	"message:"+"<%=wrapper.getMessage()%>"+"\r\n");
	<%
	}
%>

history.go(-1);
</script>
<base href="${ctx}">
<title>error</title>
</head>
<body>
</body>
</html>
