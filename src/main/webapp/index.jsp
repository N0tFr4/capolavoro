<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title> in&out </title>
        <meta charset="ISO-8859-1">
        <link rel="stylesheet" href="css/index.css" type="text/css" />
        <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
        <link rel="shortcut icon" href="immagini/favicon.jpeg" />
    </head>

    <body>
        <h1 class="title"> In&Out </h1>
        <div class="form-container">
            <div class="logo-container">
              Welcome Back!
            </div>
            <div class="line"></div>
            <form class="form" id="loginForm" accept-charset="utf-8">
              <div class="form-group">
                <label for="username">Username</label>
                <input required placeholder="Enter your username" name="username" id="username" type="text">
              </div>
      
              <div class="form-group">
                <label for="password">Password</label>
                <input required name="password" placeholder="Enter your password" id="password" type="password">
              </div>
      
              <button type="submit" class="form-submit-btn">Sign In</button>
            </form>
      
            <p class="signup-link">
              Don't have an account?
              <a class="signup-link link" href="signup.jsp"> Sign up now</a>
            </p>
          </div>
          
        <script type="text/javascript" src="js/jquery-3.7.1.min.js"></script>
        <script type="text/javascript" src="js/index.js"></script>
          
          
    </body>

</html>