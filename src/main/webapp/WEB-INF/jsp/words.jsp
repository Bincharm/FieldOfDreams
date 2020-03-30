        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

        <!DOCTYPE html>
        <html>
        <head>
        <meta charset="utf-8">
        <title>Log in with your account</title>
        <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
        </head>

        <body>
        <div>
        <p>

        <table>
        <thead>
        <th>ID</th>
        <th>Word</th>
        <th>New word</th>
        <th>Delete</th>
        </thead>
        <c:forEach items="${allWords}" var="word">
            <tr>
            <td>${word.id}</td>
            <td>${word.word}</td>
            <%--<td>${word.password}</td>--%>
            <%--<td>--%>
            <%--<c:forEach items="${user.roles}" var="role">${role.name}; </c:forEach>--%>
            <%--</td>--%>

            <td>
            <%--<form:form action="${pageContext.request.contextPath}/words" method="POST" modelAttribute="words">--%>
                <%--<form:input path="word" />--%>
                <%--<input type="submit" value="save"/>--%>
            <%--</form:form>--%>

            <form action="${pageContext.request.contextPath}/words" method="post">
            <input type="text" name="word"/>
            <input type="hidden" name="action" value="save"/>
            <button type="submit">Save</button>
            </form>

            </td>

            <td>
            <form action="${pageContext.request.contextPath}/words/delete" method="delete">
                <input type="hidden" name="wordId" value="${word.id}"/>
                <button type="submit">Delete</button>
            </form>

            </td>


            </tr>
        </c:forEach>
        </table>

<%--        <div>
        <form:form method="POST" modelAttribute="wordForm">
            <h2>Add new word</h2>
            <div>
            <form:input type="text" path="word" placeholder="Word"
                        autofocus="true"></form:input>
            <form:errors path="word"></form:errors>
            ${wordError}
            </div>

            <button type="submit">Добавить слово</button>
        </form:form>
        </div>
--%>
        <a href="/">Главная</a>
        </div>
        </body>
        </html>