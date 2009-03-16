<%@ page import="java.io.*" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ include file="/commons/taglibs.jsp"%>

<html>
<head>
<title>Exceptional Even Occurred!</title>
<style>
body,p {
	font-family: Tahoma;
	font-size: 10pt;
	padding-left: 30;
}

pre {
	font-size: 8pt;
}
</style>
</head>

<body>
<%-- Exception Handler --%>
<font color="red"> <%=exception.toString()%><br>
</font>
<%
	out.println("<!--");
	StringWriter sw = new StringWriter();
	PrintWriter pw = new PrintWriter(sw);
	exception.printStackTrace(pw);
	out.print(sw);
	sw.close();
	pw.close();
	out.println("-->");
%>
</body>
</html>
