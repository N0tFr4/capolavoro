<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="acquafredda.pice.capolavoro2.pojo.User"%>
<!DOCTYPE html>
<html>
    <head>
        <title> in&out </title>
        <meta charset="ISO-8859-1">
        <link rel="stylesheet" href="css/info.css" type="text/css" />
        <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
        <link rel="shortcut icon" href="immagini/favicon.jpeg" />
    </head>

    <body>
    	
    	<header>
            <h1 class="title"> In&Out </h1>
            <nav>
                <ul class="links">
                    <li><a href="home.jsp">Home</a></li>
                    <li><a href="selectalltransactionssvlt">Your Transactions</a></li>
                    <li><a href="userinfosvlt">Your Account</a></li>
                    <li><a href="logoutsvlt">Logout</a></li>
                </ul>
            </nav>
     	</header>
     	
        <div class="form-container">
            <div class="logo-container">
             Here are your details
            </div>
            <div class="line"></div>
            <form class="form" accept-charset="utf-8" id="modUser">
              <div class="form-group">
                <label for="name">Name</label>
                <input id="firstname" name="firstname" required placeholder="Enter your name" type="text" value = "${user.user_name}">
              </div>
              
              <div class="form-group">
                <label for="surname">Surname</label>
                <input required placeholder="Enter your surname" name="surname" id="surname" type="text" value = "${user.user_surname}">
              </div>

              <div class="form-group">
                <label for="phone_number">Phone Number</label>
                <input required placeholder="Enter your phone number" name="phone_number" id="phone_number" type="text" value = "${user.user_phone_number}">
              </div>

              <div class="form-group">
                <label for="username">Username</label>
                <input required placeholder="Enter your username" name="username" id="username" type="text" disabled value = "${user.user_nickname}">
              </div>
      
              <button type="submit" class="form-submit-btn">Modify Account</button>
            </form>
      
          </div>
          
          <script type="text/javascript" src="js/jquery-3.7.1.min.js"></script>
          <script type="text/javascript" src="js/info.js"></script>
    </body>
</html>