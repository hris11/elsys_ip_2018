<%--
  Created by IntelliJ IDEA.
  User: hrist
  Date: 1/14/2018
  Time: 8:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="./styles/navigation.css" rel="stylesheet">
    <title>Navigation</title>
</head>
<body style="background: #282828;">
<ul>
    <li>
        <a href="./newItem.jsp">ADD NEW ITEM</a>
    </li>
    <li>
        <a href="./searchItems.jsp">SEARCH ITEMS</a>
    </li>
    <li>
        <a href="./uploadCSV.jsp">UPLOAD CSV</a>
    </li>
    <li>
        <a href="/api/csv/download">DOWNLOAD CSV</a>
    </li>
</ul>
</body>
</html>
