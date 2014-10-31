<%@ taglib prefix="s" uri="/struts-tags"%>
<div id="page-content">
	<!-- 	breadcrumb example (its the users trail of where theyve been) -->
	<ol class="breadcrumb text-center">
		<li><a href="#">Top Level</a></li>
		<li><a href="#">Middle Level</a></li>
		<li><a href="#">Bottom Level</a></li>
		<li class="active">Current Level</li>
	</ol>

	<div class="container">
		<div id="loginForm" class="vertical-center">
			<!-- form errors -->
			<s:if test="hasActionErrors()">
				<div class="errors">
					<s:actionerror theme="bootstrap" />
				</div>
			</s:if>
			<!-- form messages -->
			<s:if test="hasActionMessages()">
				<div class="welcome">
					<s:actionmessage />
				</div>
			</s:if>
			<s:form action="login" validate="true" theme="bootstrap"
				cssClass="form-horizontal">
				<%-- 		<s:token /> --%>
				<s:textfield key="username" value="%{username}"
					cssClass="form-control col-lg-3" tooltip="Enter your Name here"
					placeholder="Enter your username here" />
				<s:password key="password" cssClass="form-control col-lg-3" />
				<s:submit cssClass="btn btn-primary center-block" />
			</s:form>
		</div>
	</div>
</div>