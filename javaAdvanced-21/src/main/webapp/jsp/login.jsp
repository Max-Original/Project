<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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


<link type="text/css" href="/login.css" rel="stylesheet">

<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>


<title>login</title>
</head>
<body>
<div class="container">
	<div class="logo">login</div>
	<!-- Main Form -->
	<div class="login-form-1">
		<form method="POST" action="${contextPath}/login" class="form-signin">
			<div class="login-form-main-message"></div>
			<div class="main-login-form">
				<div class="login-group">
				
					<div class="form-group">
					
						<label for="email" class="sr-only">Email</label>
					    <input name="email" type="text" class="form-control" placeholder="Email" autofocus="true"/>
					</div>
					
					<div class="form-group">
						<label for="password" class="sr-only">Password</label>
						<input name="password" type="password" class="form-control " placeholder="Password"/>
					</div>
					
				</div>
				 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				 <button class="btn btn-lg btn-primary btn-block login-button " type="submit"></button>
			</div>
			<div class="etc-login-form">
				
				<h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
			</div>
		</form>
	
 

</div>

</body>
</html>


	
<%-- 	   <form method="POST" action="${contextPath}/login" class="form-signin">
        <h2 class="form-heading">Log in</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input name="email" type="text" class="form-control" placeholder="Email" autofocus="true"/>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <span>${403}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
            <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
        </div>

    </form> --%>
	
	