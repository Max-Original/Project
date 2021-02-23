<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Basket</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<div class="container">


		<div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
			<h3 class="w3-bar-item">Menu</h3>
			<a href="/home" class="w3-bar-item w3-button">Home</a> 
			<a href="/create-product" class="w3-bar-item w3-button">Create product</a>
			<a href="/baskets" class="w3-bar-item w3-button">Basket</a>
		</div>



		<div style="margin-left: 10%">
			<div class="w3-container w3-teal">
				<h1>Create new product</h1>
			</div>
			<div class="w3-container">
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<form id="logoutForm" method="POST" action="${contextPath}/logout">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>
					<h2>
						<a onclick="document.forms['logoutForm'].submit()">Logout</a>
					</h2>
				</c:if>

				<table class="table table-striped">
					<thead>
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Description</th>
							<th>Price</th>
							<th>Image</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="basket" items="${basketItems}">
							<tr>
								<td>${basket.id}</td>
								<td>${basket.product.name}</td>
								<td>${basket.product.description}</td>
								<td>${basket.product.price}</td>
								<td><img src="data:image/jpg;base64,${basket.product.encoded_image}" alt="image" style="width: 10%"></td>
								<td>${basket.purchase_date}</td>
								<td><a href="basket?id= ${basket.id}">delete</a></td>
							</tr>

						</c:forEach>


					</tbody>
				</table>


			</div>

		</div>


	</div>

</body>
</html>