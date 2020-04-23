<%--
  Created by IntelliJ IDEA.
  User: olbe0615
  Date: 17.02.2020
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="/pages/errorPage.jsp" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
</br>

<div>
    <ul>
        <li><a href="/ServletProjectGroup1_war_exploded/test?action=questions">Questions</a> </li>
    </ul>
</div>
<div>
    <h3>Main part :</h3>

    <%String includedPage = (String)session.getAttribute("includedPage");%>
        <% if(includedPage != null ) {%>
                <jsp:include page = "<%= includedPage%>" />
        <% } %>
</div>
</body>
</html>
