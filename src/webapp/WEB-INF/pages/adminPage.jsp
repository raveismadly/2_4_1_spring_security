<%@ taglib prefix="th" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--        <meta th:name="_csrf" th:content="${_csrf.token}"/>--%>
    <title>Admin page</title>
</head>
<body>

<a href="/admin/add">Add User</a>
<a href="/admin/users">ALL Users</a>
<a href="/logout">Logout</a>
</body>
</html>
