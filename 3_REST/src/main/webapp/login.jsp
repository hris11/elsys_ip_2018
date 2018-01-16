<%--
  Created by IntelliJ IDEA.
  User: hrist
  Date: 1/14/2018
  Time: 2:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <jsp:include page="navigation.jsp" />
    <form action="api/auth/login" method="post">
        <label>username</label>
        <input name="username" type="text">
        <label>password</label>
        <input name="password" type="password">
        <input type="submit" value="login">
    </form>

</body>
</html>
