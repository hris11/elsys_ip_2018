<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Admin</title>
</head>
<body>

	<form action="addUser" method="POST">
		<span>Id: </span>
		<input type="text" name="id" />
		<br />
		<span>Name: </span>
		<input type="text" name="name" />
		<br />
		<span>Email: </span>
		<input type="text" name="email" />
		<br />
		<input type="submit" value="addUser" />
	</form>

	<br />

	<form action="user" method="GET">
		<input type="text" name="name" />
		<input type="submit" value="Search"/>
	</form>

	<br />

	<table>
		<tr>
			<th>ID</th>
			<th>Username</th>
			<th>Email</th>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.email}</td>
				<td><a href="user?name=${user.name}">Go to user page</a></td>
				<td>
					<form action="deleteUser" method="POST">
						<input type="hidden" value="${user.getId()}" name="oldUserId" />
						<input type="hidden" value="${user.getName()}" name="oldUserName" />
						<input type="hidden" value="${user.getEmail()}" name="oldUserEmail" />

						<input type="submit" value="Delete User">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>

	<form action="logout" method="POST">
		<input type="submit" value="Logout!" />
	</form>
</body>
</html>