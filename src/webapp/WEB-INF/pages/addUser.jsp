
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
</head>
<body>
    <c:url value="/admin/add" var="var"/>
    <form action="${var}" method="POST">
        <label for="name">Name</label>
        <input type="text" name="name" id="name">
        <label for="password">PASSWORD</label>
        <input type="text" name="password" id="password">
        <label for="role">Role</label>
        <input type="text" name="role" id="role">
        <input type="submit" value="add User">
    </form>
<a href="/logout">LOGOUT</a>
</body>
</html>
