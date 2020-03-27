
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form method="post" action="/login">
    <%--@declare id="name"--%><%--@declare id="password"--%><label for="name">Name</label>
    <input  name="j_username"/>
        <label for="password">Password</label>
    <input  name="j_password"/>
    <input type="submit"/>
</form>

</body>
</html>
