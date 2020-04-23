<%--
  Created by IntelliJ IDEA.
  User: Bogdan
  Date: 21.04.2020
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form name="userForm" action="/ServletProjectGroup1_war_exploded/test?action=mainPage" method="post">
    <h2> Enter your username: </h2><br>
    <input type="text"  name= "userName"  placeholder="Your username...">
    <input type="submit"  value="Login!">

</form>
</body>
</html>
