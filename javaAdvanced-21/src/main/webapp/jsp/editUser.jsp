<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

 <!-- Bootstrap CSS CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <!-- My Custom CSS -->
    <link rel="stylesheet" href="css/sidebar.css">
    <!-- Scrollbar Custom CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css">
	
<title>Edit user</title>
</head>
<body>

		
		<div class="wrapper">
        <!-- Sidebar  -->
        <nav id="sidebar">
            <div class="sidebar-header">
                <h3><spring:message code='sidebar.title' /></h3>
            </div>

            <ul class="list-unstyled components">
                <p><spring:message code='sidebar.menu' /></p>
                <li class="active">
                    <a href="/home" class="w3-bar-item w3-button"><spring:message code='sidebar.menu.home' /></a> 
                </li>
                <li class="active">
                   <sec:authorize access="hasRole('ROLE_ADMIN')">
			<a href="/create-product" class="w3-bar-item w3-button"><spring:message code='sidebar.menu.create.product' /></a>
			</sec:authorize>
                </li>
            
                <li class="active">
                    <sec:authorize access="hasRole('ROLE_USER')">
			<a href="/baskets" class="w3-bar-item w3-button"><spring:message code='sidebar.menu.basket' /></a>
			</sec:authorize>
                </li>
                <li>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <a href="/order"><spring:message code='sidebar.menu.order' /></a>
                </sec:authorize>
                </li>
                <li><sec:authorize access="hasRole('ROLE_ADMIN')">
						<a href="/users"><spring:message code='sidebar.menu.users' /></a>
					</sec:authorize></li>
            </ul>
        </nav>

<div id="content">
 		<nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">

                    <button type="button" id="sidebarCollapse" class="btn btn-info">
                        <i class="fas fa-align-left"></i>
                        <span><span><spring:message code='sidebar.show.menu' /></span>
                    </button>
                 
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="nav navbar-nav ml-auto">
                            <li class="nav-item active">
                                
                                
                                <a class="nav-link" href="#" onclick="document.forms['logoutForm'].submit()"><spring:message code='sidebar.sing.out' /></a>
                            
                           
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>


</body>
</html>