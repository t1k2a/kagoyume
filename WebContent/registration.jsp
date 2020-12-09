<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
</head>
<body>
<h2>ユーザー登録</h2>
	<form action="RegistrationConfirm" method="POST">
		<label for="name">ユーザー名</label>
		<input type="text"  name="name"><br>
		<label for="password">パスワード</label>
		<input type="password" name="password"><br>
		<label for="mail">メールアドレス</label>
		<input type="text" name="mail"><br>
		<label for="address">住所</label>
		<input type="text" name="address"><br>
		<input type="submit" value="確認画面へ">
	</form>

	<a href="login">ログイン画面</a>
</body>
</html>