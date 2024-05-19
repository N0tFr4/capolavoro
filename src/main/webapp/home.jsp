<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="MessageBundle" scope="session" />
<!DOCTYPE html>
<html>
    <head>
    	<meta charset="ISO-8859-1">
        <title><fmt:message key="title"></fmt:message></title>
        <link rel="stylesheet" href="css/home.css" type="text/css" />
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

        <div class="button-container">
            <button class="income" data-type="income"><fmt:message key="income"></fmt:message></button>
            <button class="outcome" data-type="outcome"><fmt:message key="outcome"></fmt:message></button>
        </div>

        <div id="overlay" class="overlay">
            <div id="form-container" class="form-container">
                <form class="form" accept-charset="utf-8" id="addTrans">
                    <div class="form-group">
                      <label for="amount"><fmt:message key="amount"></fmt:message></label>
                      <input required placeholder="<fmt:message key="placeHolderAmount"></fmt:message>" name="amount" id="amount" type="text">
                    </div>
                    <div class="form-group">
                      <label for="date"><fmt:message key="date"></fmt:message></label>
                      <input required name="date" id="date" type="date">
                    </div>
                    <div class="form-group">
                        <label for="sender"><fmt:message key="sender"></fmt:message></label>
                        <input name="sender" placeholder="<fmt:message key="placeHolderSender"></fmt:message>" id="sender" type="text">
                    </div>
                    <div class="form-group">
                        <label for="reason"><fmt:message key="reason"></fmt:message></label>
                        <input name="reason" placeholder="<fmt:message key="placeHolderReason"></fmt:message>" id="reason" type="text">
                    </div>
                    <button type="submit" class="form-submit-btn"><fmt:message key="btnAdd"></fmt:message></button>
                </form>
            </div>
        </div>
        
        <script type="text/javascript" src="js/jquery-3.7.1.min.js"></script>
        <script type="text/javascript" src="js/home.js"></script>
        
    </body>
</html>