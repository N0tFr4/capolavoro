<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="MessageBundle" scope="session" />
<!DOCTYPE html>
<html>
    <head>
        <title><fmt:message key="title"></fmt:message></title>
        <meta charset="ISO-8859-1">
        <link rel="stylesheet" href="css/signup.css" type="text/css" />
        <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
        <link rel="shortcut icon" href="immagini/favicon.jpeg" />
    </head>

    <body>
        <div class="form-container">
            <div class="logo-container">
              <fmt:message key="create"></fmt:message>
            </div>
            <div class="line"></div>
            <form class="form" accept-charset="utf-8" id="insertForm">
              <div class="form-group">
                <label for="name"><fmt:message key="name"></fmt:message></label>
                <input id="firstname" name="firstname" required placeholder="<fmt:message key="enterName"></fmt:message>" type="text">
              </div>
              
              <div class="form-group">
                <label for="surname"><fmt:message key="surname"></fmt:message></label>
                <input required placeholder="<fmt:message key="enterSurname"></fmt:message>" name="surname" id="surname" type="text">
              </div>

              <div class="form-group">
                <label for="phone_number"><fmt:message key="phoneNumber"></fmt:message></label>
                <input required placeholder="<fmt:message key="enterPhoneNumber"></fmt:message>" name="phone_number" id="phone_number" type="text">
              </div>

              <div class="form-group">
                <label for="username"><fmt:message key="username"></fmt:message></label>
                <input required placeholder="<fmt:message key="enterUser"></fmt:message>" name="username" id="username" type="text">
              </div>

              <div class="form-group">
                <label for="password"><fmt:message key="password"></fmt:message></label>
                <input required name="password" placeholder="<fmt:message key="enterPass"></fmt:message>" id="password" type="password">
              </div>
      
              <button type="submit" class="form-submit-btn"><fmt:message key="btnCreate"></fmt:message></button>
            </form>
      
            <p class="login-link">
              <fmt:message key="question2"></fmt:message>
              <a class="login-link link" href="index.jsp"><fmt:message key="login"></fmt:message></a>
            </p>
          </div>
          
        <script type="text/javascript" src="js/jquery-3.7.1.min.js"></script>
        <script type="text/javascript" src="js/signup.js"></script>
          
    </body>
</html>