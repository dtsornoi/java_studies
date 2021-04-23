
<%--

This view is used for Custom login

--%>
<%--
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<h3>Login Form</h3>
<body>
    <form:form
            action="${pageContext.request.contextPath}/authenticateTheUser"
            method="post">
        <p>
            User Name: <input type="text" name="username" />
        </p>

        <p>
            Password: <input type="password" name="password" />
        </p>
        <input type="submit" value="Login" />
    </form:form>
</body>
</html>
--%>