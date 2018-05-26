<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Notes List</title>
    <base href="${pageContext.request.contextPath}/"/>
</head>
<body>
    <a href="/add">Add</a>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Title</th>
            <th>Description</th>
            <th>Data</th>
            <th>Made</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
    <c:forEach items="${notes}" var="note">
        <jsp:useBean id="note" scope="page" type="noteManager.model.Note"/>
        <tr>
            <td>${note.title}</td>
            <td>${note.description}</td>
            <td>${note.dateTime}</td>
            <td>${note.made}</td>
            <td><a href="/delete/${note.id}">delete</a> </td>
            <td><a href="/update/${note.id}">update</a> </td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>
