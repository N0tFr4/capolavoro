<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="MessageBundle" scope="session" />
<!DOCTYPE html>
<html>
    <head>
        <title><fmt:message key="title"></fmt:message></title>
        <meta charset="ISO-8859-1">
        <link rel="stylesheet" href="css/index.css" type="text/css" />
        <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
        <link rel="shortcut icon" href="immagini/favicon.jpeg" />
    </head>

    <body>
        <h1 class="title"><fmt:message key="title"></fmt:message></h1>
        <div class="form-container">
            <div class="logo-container">
              <fmt:message key="welcome"></fmt:message>
            </div>
            <div class="line"></div>
            <form class="form" id="loginForm" accept-charset="utf-8">
              <div class="form-group">
                <label for="username"><fmt:message key="username"></fmt:message></label>
                <input required placeholder="<fmt:message key="enterUser"></fmt:message>" name="username" id="username" type="text">
              </div>
      
              <div class="form-group">
                <label for="password"><fmt:message key="password"></fmt:message></label>
                <input required name="password" placeholder="<fmt:message key="enterPass"></fmt:message>" id="password" type="password">
              </div>
      
              <button type="submit" class="form-submit-btn"><fmt:message key="signin"></fmt:message></button>
            </form>
      
            <p class="signup-link">
              <fmt:message key="question"></fmt:message>
              <a class="signup-link link" href="signup.jsp"><fmt:message key="signup"></fmt:message></a>
            </p>
          </div>
          
        <script type="text/javascript" src="js/jquery-3.7.1.min.js"></script>
        <script type="text/javascript" src="js/index.js"></script>
          
    </body>
</html>