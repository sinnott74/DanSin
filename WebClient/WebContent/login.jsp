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
</head>
<body>
	<div class="navbar navbar-default" role="navigation" id="slide-nav">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-toggle"> <span class="sr-only">Toggle
						navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</a> <a class="navbar-brand" href="#">Brand Name</a>
			</div>
			<div id="slidemenu">

				<form class="navbar-form navbar-right" role="form">
					<div class="form-group">
						<input type="search" placeholder="search" class="form-control">
					</div>
					<button type="submit" class="btn btn-primary">Search</button>
				</form>

				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Dropdown <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</div>

	<div id="page-content">
		<!-- 	breadcrumb example (its the users trail of where theyve been) -->
		<ol class="breadcrumb text-center">
			<li><a href="#">Top Level</a></li>
			<li><a href="#">Middle Level</a></li>
			<li><a href="#">Bottom Level</a></li>
			<li class="active">Current Level</li>
		</ol>

		<div class="container">
			<s:if test="hasActionErrors()">
				<div class="errors">
					<s:actionerror theme="bootstrap" />
				</div>
			</s:if>
			<s:form action="login" validate="true" theme="bootstrap"
				cssClass="form-horizontal">
				<%-- 		<s:token /> --%>
				<s:textfield key="username" value="%{username}"
					cssClass="form-control col-lg-3" tooltip="Enter your Name here"
					placeholder="Enter your username here" />
				<s:password key="password" cssClass="form-control col-lg-3" />
				<s:submit cssClass="btn btn-primary" />
			</s:form>
		</div>
	</div>
</body>
</html>