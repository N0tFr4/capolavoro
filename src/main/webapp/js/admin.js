/**
 * 


fillTables();

async function fillTables() {

	const response = await fetch('NOMEDELLASERVLET');

	var transactionJSON = await response.json();

	var transactions = transactionJSON["array"];

	var new_tbody_income = document.createElement('tbody');
	var old_tbody_income = document.getElementById('old_tbody_income');

	var new_tbody_outcome = document.createElement('tbody');
	var old_tbody_outcome = document.getElementById('old_tbody_outcome');

	var incomeTable = document.getElementById('lstIncome');
	var outcomeTable = document.getElementById('lstOutcome');


	for (const transaction of transactions) {

		var type = transaction.type;
		var id = transaction.id;
		var amount = transaction.amount;
		var date = transaction.date;

		if (type == "income") {
			var sender = transaction.sender;

			const row = document.createElement("tr");
			const tdAmount = document.createElement("td");
			const tdSender = document.createElement("td");
			const tdDate = document.createElement("td");

			tdAmount.innerHTML = amount;
			tdSender.innerHTML = sender;
			tdDate.innerHTML = date;


			row.appendChild(tdAmount);
			row.appendChild(tdDate);
			row.appendChild(tdSender);

			new_tbody_income.appendChild(row);

		} else {
			var reason = transaction.reason;

			const row = document.createElement("tr");
			const tdAmount = document.createElement("td");
			const tdReason = document.createElement("td");
			const tdDate = document.createElement("td");

			tdAmount.innerHTML = amount;
			tdReason.innerHTML = reason;
			tdDate.innerHTML = date;


			row.appendChild(tdAmount);
			row.appendChild(tdDate);
			row.appendChild(tdReason);

			old_tbody_outcome.appendChild(row);
		}

	}

	incomeTable.replaceChild(new_tbody_income, old_tbody_income);
	new_tbody_income.id = 'old_tbody_income';

	outcomeTable.replaceChild(new_tbody_outcome, old_tbody_outcome);
	new_tbody_outcome.id = 'old_tbody_outcome';
} */