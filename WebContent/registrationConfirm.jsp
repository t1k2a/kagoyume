<%@page import="java.util.ArrayList"%>
<%@page import="user.UserData"%>
<%@page import="base.Helper"%>
<%
	Helper helper = Helper.getInstance();
    HttpSession hs = request.getSession();
    UserData ud = (UserData)hs.getAttribute("ud");
    ArrayList<String> chkList = ud.chkproperties();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登録確認ページ</title>
    </head>
    <body>
        <% if(chkList.size()==0){ %>
        <h1>登録確認</h1>
        名前:<%= ud.getName()%><br>
        パスワード:<%= ud.getPassword()%><br>
        メールアドレス:<%= ud.getMailaddress()%><br>
        住所:<%= ud.getAddress()%><br>
        上記の内容で登録します。よろしいですか？
        <form action="RegistrationComplete" method="POST">
            <input type="submit" name="yes" value="はい">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        </form>
        <% }else{ %>
        <h1>入力が不完全です。</h1>
        <%=helper.chkinput(chkList) %><br>
        <% } %><br>
        <form action="Registration" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
            <input type="hidden" name="mode" value="REINPUT">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        </form>
        <br>
        <br>
        <%=helper.home()%>
    </body>
</html>