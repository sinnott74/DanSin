<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dansin</title>
</head>
<body>
	<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>
	</s:if>
	<s:form action="login" validate="true">
<%-- 		<s:token /> --%>
		<s:textfield key="username" value="%{username}" />
		<s:password key="password" />
		<s:submit />
	</s:form>
</body>
</html>