<%--
  Created by IntelliJ IDEA.
  User: hrist
  Date: 11/4/2017
  Time: 7:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>User Information</title>
    </head>
    <body>
        <span>Welcome!</span> <br />
        <span>ID: ${user.getId()}</span> <br />
        <span>Name: ${user.getName()}</span> <br />
        <span>Email: ${user.getEmail()}</span> <br />

        <form action="updateUser" method="POST" >
            <span>new id: </span>
            <input type="text" name="id" />
            <br />

            <span>new name: </span>
            <input type="text" name="name" />
            <br />

            <span>new email: </span>
            <input type="text" name="email" />
            <br />

            <input type="hidden" value="${user.getId()}" name="oldUserId" />
            <input type="hidden" value="${user.getName()}" name="oldUserName" />
            <input type="hidden" value="${user.getEmail()}" name="oldUserEmail" />

            <input type="submit" value="updateUser"/>

        </form>

        <form action="deleteUser" method="POST">
            <input type="hidden" value="${user.getId()}" name="oldUserId" />
            <input type="hidden" value="${user.getName()}" name="oldUserName" />
            <input type="hidden" value="${user.getEmail()}" name="oldUserEmail" />

            <input type="submit" value="Delete User">
        </form> <br />
        <form action="logout" method="POST">
            <input type="submit" value="Logout!" />
        </form>


    </body>
</html>
