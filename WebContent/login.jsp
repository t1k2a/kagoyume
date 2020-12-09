<%@page import="base.Helper" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
    Helper helper = new Helper();
    HttpSession hs = request.getSession();
    hs.getAttribute("ac");
    String message = (String)request.getAttribute("message");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザーログイン</title>
</head>
<body>
	<%=message != null ? message : ""  %>
	<h2>ユーザーログイン</h2>
	<form action="LoginResult" method="POST">
		<label for="name">ユーザー名</label>
		<input type="text"  name="name"><br>
		<label for="passwoed">パスワード</label>
		<input type="password" name="password"><br>
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input id="btnSubmit" type="submit" name="btnSubmit" value="ログイン"><br>
	</form>
	<a href="Registration">ユーザー登録</a>
</body>
</html>