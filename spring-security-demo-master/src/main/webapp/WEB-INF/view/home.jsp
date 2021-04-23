<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <h1>hello</h1>
        <hr>
        <p>Welcome to Dashboard</p>
        <p>
            User: <security:authentication property="principal.username" />
            |
            Role: <security:authentication property="principal.authorities"/>
        </p>
        <hr>
        <a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
        <br>
        <a href="${pageContext.request.contextPath}/systems">Admins</a>
        <hr>
    <form:form action="/logout" method="post">
        <input type="submit" value="Logout">
    </form:form>
    </body>
</html>
