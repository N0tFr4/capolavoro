<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title> in&out </title>
        <link rel="stylesheet" href="css/admin.css" type="text/css" />
        <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
        <link rel="shortcut icon" href="favicon.jpeg" />
    </head>

    <body>
        <header>
            <h1 class="title"> In&Out </h1>
            <nav>
                <ul class="links">
                    <li><a href="admin.jsp">Home</a></li>
                    <li><a href="info.jsp">Your Account</a></li>
                    <li><a href="/capolavoro2/logoutsvlt">Logout</a></li>
                </ul>
            </nav>
        </header>
        
        <div class="div-container">
            <div class="output_container">
                <div class="out_area">
                    <table id="lstIncome" class="table">
                        <thead>
                            <tr>
                                <th>Amount</th>
                                <th>Date</th>
                                <th>Sender</th>
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
                            </tr>
                        </thead>
                        <tbody id="old_tbody_outcome">
                        
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <script src="js/admin.js"></script>

    </body>
</html>