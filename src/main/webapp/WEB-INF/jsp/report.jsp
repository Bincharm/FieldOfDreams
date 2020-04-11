    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

        <!DOCTYPE html>
        <html>
        <head>
            <meta charset="utf-8">
            <title>Report</title>
            <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        </head>

        <body>
        <div>

        <table class="table table-striped table-hover">
        <thead class="thead-dark">
        <c:if test="${isAdmin}"><th>Username</th></c:if>
        <th>Game ID</th>
        <th>Word</th>
        <th>Date</th>
        <th>Result</th>
        <th>Details</th>
        </thead>
        <c:forEach items="${allUsersGames}" var="game">
            <tr>
                <c:if test="${isAdmin}"><td>${game.username}</td></c:if>

                <td>${game.gameId}</td>
                <td>${game.word}</td>
                <td>${game.gameDate}</td>
                <td>${game.isWin ? "win" :"lose" }</td>
                <td><a href="/report/reportDetails/${game.gameId}">game attempts</a></td>

            </tr>
        </c:forEach>
        </table>





        <a href="/">Главная</a>
        </div>
        </body>
        </html>