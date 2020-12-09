<%@ page import="base.Helper"
		 import="user.UserData"
%>
<%
	Helper helper = new Helper();
	UserData ud = (UserData)request.getAttribute("ud");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>ユーザー登録完了</title>
</head>
<body>
	<h1>ユーザー名：<%= ud.getName() %>
	パスワード：<%= ud.getPassword() %><br>
	メールアドレス：<%= ud.getMailaddress() %><br>
	住所：<%= ud.getAddress() %></h1>
	<h2>以上の内容で登録しました！</h2>

	<h3><%= helper.home() %></h3>
</body>
</html>