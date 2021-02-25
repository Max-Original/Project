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

<style type="text/css">

body {
  background: #efefef;
  padding: 10px;
  font-family: 'Varela Round';
}

/*=== 1. container ===*/
.container {
    text-align: center;
    position: absolute;
    top: 50%;
    left: 50%;
    margin: -146px 0 0 -113px;
}
/*=== 2. Anchor Link ===*/
a {
  color: #aaaaaa;
  transition: all ease-in-out 200ms;
}
a:hover {
  color: #333333;
  text-decoration: none;
}
/*=== 3. Text Outside the Box ===*/
.etc-login-form {
  color: #919191;
}

/*=== 4. Main Form ===*/
.login-form-1 {
  max-width: 300px;
  border-radius: 5px;
  display: inline-block;
}
.main-login-form {
  position: relative;
}
.login-form-1 .form-control {
  border: 0;
  box-shadow: 0 0 0;
  border-radius: 0;
  background: transparent;
  color: #555555;
  padding: 7px 0;
  font-weight: bold;
  height:auto;
}
.login-form-1 .form-control::-webkit-input-placeholder {
  color: #999999;
}
.login-form-1 .form-control:-moz-placeholder,
.login-form-1 .form-control::-moz-placeholder,
.login-form-1 .form-control:-ms-input-placeholder {
  color: #999999;
}
.login-form-1 .form-group {
  margin-bottom: 0;
  border-bottom: 2px solid #efefef;
  padding-right: 20px;
  position: relative;
}
.login-form-1 .form-group:last-child {
  border-bottom: 0;
}
.login-group {
  background: #ffffff;
  color: #999999;
  border-radius: 8px;
  padding: 10px 20px;
}
.login-group-checkbox {
  padding: 5px 0;
}
/*=== 5. Login Button ===*/
.login-form-1 .login-button {
  position: absolute;
  right: -25px;
  top: 50%;
  background: #ffffff;
  color: #999999;
  padding: 11px 0;
  width: 50px;
  height: 50px;
  margin-top: -25px;
  border: 5px solid #efefef;
  border-radius: 50%;
  transition: all ease-in-out 500ms;
}
.login-form-1 .login-button:hover {
  color: #555555;
  transform: rotate(450deg);
}
.login-form-1 .login-button.clicked {
  color: #555555;
}
.login-form-1 .login-button.clicked:hover {
  transform: none;
}
.login-form-1 .login-button.clicked.success {
  color: #2ecc71;
}
.login-form-1 .login-button.clicked.error {
  color: #e74c3c;
}

/*=== 9. Misc ===*/
.logo {
  padding: 15px 0;
  font-size: 25px;
  color: #aaaaaa;
  font-weight: bold;
}

/*=== 10. button test ===*/

.btn-primary {
	color: #fff;
	background-color: #428bca;
	border-color: #357ebd
}

.btn-primary:hover, .btn-primary:focus, .btn-primary.focus, .btn-primary:active,
	.btn-primary.active, .open>.dropdown-toggle.btn-primary {
	color: #fff;
	background-color: #3071a9;
	border-color: #285e8e
}

.btn-primary:active, .btn-primary.active, .open>.dropdown-toggle.btn-primary
	{
	background-image: none
}

.btn-primary.disabled, .btn-primary[disabled], fieldset[disabled] .btn-primary,
	.btn-primary.disabled:hover, .btn-primary[disabled]:hover, fieldset[disabled] .btn-primary:hover,
	.btn-primary.disabled:focus, .btn-primary[disabled]:focus, fieldset[disabled] .btn-primary:focus,
	.btn-primary.disabled.focus, .btn-primary[disabled].focus, fieldset[disabled] .btn-primary.focus,
	.btn-primary.disabled:active, .btn-primary[disabled]:active, fieldset[disabled] .btn-primary:active,
	.btn-primary.disabled.active, .btn-primary[disabled].active, fieldset[disabled] .btn-primary.active
	{
	background-color: #428bca;
	border-color: #357ebd
}

.btn-primary .badge {
	color: #428bca;
	background-color: #fff
}

/*=== 11. button pointer test ===*/

.fas {
    display: inline-block;
    font: normal normal normal 14px/1 FontAwesome;
    font-size: inherit;
    font-style: normal;
    font-variant-ligatures: normal;
    font-variant-caps: normal;
    font-variant-numeric: normal;
    font-variant-east-asian: normal;
    font-weight: normal;
    font-stretch: normal;
    line-height: 1;
    font-family: FontAwesome;
    text-rendering: auto;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    transform: translate(0, 0);
}

.fa-chevron-right:before {
    content: "\27A4";
}
</style>


<link href='https://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'>

<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		var selItem = localStorage.getItem("locales");
		$('#locales').val(selItem ? selItem : 'en');
		$("#locales").change(function() {
			var selectedOption = $('#locales').val();
			if (selectedOption) {
				window.location.replace('?lang=' + selectedOption);
				localStorage.setItem("locales", selectedOption);
			}
		});
	});
</script>


</head>
<body>

	<div>
		<fieldset>
			<label><spring:message code="login.choose_language" /></label>
			
			<select id="locales">
		    
		     	<option value="en"> <spring:message code='login.english' /> </option>
				<option value="ua"> <spring:message code='login.ukrainian' /> </option> 

			</select>
		</fieldset>
	</div>

	<div class="container">	
	<div class="logo" ><spring:message code="login.welcome" />login</div>
	<!-- Main Form -->
	<div class="login-form-1">
		<form method="POST" action="${contextPath}/login" class="form-signin text-left" id="login-form">
			<div class="login-form-main-message"></div>
			<div class="main-login-form">
				<div class="login-group">
				
					<div class="form-group">
						
					    <input name="email" type="text" class="form-control" placeholder="Email: "/>
					</div>
					
					<div class="form-group">
						
						<input name="password" type="password" class="form-control " placeholder="Password: "/>
					</div>
					
				</div>
				 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				 <button class="btn btn-lg btn-primary  login-button " type="submit"><i class="fas fa-chevron-right"></i></button>
			</div>
			<div class="etc-login-form">
				<p>new user? <a href="${contextPath}/registration">create new account</a></p>
				
			</div>
		</form>
	
 

</div>
</div>

<!-- <script src="/login.js"></script> -->


</body>
</html>	