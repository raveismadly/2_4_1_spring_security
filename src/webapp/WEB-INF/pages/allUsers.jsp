
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<a href="/admin/add">Add User</a>
<table border="1px">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Password</td>
<%--        <td>Role</td>--%>
        <td>Actions</td>
    </tr>
    <c:forEach var="user" items="${allUsers}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.password}</td>
<%--            <td>${user.role}</td>--%>
            <td><a href="/admin/edit/${user.id}">Update User</a> </td>
            <td><a href="/admin/delete/${user.id}">Delete User</a>

        </tr>
    </c:forEach>
</table>
<a href="/logout">Logout</a>
</body>
</html>
