<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Dansin</title>
<sb:head />
</head>
<body>
	<div class="navbar navbar-inverse"></div>
	<div class="container">
		<s:if test="hasActionErrors()">
			<div class="errors">
				<s:actionerror theme="bootstrap"/>
			</div>
		</s:if>
		<s:form action="login" validate="true" theme="bootstrap" cssClass="form-horizontal">
			<%-- 		<s:token /> --%>
			<s:textfield key="username" value="%{username}"  cssClass="form-control" tooltip="Enter your Name here"/>
			<s:password key="password" cssClass="form-control"/>
			<s:submit cssClass="btn btn-primary" />
		</s:form>
	</div>
</body>
</html>