<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="acquafredda.pice.capolavoro2.pojo.User"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="MessageBundle" scope="session" />
<!DOCTYPE html>
<html>
    <head>
        <title><fmt:message key="title"></fmt:message></title>
        <meta charset="ISO-8859-1">
        <link rel="stylesheet" href="css/info.css" type="text/css" />
        <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
        <link rel="shortcut icon" href="immagini/favicon.jpeg" />
    </head>

    <body>
    	
    	<header>
            <h1 class="title"><fmt:message key="title"></fmt:message></h1>
            <nav>
                <ul class="links">
                    <li><a href="home.jsp"><fmt:message key="home"></fmt:message></a></li>
                    <li><a href="selectalltransactionssvlt"><fmt:message key="transactions"></fmt:message></a></li>
                    <li><a href="userinfosvlt"><fmt:message key="account"></fmt:message></a></li>
                    <li><a href="logoutsvlt"><fmt:message key="logout"></fmt:message></a></li>
                </ul>
            </nav>
     	</header>
     	
        <div class="form-container">
            <div class="logo-container">
             <fmt:message key="details"></fmt:message>
            </div>
            <div class="line"></div>
            <form class="form" accept-charset="utf-8" id="modUser">
              <div class="form-group">
                <label for="name"><fmt:message key="name"></fmt:message></label>
                <input id="firstname" name="firstname" required placeholder="<fmt:message key="enterName"></fmt:message>" type="text" value = "${user.user_name}">
              </div>
              
              <div class="form-group">
                <label for="surname"><fmt:message key="surname"></fmt:message></label>
                <input required placeholder="<fmt:message key="enterSurname"></fmt:message>" name="surname" id="surname" type="text" value = "${user.user_surname}">
              </div>

              <div class="form-group">
                <label for="phone_number"><fmt:message key="phoneNumber"></fmt:message></label>
                <input required placeholder="<fmt:message key="enterPhoneNumber"></fmt:message>" name="phone_number" id="phone_number" type="text" value = "${user.user_phone_number}">
              </div>

              <div class="form-group">
                <label for="username"><fmt:message key="username"></fmt:message></label>
                <input required name="username" id="username" type="text" disabled value = "${user.user_nickname}">
              </div>
      
              <button type="submit" class="form-submit-btn"><fmt:message key="btnModify"></fmt:message></button>
            </form>
          </div>
          
          <script type="text/javascript" src="js/jquery-3.7.1.min.js"></script>
          <script type="text/javascript" src="js/info.js"></script>
          
    </body>
</html>