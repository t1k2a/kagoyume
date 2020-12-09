<%@ page import="base.Helper" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>買った気になるECサイト-かごゆめ</title>
<%
	Helper helper = new Helper();
	HttpSession hs = request.getSession();
%>
</head>
<body>
	<h1>かごゆめへようこそ！</h1>
	<h3>ここではたくさんの商品を買った気になります！！</h3>
	<h3>早速ここから検索してみましょう！！</h3>
	<form action="Search" method="GET">
		商品名：
		<input type="text" name="name" value="" required>
		<input type="submit" value="検索">
	</form>

	<%=helper.cart() %>
	<% if(hs.getAttribute("ud") != null){ %>
		<a href="Logout">ログアウト</a>
		<h3><%=(String)hs.getAttribute("loginStatus") %></h3>
	<% }else{ %>
		<%=helper.login() %>
	<% } %>

</body>
</html>