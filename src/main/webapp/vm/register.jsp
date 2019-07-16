<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>register</title>
</head>
<body>
	<form action="/register" method="post">
		<input type="text" name="name" placeholder="用户名" required>
		<input type="password" name="password" placeholder="密码" required>
		<input type="submit" value="register">
	</form>
	<p>
		已有账号？
		<a href="/login">登录</a>
	</p>
</body>
</html>