<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login result</title>
</head>
<body>
	<%
		String user = request.getParameter("user");
		String pass = request.getParameter("password");
		if ("admin".equals(user) && "admin".equals(pass)) {
			out.println("Login OK");
		} else {
			out.println("Login Fail");
		}
	%>
	<form action="LoginServlet.html" method="post">
		<input type="submit" value="Еще раз"/>
	</form>
</body>
</html>