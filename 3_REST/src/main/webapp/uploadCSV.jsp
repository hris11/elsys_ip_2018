<%--
  Created by IntelliJ IDEA.
  User: hrist
  Date: 1/14/2018
  Time: 3:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="navigation.jsp" />
<form action="/api/csv/upload" method="post" enctype="multipart/form-data">
    <input type="file" accept="text/csv" name="file">
    <input type="submit" value="Upoload CSV">
</form>
</body>
</html>
