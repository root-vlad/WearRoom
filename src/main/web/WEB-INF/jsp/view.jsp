<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>WearRoom</title>
    <!-- Latest compiled and minified CSS & JS -->
    <link rel="stylesheet" media="screen" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <!--<link href="<c:url value='main.css'/>" rel="stylesheet" type="text/css">-->

</head>
<body>
<%--<security:authentication var="user" property="principal" />--%>
<%--<security:authentication var="username" property="principal.username" />--%>
<%--<h1>Hello, ${user}!</h1>--%>
<%--<h1>Hello, ${username}!</h1>--%>
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
                <form action="headwears.do">
                    <button type="submit" class="btn btn-default" style="width: 150px; height: 35px" >Головные уборы</button>
                </form>
                <form action="footwears.do">
                    <button type="submit" class="btn btn-default" style="width: 150px; height: 35px">Обувь</button>
                </form>
                <form action="outerwears.do">
                    <button type="submit" class="btn btn-default" style="width: 150px; height: 35px">Верхняя одежда</button>
                </form>
                <form action="underwears.do">
                    <button type="submit" class="btn btn-default" style="width: 150px; height: 35px">Нижняя одежда</button>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>