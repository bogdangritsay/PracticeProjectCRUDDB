<%@ page import="test.dao.DAOConnection" %>
<%@ page import="test.dao.OracleDAOConnection" %>
<%@ page import="java.util.List" %>
<%@ page import="test.model.Question" %><%--
  Created by IntelliJ IDEA.
  User: Bogdan
  Date: 21.04.2020
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Questions</title>
</head>
<body>

    <% DAOConnection connection = new OracleDAOConnection();
        List<Question> questions = connection.selectAllQuestions();
        for (int i = 0; i < 5; i++) {
    %>
    <form action="" method="post">
        <p> <%=questions.get(i).getQuestion()%></p>
        <p> Your question: </p>
        <input type="text" name="answer" placeholder="Type here the answer...">
        <input type="submit" name="go" value="">

    </form>

     <% } %>

</body>
</html>
