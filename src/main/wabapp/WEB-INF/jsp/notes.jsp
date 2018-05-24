<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Title</th>
            <th>Description</th>
            <th>Data</th>
            <th>Made</th>
        </tr>
        </thead>
    <c:forEach items="${notes}" var="note">
        <jsp:useBean id="note" scope="page" type="noteManager.model.Note"/>
        <tr>
            <td>${note.title}</td>
            <td>${note.description}</td>
            <td>${note.dateTime}</td>
            <td>${note.made}</td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>
