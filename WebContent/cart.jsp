<%@ page import="java.util.ArrayList"
		 import="java.util.Arrays"
		 import="kagoyume.productDataBeans"
		 import="base.Helper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カート一覧</title>
<%
	HttpSession hs = request.getSession();
	ArrayList<productDataBeans> cart = (ArrayList)hs.getAttribute("Cart");
	int totalPrice = 0;
	Helper helper = new Helper();

%>
</head>
<body>
	<h1>カート一覧</h1>
    <% if (cart != null){ %>
	<table border=1>
            <tr>
                <th>画像</th>
                <th>商品名</th>
                <th>値段</th>
                <th></th>
            </tr>
            <% for(int i=0; i < cart.size(); i++){ %>
            <tr>
                <td width="250">
                	<img src="<%= cart.get(i).getImage() %>">
                </td>
                <td>
                	<a href="Item?cartNum=<%=i %>" >
                		<%= cart.get(i).getProductName() %></a>
                </td>
                <td>
                	<%= cart.get(i).getPrice() %>円
                </td>
           		 <td>
                    <form action="Cart" method="POST">
                    <input id="btnSubmit" type="submit" name="btnSubmit" value="削除">
                    <input type="hidden" value="<%= i %>" name="delete">
                    </form>
                </td>
 			<br>
			<%
				totalPrice += cart.get(i).getPrice();
				} %>
	       </tr>
	       <% }else{ %>
	      	 <h2>カートの中身は空です</h2>
	       <% } %>
	</table>

<h3>合計金額：<%= totalPrice %>円</h3>
<% if(cart != null){ %>
<form action="BuyConfirm">
  <input type="submit" value="購入する">
</form>
<% } %>
<%= helper.home() %>

</body>
</html>