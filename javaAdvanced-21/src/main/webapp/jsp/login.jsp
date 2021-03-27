<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" >

 
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
				 <button class="btn btn-primary  login-button "  type="submit"><i class="fas fa-chevron-right"></i></button>
			</div>
			<div class="etc-login-form">
				<p><spring:message code="login.new_user" /> <a href="#" onclick="myFunction('showHide')"><spring:message code="login.create_account" /></a></p>
				
			</div>
		</form>
 

</div>

<div id="showHide">
 <div class="container-two">

		<div class="login-form-1">

			<form:form  method="POST" action="/" modelAttribute="userForm" class="form-signin text-left" id="register-form" onsubmit="return validateForm()">
				<h2 class="form-signin-heading logo"><spring:message code="login.new_user_word" /></h2>

				<div class="login-group">

						<div class="form-group">
								<input name="first_name" type="text" id="first_name" class="form-control"  placeholder="<spring:message code="login.register_form_first_name" />" required
       							minlength="2" maxlength="30" />
							</div>

						<div id="fname_err" class="err_style"></div>

							<div class="form-group">
								<input name="last_name" type="text" class="form-control" id="last_name" placeholder="<spring:message code="login.register_form_last_name" />" required
       							minlength="2" maxlength="30"/>
       						
							</div>

							<div id="lname_err" class="err_style"></div>
					
					<div class="form-group">
								<input name="email" type="email" id="email" class="form-control"
									placeholder="<spring:message code="login.register_form_email" />" />
							</div>

					<div id="email_err" class="err_style"></div>
					
					<div class="form-group">
								<input name="password" type="password" id="password"  class="form-control" minlength="8" maxlength="30"
									placeholder="<spring:message code="login.register_form_password" />" />
							</div>
							
					<div id="password_err" class="err_style"></div>

					
					<div class="form-group">
								<input name="password_confirm" type="password" id="password_confirm"  required class="form-control" minlength="8" maxlength="30"
									placeholder="<spring:message code="login.register_form_password_confirm" />" />
									<span id='message'></span>
									
							</div>
					
					<div id="password_c_err" class="err_style"></div>
					
				</div>
				<button class="btn btn-lg btn-primary btn-block register-button"  type="submit"><i class="fas fa-chevron-right"></i></button>
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




</body>
</html>	