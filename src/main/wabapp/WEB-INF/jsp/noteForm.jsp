<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Note Form</title>
    <base href="${pageContext.request.contextPath}/"/>
</head>
<body>
<jsp:useBean id="note" type="noteManager.model.Note" scope="request"/>
<form method="post" action="/">
    <input type="hidden" name="id" value="${note.id}">
    <dl>
        <dt>Title</dt>
        <dd><input type="text" value="${note.title}" name="title"></dd>
    </dl>
    <dl>
        <dt>Description</dt>
        <dd><input type="text" value="${note.description}" name="description" required></dd>
    </dl>
    <dl>
        <dt>Date</dt>
        <dd><input type="datetime-local" value="${note.dateTime}" name="dateTime" required></dd>
    </dl>
    <dl>
        <c:if test="${!note.isNew()}">
            <dt>Made</dt>
            <dd><input type="radio"  name="made"></dd>
        </c:if>
    </dl>
    <button type="submit">Save</button>
    <button onclick="window.history.back()" type="button">Cancel</button>
</form>
</body>
</html>
