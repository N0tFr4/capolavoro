<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title> in&out </title>
        <meta charset="ISO-8859-1">
        <link rel="stylesheet" href="css/signup.css" type="text/css" />
        <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
        <link rel="shortcut icon" href="immagini/favicon.jpeg" />
    </head>

    <body>
        <div class="form-container">
            <div class="logo-container">
              Create Your Account!
            </div>
            <div class="line"></div>
            <form class="form" accept-charset="utf-8" id="insertForm">
              <div class="form-group">
                <label for="name">Name</label>
                <input id="firstname" name="firstname" required placeholder="Enter your name" type="text">
              </div>
              
              <div class="form-group">
                <label for="surname">Surname</label>
                <input required placeholder="Enter your surname" name="surname" id="surname" type="text">
              </div>

              <div class="form-group">
                <label for="phone_number">Phone Number</label>
                <input required placeholder="Enter your phone number" name="phone_number" id="phone_number" type="text">
              </div>

              <div class="form-group">
                <label for="username">Username</label>
                <input required placeholder="Enter your username" name="username" id="username" type="text">
              </div>

              <div class="form-group">
                <label for="password">Password</label>
                <input required name="password" placeholder="Enter your password" id="password" type="password">
              </div>
      
              <button type="submit" class="form-submit-btn">Create Account</button>
            </form>
      
            <p class="login-link">
              Already have an account?
              <a class="login-link link" href="index.jsp"> Log In now</a>
            </p>
          </div>
          
        <script type="text/javascript" src="js/jquery-3.7.1.min.js"></script>
        <script type="text/javascript" src="js/signup.js"></script>
          
    </body>
</html>