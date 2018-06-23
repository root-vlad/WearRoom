<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Содержимое базы</title>
    <link href="<c:url value='/main.css'/>" rel="stylesheet" type="text/css">
</head>
<body>
<ul>
    <li><a href="/init.do"/>Заполнить заново</a></li>
    <li><a href="/wears.do"/>Посмотреть весь гардероб</a></li>
    <li><a href="/fashionWears.do"/>Посмотреть модные вещички</a></li>
</ul>

<h1>Головные уборы:</h1>
<form action="/addHeadwear.do">
    <input type="submit" value="Добавить головной убор "/>
    <input name="color" value="цвет"/>
    <input name="name" value="имя"/>
</form>
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
<form action="/addFootwear.do">
    <input type="submit" value="Добавить обувь"/>
    <input name="color" value="цвет"/>
    <input name="name" value="имя"/>
</form>
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
<form action="/addOuterwear.do">
    <input type="submit" value="Добавить верхнюю одежду"/>
    <input name="color" value="цвет"/>
    <input name="name" value="имя"/>
</form>
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
<form action="/addUnderwear.do">
    <input type="submit" value="Добавить нижнюю одежду"/>
    <input name="color" value="цвет"/>
    <input name="name" value="имя"/>
</form>
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