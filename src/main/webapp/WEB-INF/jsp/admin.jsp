<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Log in with your account</title>
  <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>

<body>
<div>
  <table class="table table-striped table-hover">
    <thead>
    <th>ID</th>
    <th>UserName</th>
    <th>Roles</th>
    </thead>
    <c:forEach items="${allUsers}" var="user">
      <tr>
        <td>${user.id}</td>
        <td>${user.username}</td>
        <td>
          <c:forEach items="${user.roles}" var="role">${role.name}; </c:forEach>
        </td>
        <td>
          <form action="${pageContext.request.contextPath}/admin" method="post">
            <input type="hidden" name="userId" value="${user.id}"/>
            <input type="hidden" name="action" value="delete"/>
            <button type="submit">Delete</button>
          </form>

        </td>

      </tr>
    </c:forEach>
  </table>
  <p>

  <table>
    <thead>
    <th>ID</th>
    <th>Word</th>
    <th>Password</th>
    <th>Roles</th>
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
          <form action="${pageContext.request.contextPath}/admin" method="post">
            <input type="hidden" name="wordId" value="${word.id}"/>
            <input type="hidden" name="action" value="save"/>
            <button type="submit">Add</button>
          </form>

        </td>

        <td>
          <form action="${pageContext.request.contextPath}/admin" method="post">
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