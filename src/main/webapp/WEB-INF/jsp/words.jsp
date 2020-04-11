        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

        <!DOCTYPE html>
        <html>
        <head>
            <meta charset="utf-8">
            <title>Add a new word for the game</title>
            <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        </head>

        <body>
        <div>
        <p>

        <table class="table table-striped table-hover">
        <thead class="thead-dark">
        <th>ID</th>
        <th>Word</th>
        <th>Task</th>
        <th>Delete</th>
        </thead>
        <c:forEach items="${allWords}" var="word">
            <tr>
            <td>${word.id}</td>
            <td>${word.word}</td>
            <td>${word.task}</td>
            <%--<td>${word.password}</td>--%>
            <%--<td>--%>
            <%--<c:forEach items="${user.roles}" var="role">${role.name}; </c:forEach>--%>
            <%--</td>--%>

            <%--<td>--%>
            <%--<form:form action="${pageContext.request.contextPath}/words" method="POST" modelAttribute="words">--%>
                <%--<form:input path="word" />--%>
                <%--<input type="submit" value="save"/>--%>
            <%--</form:form>--%>



            <%--</td>--%>

            <td>
            <form action="${pageContext.request.contextPath}/words/delete" method="delete">
                <input type="hidden" name="wordId" value="${word.id}"/>
                <button type="submit">Delete</button>
            </form>

            </td>


            </tr>
        </c:forEach>
        </table>


        <table class="table table-striped table-hover">
            <thead thead-dark>
                <th>New word</th>
                <th>Task</th>
                <th>Action</th>
            </thead>

            <tr>
                <td>
                    <form action="${pageContext.request.contextPath}/words" method="post">
                    <input type="text" name="word"/>
            </td>
            <td>
                    <input type="text" name="task"/>
                    <input type="hidden" name="action" value="save"/>
            </td>
            <td>
                    <button type="submit">Save</button>
                    </form>
                </td>
            </tr>
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