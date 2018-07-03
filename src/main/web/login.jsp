<!DOCTYPE html>

<%@ page language= "java" contentType= "text/html; charset=UTF-8" pageEncoding= "UTF-8"%>
<%@ taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix= "spring" uri= "http://www.springframework.org/tags"%>
<%@ taglib prefix= "page" tagdir= "/WEB-INF/tags" %>
<%@ taglib prefix= "security" uri= "http://www.springframework.org/security/tags" %>

<html>
<head>
    <meta charset= "utf-8">
    <title>Login Page</title>
    <!-- Latest compiled and minified CSS & JS -->
    <link rel="stylesheet" media="screen" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <spring:url value= "/resources/css/bootstrap.css" var= "bootstrap" />
    <spring:url value= "/resources/css/signin.css" var= "signin" />
    <link href= "${bootstrap}" rel= "stylesheet" />
    <link href= "${signin}" rel= "stylesheet" />
</head>
<body>
<form name= "form" action= "/login" method= "post" class= "form-signin">
    <security:authorize access= "hasAnyRole('ROLE_ADMIN','ROLE_USER')" var= "isUSer"/>
    <font size= "2" color= "red">
        <c:if test= "${not isUSer}">
            <c:if test= "${empty param.error}">
                Вы не вошли
            </c:if>
        </c:if>
    </font>

    <font size= "2" color= "green">
        <c:if test= "${isUSer}">Вы вошли как:
            <security:authentication property= "principal.username"/> с ролью:
            <b><security:authentication property= "principal.authorities"/></b>
        </c:if>
    </font>
    <br/>
    <c:if test= "${not empty param.error}">
        <font size= "2" color= "red"><b>Неправильный логин или пароль</b></font>
    </c:if>

    <h2 class= "form-signin-heading">Пожалуйста войдите</h2>

    <label for= "inputEmail" class= "sr-only"><spring:message code= "username" text= "Имя"/></label>
    <input id= "username" class= "form-control" name= "username" value= "admin" required autofocus/>

    <label for= "inputPassword" class= "sr-only"><spring:message code= "password" text= "Пароль"/></label>
    <input type= "password" id= "password" class= "form-control" name= "password" value= "pass" required/>

    <div class= "checkbox">
        <label>
            <input type= "checkbox" id= "rememberme"  name= "_spring_security_remember_me"/>Запомнить меня
        </label>
    </div>
    <input type= "submit" value= "Войти" class= "btn btn-lg btn-primary btn-block" >
    <br/>
    <a href= "javascript:history.back()">Назад</a>

    <br /><br />
    <p>Доступные роли:</p>

    <b>ROLE_ADMIN</b> <br />
    Login:<span style= "color: royalblue">admin</span> Password: <span style= "color: royalblue">pass</span> <br />
    <b>ROLE_USER</b> <br />
    Login: <span style= "color: royalblue">user1</span> Password: <span style= "color: royalblue">1111</span> <br />
    Login: <span style= "color: blue">user2</span> Password: <span style= "color: blue">2222</span>
</form>
</body>

</html>