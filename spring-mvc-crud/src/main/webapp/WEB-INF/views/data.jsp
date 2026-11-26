<%@ page import="entity.Product"%>
<%@ page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
</head>
<body>



	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Price</th>
		</tr>

		<%
		List<Product> data = (List<Product>) request.getAttribute("data");

		for (Product p : data) {
		%>
		<tr>
			<td><%=p.getId()%></td>
			<td><%=p.getName()%></td>
			<td><%=p.getPrice()%></td>
			<td><a href="update?id=<%=p.getId()%>">Update</a></td>
			<td><a href="delete?id=<%=p.getId()%>">Delete</a></td>


			<%
			}
			%>
		
	</table>
	
	<a href="insert">Add</a>

</body>
</html>