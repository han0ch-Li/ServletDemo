<%--
  Created by IntelliJ IDEA.
  User: 89217
  Date: 2022-10-07
  Time: 下午 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <h1>Login</h1>
<div style="text-align: center">
<%--    以post方式提交表单，提交到login请求--%>
    <form action="${pageContext.request.contextPath}/login" method="post">
        username:<input type="text" name="username" required><br>
        password:<input type="password" name="password" required><br>
        hobby:
        <input type="checkbox" name="hobbies" value="Coding">Coding
        <input type="checkbox" name="hobbies" value="Dancing">Dancing
        <input type="checkbox" name="hobbies" value="VideoGame">Video Games
        <input type="checkbox" name="hobbies" value="Singing">Singing
        <br>
        <input type="submit">
    </form>
</div>
</body>
</html>
