<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>login</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
    
<link href='https://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'>

<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>



<script src="js/myscripts.js"></script>

</head>
<body>

	<div class="language-div">
		<fieldset class="fieldset">
			<label><spring:message code="login.choose_language" /></label>
			
			<select id="locales" class="form-control">
		    
		     	<option value="en"> <spring:message code='login.english' /> </option>
				<option value="ua"> <spring:message code='login.ukrainian' /> </option> 

			</select>
		</fieldset>
	</div>

	<div class="container">	
	<div class="logo" ><spring:message code="login.welcome" /></div>
	<!-- Main Form -->
	<div class="login-form-1">
		<form method="POST" action="${contextPath}/login" class="form-signin text-left" id="login-form">
			<div class="login-form-main-message"></div>
			<div class="main-login-form">
				<div class="login-group">
				
					<div class="form-group">
						
					    <input name="email" type="text" class="form-control" placeholder="<spring:message code="login.email" /> "/>
					</div>
					
					<div class="form-group">
						
						<input name="password" type="password" class="form-control " placeholder="<spring:message code="login.password" />"/>
					</div>
					
				</div>
				 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				 <button class="btn btn-primary  login-button " type="submit"><i class="fas fa-chevron-right"></i></button>
			</div>
			<div class="etc-login-form">
				<p><spring:message code="login.new_user" /> <a href="#" onclick="myFunction('showHide')"><spring:message code="login.create_account" /></a></p>
				
			</div>
		</form>
 

</div>

<div id="showHide">
 <div class="container-two">

		<div class="login-form-1">

			<form:form method="POST" action="/registration" modelAttribute="userForm" class="form-signin text-left" id="register-form">
				<h2 class="form-signin-heading logo"><spring:message code="login.new_user_word" /></h2>

				<div class="login-group">

<%-- 					<spring:bind path="firstName">
						<div class="form-group ${status.error ? 'has-error' : ''}">
									
							<form:input type="text" path="firstName" class="form-control" placeholder="<spring:message code="login.new_user_word" />" autofocus="true"/>
						
			
							<form:errors path="firstName"></form:errors>
						</div>
					</spring:bind> --%>
					
					<div class="form-group">
					    <input name="firstName" type="text" class="form-control" placeholder="<spring:message code="login.register_form_first_name" />"/>
					</div>

<%-- 					<spring:bind path="lastName">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<form:input type="text" path="lastName" class="form-control"
								placeholder="Last name" autofocus="true"></form:input>
							<form:errors path="lastName"></form:errors>
						</div>
					</spring:bind> --%>


							<div class="form-group">
								<input name="lastName" type="text" class="form-control"
									placeholder="<spring:message code="login.register_form_last_name" />" />
							</div>

<%-- 							<spring:bind path="email">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<form:input type="text" path="email" class="form-control"
								placeholder="Email" autofocus="true"></form:input>
							<form:errors path="email"></form:errors>
						</div>
					</spring:bind> --%>
					
					<div class="form-group">
								<input name="email" type="email" class="form-control"
									placeholder="<spring:message code="login.register_form_email" />" />
							</div>

<%-- 					<spring:bind path="password">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<form:input type="password" path="password" class="form-control"
								placeholder="Password"></form:input>
							<form:errors path="password"></form:errors>
						</div>
					</spring:bind> --%>
					
					<div class="form-group">
								<input name="password" type="password" class="form-control"
									placeholder="<spring:message code="login.register_form_password" />" />
							</div>

<%-- 					<spring:bind path="passwordConfirm">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<form:input type="password" path="passwordConfirm"
								class="form-control" placeholder="Confirm your password"></form:input>
							<form:errors path="passwordConfirm"></form:errors>
						</div>
					</spring:bind> --%>
					
					<div class="form-group">
								<input name="passwordConfirm" type="password" class="form-control"
									placeholder="<spring:message code="login.register_form_password_confirm" />" />
							</div>
					
				</div>
				<button class="btn btn-lg btn-primary btn-block register-button" type="submit"><i class="fas fa-chevron-right"></i></button>
			</form:form>
		</div>

		<div class="etc-login-form">
			<p>
				<spring:message code="login.register_have_account" /> <a href="login" ><spring:message code="login.sing_in" /></a>
			</p>
		</div>

	</div>
 
 </div>
</div>

<!-- <script src="/login.js"></script> -->


</body>
</html>	