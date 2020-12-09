<%@page import="com.fasterxml.jackson.databind.JsonNode"
		import="javax.servlet.http.HttpSession"
		import="base.Helper"
		import="java.util.ArrayList"
		import="kagoyume.productDataBeans"
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果</title>
<%
	HttpSession hs = request.getSession();
	Helper helper = new Helper();
    ArrayList<productDataBeans> searchResult = (ArrayList<productDataBeans>) hs.getAttribute("searchResult");
%>
</head>
<body>
	<p style="text-align:center;">検索ワード： <%=request.getParameter("name")%></p><br><br>
	件数：<%=request.getAttribute("totalResult") %>件<br><br>
	<table border="1">
		<tr>
			<th></th>
			<th>商品名</th>
			<th>商品詳細</th>
			<th>価格</th>
			<th>評価</th>
		</tr>
	<%
		for(int i=0; i<10; i++){
	%>
		<tr>
			<td>
				<img src="<%=searchResult.get(i).getImage() %>">
			</td>
			<td>
				<a href="Item?code=<%=i %>" >
					<%=searchResult.get(i).getProductName() %>
				</a>
			</td>

			<td>
				<%=searchResult.get(i).getDescription() %>
			</td>
			<td>
				<%=searchResult.get(i).getPrice() %>円
			</td>
			<td>
				⭐️<%=searchResult.get(i).getReview() %>
			</td>
		</tr>
	<%}%>
	</table>
</body>
</html>