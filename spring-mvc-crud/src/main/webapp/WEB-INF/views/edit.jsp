<%@ page import="entity.Product"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Product</title>
</head>
<body>

	<%
	Product product = (Product) request.getAttribute("edit");
	%>

	<form action="editsavedata" method="get">

		<input type="hidden" name="id" value="<%=product.getId()%>">

		Name: <input type="text" name="name" value="<%=product.getName()%>">
		Price: <input type="number" name="price" value="<%=product.getPrice() %>">

		Quantity: <input type="number" name="qty"
			value="<%=product.getQty()%>">
			 <input type="submit" value="Update">

	</form>

</body>
</html>