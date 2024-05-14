<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <%
    String username = (String) session.getAttribute("username");
    if (username != null) {
        //out.println("Benvenuto, " + username);
        if(username.equals("admin")){
        	response.sendRedirect("admin.jsp");
        }
    } else {
        response.sendRedirect("index.jsp"); // Se l'utente non è autenticato, reindirizzalo alla pagina di login
    }
%>
<!DOCTYPE html>
<html>
    <head>
    	<meta charset="ISO-8859-1">
        <title> in&out </title>
        <link rel="stylesheet" href="css/home.css" type="text/css" />
        <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
    </head>

    <body>
        <header>
            <h1 class="title"> In&Out </h1>
            <nav>
                <ul class="links">
                    <li><a href="home.jsp">Home</a></li>
                    <li><a href="info.jsp">Your Account</a></li>
                    <li><a href="/capolavoro2/logoutsvlt">Logout</a></li>
                </ul>
            </nav>
        </header>

        <div class="button-container">
            <button class="income" data-type="income">INCOME</button>
            <button class="outcome" data-type="outcome">OUTCOME</button>
        </div>

        <div id="overlay" class="overlay">
            <div id="form-container" class="form-container">
                <form class="form">
                    <div class="form-group" onsubmit="wrapper()">
                      <label for="amount">Amount</label>
                      <input required placeholder="How much?" name="amount" id="amount" type="text">
                    </div>
                    <div class="form-group">
                      <label for="date">Date</label>
                      <input required name="date" placeholder="When?" id="date" type="date">
                    </div>
                    <div class="form-group">
                        <label for="sender">Sender (ONLY FOR AN INCOME!!!)</label>
                        <input required="false" name="sender" placeholder="Who send you this?" id="sender" type="text">
                    </div>
                    <div class="form-group">
                        <label for="reason">Reason (ONLY FOR AN OUTCOME!!!)</label>
                        <input required name="reason" placeholder="Why?" id="reason" type="text">
                    </div>
                    <button type="submit" class="form-submit-btn">Add</button>
                </form>
            </div>
        </div>
        
        <div class="div-container">
            <div class="output_container">
                <div class="out_area">
                    <table id="lstIncome" class="table">
                        <thead>
                            <tr>
                                <th>Amount</th>
                                <th>Date</th>
                                <th>Sender</th>
                                <th>Delete</th>
                                <th>Modify</th>
                            </tr>
                        </thead>
                        <tbody id="old_tbody_income">
                        
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="output_container">
                <div class="out_area">
                    <table id="lstOutcome" class="table">
                        <thead>
                            <tr>
                                <th>Amount</th>
                                <th>Date</th>
                                <th>Reason</th>
                                <th>Delete</th>
                                <th>Modify</th>
                            </tr>
                        </thead>
                        <tbody id="old_tbody_outcome">
                        
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <script src="js/home.js"></script>
    </body>
</html>