<%@page import="com.fasterxml.jackson.databind.JsonNode"
		import="javax.servlet.http.HttpSession"
		import="java.util.HashMap"
		import="base.Helper"
		import="kagoyume.productDataBeans"
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
	HttpSession hs = request.getSession();
	productDataBeans pdb = (productDataBeans) hs.getAttribute("pdb");
	Helper helper = new Helper();
	hs.setAttribute("item", pdb);
%>
<title><%=pdb.getProductName() %></title>

</head>
<body>
	<img src="<%=pdb.getImage() %>"><br><br>
	商品コード：<%=pdb.getCode() %><br><br>
	商品名：<%=pdb.getProductName() %><br><br>
	価格：<%=pdb.getPrice() %>円<br><br>
	商品詳細：<%=pdb.getDescription() %><br><br>
 	レビュー：⭐<%=pdb.getReview() %><br><br>

	<form action="Add" method="POST">
		<select name="num">
			<%for(int i=1; i<=999; i++){ %>
			<option value="<%=i %>"><%=i %></option>
			<% } %>
		</select>

		<input type="submit" value="カートに入れる">
	</form>
</body>
</html>