<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>Dansin</title>
<script src="hammer.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<sj:head loadFromGoogle="true" />
<script src='slide-menu.js'></script>
<link href="style.css" rel="stylesheet">
<!-- Adds android app support -->
<link rel="manifest" href="manifest.json">
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/navbar.jsp"></jsp:include>

	<jsp:include page="/WEB-INF/jsp/${param.pagecontent}.jsp"></jsp:include>
</body>
</html>