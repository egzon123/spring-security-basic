<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Egzon
  Date: 7/31/2019
  Time: 10:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Welcome Home Page  </h1>


<hr>
<%--   display user name and role--%>

<p>
    User:<security:authentication property="principal.username"/>
    <br>
    
    Role(s):<security:authentication property="principal.authorities"/>

    <hr>
<p>
    <a href="/leaders">LeaderShip Meeting (Only for Manager peeps)</a>
</p>
<p>
    <a href="/systems">IT System Meeting (Only for Admin peeps)</a>
</p>
    <hr>
</p>

<%--        Add a logut button--%>
            <form:form action="/logout" method="post">
                <input type="submit" value="Logout">

            </form:form>
</body>
</html>
