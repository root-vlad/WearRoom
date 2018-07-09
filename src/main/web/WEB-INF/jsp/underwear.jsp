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
</head>
<body>
<div class="page-header">
    <h1>Гардероб<small> Нижняя одежда </small></h1>
</div>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Выбери тип одежды</h3>
    </div>
    <div class="panel-body">
        <div class="btn-toolbar" role="toolbar">
            <div class="btn-group">
                <form action="headwears.do">
                    <button type="submit" class="btn btn-default" style="width: 200px; height: 35px" >Головные уборы</button>
                </form>
                <form action="footwears.do">
                    <button type="submit" class="btn btn-default" style="width: 200px; height: 35px">Обувь</button>
                </form>
                <form action="outerwears.do">
                    <button type="submit" class="btn btn-default" style="width: 200px; height: 35px">Верхняя одежда</button>
                </form>
                <form action="underwears.do">
                    <button type="submit" class="btn btn-default" style="width: 200px; height: 35px">Нижняя одежда</button>
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
                <%--<form action="init.do">--%>
                <%--<button type="submit" class="btn btn-default" style="width: 255px; height: 35px" >Заполнить заново</button>--%>
            <%--</form>--%>
                <%--<form action="wears.do">--%>
                    <%--<button type="submit" class="btn btn-default" style="width: 255px; height: 35px">Просто посмотреть</button>--%>
                <%--</form>--%>
                    <form action="addUnderwear.do">
                        <button type="submit" class="btn btn-default" style="width: 255px; height: 35px">Добавить нижнюю одежду</button>
                        <input type="text" name="name" id="headwearName" class="form-control" value="Имя1" title="Имя2" required="required">
                        <input type="text" name="color" id="headwearColor" class="form-control" value="Цвет1" title="Цвет2" required="required">
                    </form>
                <form action="fashionUnderwears.do">
                    <button type="submit" class="btn btn-default" style="width: 255px; height: 35px">Модная нижняя одежда</button>
                </form>
            </div>
        </div>
    </div>
</div>

<table class="table table-hover">
    <thead>
    <tr>
        <th>Нижняя одежда:</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="x" items="${underwears}">
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


