<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	String search_zipcode = (String)request.getAttribute("search_zipcode");
	String address1 = (String)request.getAttribute("address1");
	String address2 = (String)request.getAttribute("address2");
	String address3 = (String)request.getAttribute("address3");
%>
</head>
<body>
	<p>検索した郵便番号： <%= search_zipcode %></p>
	<p>都道府県： <%= address1 %></p>
	<p>市区町村： <%= address2 %></p>
	<p>住所１： <%= address3 %></p>
</body>
</html>