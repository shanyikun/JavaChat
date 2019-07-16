<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>login</title>
</head>
<body>
	<form action="/login" method="post">
		<input type="text" name="name" placeholder="用户名" required>
		<input type="password" name="password" placeholder="密码" required>
		<input type="submit" value="login">
	</form>
	<p>						
		没有账号？
		<a href="/register">注册</a>
	</p>
</body>
</html>