<%@ page import="java.util.ArrayList"
		 import="java.util.Arrays"
		 import="kagoyume.productDataBeans"
		 import="base.Helper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	HttpSession hs = request.getSession();
	ArrayList<productDataBeans> cart = (ArrayList<productDataBeans>)hs.getAttribute("Cart");
	Helper helper = new Helper();

	int totalPrice = 0;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入</title>
</head>
<body>
	<h3>以下の内容で購入する</h3>
	<table border=1>
            <tr>
                <th>画像</th>
                <th>商品名</th>
                <th>値段</th>
            </tr>
            <% for(int i=0; i < cart.size(); i++){ %>
            <tr>
                <td width="250">
                	<img src="<%= cart.get(i).getImage() %>">
                </td>
                <td>
                		<%= cart.get(i).getProductName() %></a>
                </td>
                <td>
                	<%= cart.get(i).getPrice() %>円
                </td>
 			<br>
			<%
				totalPrice += cart.get(i).getPrice();
				} %>
	       </tr>
     </table>
     <h3>合計金額：<%= totalPrice %>円</h3>
	発送方法：
	<form action="BuyComplete" method="POST">
	<% for(int i=1; i<=3; i++){ %>
		<input type="radio" name="type" value="<%= i %>" checked="checked">
		<%= helper.exTypeNum(i) %>
		<br>
	<% } %>
	<input type="submit" value="上記の内容で購入する">
 	</form>

<a href="Cart">カートに戻る</a>
<%= helper.home() %>
</body>
</html>