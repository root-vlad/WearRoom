<%--
  Created by IntelliJ IDEA.
  User: vgorokhov
  Date: 17.06.2018
  Time: 9:02
  To change this template use File | Settings | File Templates.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Содержимое базы</title>
    <link href="<c:url value='main.css'/>" rel="stylesheet" type="text/css">
</head>
<body>
<ul>
    <li><a href="init.do"/>Заполнить заново</a></li>
    <%--<li><a href="addcat.do"/>Добавить кошку</a></li>--%>
    <%--<li><a href="addPerson.do"/>Добавить человека</a></li>--%>
    <li><a href="wears.do"/>Просто посмотреть</a></li>
</ul>

<h1>Головные уборы:</h1>
<table><tbody>
<c:forEach var="x" items="${headwears}">
<tr>
    <td>${x.id}</td>
    <td>${x.name}</td>
    <td>${x.color}</td>
</tr>
</c:forEach>
    <tbody></table>

<h1>Обувь:</h1>
<table><tbody>
<c:forEach var="x" items="${footwears}">
<tr>
    <td>${x.id}</td>
    <td>${x.name}</td>
    <td>${x.color}</td>
</tr>
</c:forEach>
    <tbody></table>

<h1>Верхняя одежда:</h1>
<table><tbody>
<c:forEach var="x" items="${outerwears}">
<tr>
    <td>${x.id}</td>
    <td>${x.name}</td>
    <td>${x.color}</td>
</tr>
</c:forEach>
    <tbody></table>

<h1>Нижняя одежда:</h1>
<table><tbody>
<c:forEach var="x" items="${underwears}">
<tr>
    <td>${x.id}</td>
    <td>${x.name}</td>
    <td>${x.color}</td>
</tr>
</c:forEach>
    <tbody></table>

</body>
</html>



<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>

<%--</body>--%>
<%--</html>--%>
