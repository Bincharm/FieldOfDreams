    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

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
        <th>Action</th>
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
            <form action="${pageContext.request.contextPath}/words" method="post">
            <input type="text" name="wordId" value="${word.id}"/>
            <input type="submit" name="action" value="save"/>
            <button type="submit">Add</button>
            </form>

            </td>

            <td>
            <form action="${pageContext.request.contextPath}/words" method="post">
            <input type="hidden" name="wordId" value="${word.id}"/>
            <input type="hidden" name="action" value="delete"/>
            <button type="submit">Delete</button>
            </form>

            </td>


            </tr>
        </c:forEach>
        </table>

        <a href="/">Главная</a>
        </div>
        </body>
        </html>