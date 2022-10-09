<html>
<body>
<h2>Hello World!</h2>
<%--这里提交的路径，需要寻找到项目的路径--%>
<%--pageContext.request.contextPath代表当前项目--%>
<form action="${pageContext.request.contextPath}/login" method="get">
    username:<input type="text" name="username">
    password:<input type="password" name="password">
    <input type="submit">
</form>
</body>
</html>
