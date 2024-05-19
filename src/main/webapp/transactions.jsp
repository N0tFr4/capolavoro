<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="acquafredda.pice.capolavoro2.pojo.Transaction"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="MessageBundle" scope="session" />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title><fmt:message key="title"></fmt:message></title>
		<link rel="stylesheet" href="css/transactions.css" type="text/css" />
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
	        
		 <div class="div-container">
	            <div class="output_container">
	                <div class="out_area">
	                    <table id="lstIncome" class="table">
	                        <thead>
	                            <tr>
	                                <th><fmt:message key="tableAmount"></fmt:message></th>
	                                <th><fmt:message key="tableDate"></fmt:message></th>
	                                <th><fmt:message key="tableSender"></fmt:message></th>
	                                <th><fmt:message key="tableDelete"></fmt:message></th>
	                                <th><fmt:message key="tableModify"></fmt:message></th>
	                            </tr>
	                        </thead>
	                        <tbody id="old_tbody_income">
	                        	 <c:forEach items="${TransactionsListIncome}" var="transaction">
	                                <tr id="tr ${transaction.transaction_id }">
	                                	<td>${transaction.transaction_amount }</td>
	                                    <td>${transaction.transaction_date }</td>
	                                    <td>${transaction.transaction_sender }</td>
	                                    <td>
	                                        <button class="btnDelete" name="bottone" onclick="deleteTransaction(${transaction.transaction_id})" ><fmt:message key="btnDelete"></fmt:message></button>
	                                    </td>
	                                    <td>
	                                        <button class="btnModifyIncome" data-id="${transaction.transaction_id}" data-amount="${transaction.transaction_amount}" data-date="${transaction.transaction_date}" data-sender="${transaction.transaction_sender}"><fmt:message key="btnModify"></fmt:message></button>
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
	                                <th><fmt:message key="tableAmount"></fmt:message></th>
	                                <th><fmt:message key="tableDate"></fmt:message></th>
	                                <th><fmt:message key="tableReason"></fmt:message></th>
	                                <th><fmt:message key="tableDelete"></fmt:message></th>
	                                <th><fmt:message key="tableModify"></fmt:message></th>
	                            </tr>
	                        </thead>
	                        <tbody id="old_tbody_outcome">
	                        	<c:forEach items="${TransactionsListOutcome}" var="transaction">
	                                <tr id="tr ${transaction.transaction_id }">
	                                	<td>${transaction.transaction_amount }</td>
	                                    <td>${transaction.transaction_date }</td>
	                                    <td>${transaction.transaction_reason }</td>
	                                    <td>
	                                        <button class="btnDelete" name="bottone" onclick="deleteTransaction(${transaction.transaction_id})" ><fmt:message key="btnDelete"></fmt:message></button>
	                                    </td>
	                                    <td>
	                                        <button class="btnModifyOutcome" data-id="${transaction.transaction_id}" data-amount="${transaction.transaction_amount}" data-date="${transaction.transaction_date}" data-sender="${transaction.transaction_reason}"><fmt:message key="btnModify"></fmt:message></button>
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
	                    <button type="submit" class="form-submit-btn"><fmt:message key="btnModifyForm"></fmt:message></button>
	                </form>
	            </div>
	        </div>
	        
	        <script type="text/javascript" src="js/jquery-3.7.1.min.js"></script>
	        <script type="text/javascript" src="js/transactions.js"></script>
	        
	</body>
</html>