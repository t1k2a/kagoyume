<%@page import="kagoyume.productDataBeans"
		import="java.util.ArrayList"
		import="base.Helper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カートへ追加</title>
<%
	HttpSession hs = request.getSession();
	productDataBeans cart = (productDataBeans)hs.getAttribute("item");
	Helper helper = new Helper();
%>
</head>
<body>
	<h1>カートに追加しました</h1>
	<table border=1>
            <tr>
                <th>画像</th>
                <th>商品名</th>
                <th>値段</th>
            </tr>
            <tr>
				<td><img src="<%=cart.getImage() %>"></td>
				<td><%=cart.getProductName() %></td>
				<td><%=cart.getPrice() %>円</td>
            </tr>
        </table> <br>

	<%=helper.home() %>
	<%=helper.cart() %>

</body>
</html>