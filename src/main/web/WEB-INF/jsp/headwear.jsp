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
    <!-- Latest compiled and minified CSS & JS -->
    <link rel="stylesheet" media="screen" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <link href="<c:url value='main.css'/>" rel="stylesheet" type="text/css">
</head>
<body>
<ul>
    <li><a href="init.do"/>Заполнить заново</a></li>
    <li><a href="wears.do"/>Просто посмотреть</a></li>
</ul>

<div class="page-header">
    <h1>Гардероб<small> главная страница </small></h1>
</div>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Выбери тип одежды</h3>
    </div>
    <div class="panel-body">
        <div class="btn-toolbar" role="toolbar">
            <div class="btn-group">
                <form action="WEB-INF/jsp/headwear.jsp/">
                    <button type="submit" class="btn btn-default" style="width: 150px; height: 35px" >Головные уборы</button>
                </form>
                <form action="WEB-INF/jsp/footwear.jsp/">
                    <button type="submit" class="btn btn-default" style="width: 150px; height: 35px">Обувь</button>
                </form>
                <form action="WEB-INF/jsp/outerwear.jsp/">
                    <button type="submit" class="btn btn-default" style="width: 150px; height: 35px">Верхняя одежда</button>
                </form>
                <form action="WEB-INF/jsp/underwear.jsp/">
                    <button type="submit" class="btn btn-default" style="width: 150px; height: 35px">Нижняя одежда</button>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Выбери тип режима</h3>
    </div>
    <div class="panel-body">
        <div class="btn-toolbar" role="toolbar">
            <div class="btn-group">
                <form action="/src/main/web/init.do">
                    <button type="submit" class="btn btn-default" style="width: 150px; height: 35px" >Заполнить заново</button>
                </form>
                <form action="/src/main/web/wears.do">
                    <button type="submit" class="btn btn-default" style="width: 150px; height: 35px">Просто посмотреть</button>
                </form>
                <form action="WEB-INF/jsp/outerwear.jsp/">
                    <button type="submit" class="btn btn-default" style="width: 150px; height: 35px">Верхняя одежда</button>
                </form>
                <form action="WEB-INF/jsp/underwear.jsp/">
                    <button type="submit" class="btn btn-default" style="width: 150px; height: 35px">Нижняя одежда</button>
                </form>
            </div>
        </div>
    </div>
</div>

<h1>Головные уборы:</h1>
<table class="table table-hover">
    <thead>
    <tr>
        <th>Головные уборы:</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="x" items="${headwears}">
    <tr>
        <td>${x.id}</td>
        <td>${x.name}</td>
        <td>${x.color}</td>
    </tr>
    </c:forEach>
    <tbody>
</table>


</body>
</html>

