    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@page import="java.util.Optional" %>

        <!DOCTYPE html>
        <html>
        <head>
            <meta charset="utf-8">
            <title>Field of dreams</title>
            <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
            <script src="../../resources/js/main.js"></script>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        </head>

        <body>
        <div>
        <p>


        <table class="table">
        <thead class="thead-dark">
        <th>New game</th>
        </thead>

        <tr>
        <td>
        <form action="${pageContext.request.contextPath}/game" method="post">
        <input type="hidden" name="game"/>
        <input type="hidden" name="action" value="save"/>
        <button type="submit">Start new game</button>
        </form>
        </td>
        </tr>


        </table>

            <p>${wordTask}</p>

        <table class="table" id="encryptedWord">
         <tr>
         <%
            int wLength;
            if (request.getAttribute("wordLength") == null) wLength = 0;
            else wLength = (int)request.getAttribute("wordLength");
         %>
            <%      for(int col=0; col<wLength; col++) { %>
        <td style="height:20px; width:10px; text-align:center" id="col<%=col%>"> *
        </td>
            <% } %>
        </tr>

        </table>

        <p>
        <p>

        <table>

        <tr>
        <td>
<%--<3 ya--%>
        <input type="text" name="letter" id="inputLetter"/>
        <input type="hidden" name="wordId" value="${wordId}" id="wordId"/>
        <input type="hidden" name="gameId" value="${gameId}" id="gameId"/>
        <input type="hidden" name="action" value="saveLetter"/>
        <button type="button" id="btnCheckLetter" onclick="checkLetter()">Enter a letter/word</button>

        </td>
        </tr>


        </table>

        <p id="winResult"></p>
        <a href="/">Главная</a>
        </div>
        </body>
        </html>