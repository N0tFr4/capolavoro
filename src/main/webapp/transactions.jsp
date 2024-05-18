<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="acquafredda.pice.capolavoro2.pojo.Transaction"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>In&Out</title>
		<link rel="stylesheet" href="css/transactions.css" type="text/css" />
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
                    <li><a href="info.jsp">Your Account</a></li>
                    <li><a href="logoutsvlt">Logout</a></li>
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
                                <th>Delete</th>
                                <th>Modify</th>
                            </tr>
                        </thead>
                        <tbody id="old_tbody_income">
                        	 <c:forEach items="${TransactionsListIncome}" var="transaction">
                                <tr id="tr ${transaction.transaction_id }">
                                	<td>${transaction.transaction_amount }</td>
                                    <td>${transaction.transaction_date }</td>
                                    <td>${transaction.transaction_sender }</td>
                                    <td>
                                        <button class="btnDelete" name="bottone" onclick="deleteTransaction(${transaction.transaction_id})" >DELETE</button>
                                    </td>
                                    <td>
                                        <button class="btnModifyIncome" data-id="${transaction.transaction_id}" data-amount="${transaction.transaction_amount}" data-date="${transaction.transaction_date}" data-sender="${transaction.transaction_sender}">MODIFY</button>
                                    </td>
                                 </tr>
                            </c:forEach>
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
                        	<c:forEach items="${TransactionsListOutcome}" var="transaction">
                                <tr id="tr ${transaction.transaction_id }">
                                	<td>${transaction.transaction_amount }</td>
                                    <td>${transaction.transaction_date }</td>
                                    <td>${transaction.transaction_reason }</td>
                                    <td>
                                        <button class="btnDelete" name="bottone" onclick="deleteTransaction(${transaction.transaction_id})" >DELETE</button>
                                    </td>
                                    <td>
                                        <button class="btnModifyOutcome" data-id="${transaction.transaction_id}" data-amount="${transaction.transaction_amount}" data-date="${transaction.transaction_date}" data-sender="${transaction.transaction_reason}">MODIFY</button>
                                    </td>
                                 </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div id="overlay" class="overlay">
            <div id="form-container" class="form-container">
                <form class="form" accept-charset="utf-8" id="modTrans">
                <input type="hidden" id="transaction-id" name="transaction-id" value="">
                    <div class="form-group">
                      <label for="amount">Amount</label>
                      <input required placeholder="How much?" name="amount" id="amount" type="text">
                    </div>
                    <div class="form-group">
                      <label for="date">Date</label>
                      <input required name="date" placeholder="When?" id="date" type="date">
                    </div>
                    <div class="form-group">
                        <label for="sender">Sender (ONLY FOR AN INCOME!!!)</label>
                        <input name="sender" placeholder="Who send you this?" id="sender" type="text">
                    </div>
                    <div class="form-group">
                        <label for="reason">Reason (ONLY FOR AN OUTCOME!!!)</label>
                        <input name="reason" placeholder="Why?" id="reason" type="text">
                    </div>
                    <button type="submit" class="form-submit-btn">Modify</button>
                </form>
            </div>
        </div>
        
        <script type="text/javascript" src="js/jquery-3.7.1.min.js"></script>
        <script type="text/javascript" src="js/transactions.js"></script>
</body>
</html>