
//fillTables();
var type = "";

async function wrapper() {
	await addTransaction();
	//await fillTables();
}

document.getElementById("amount").addEventListener("input", function(event) {
	let valore = event.target.value;
	event.target.value = valore.replace(/\D/g, '');
});


document.addEventListener("DOMContentLoaded", function() {
	var incomeButton = document.querySelector(".income");
	var outcomeButton = document.querySelector(".outcome");
	var overlay = document.getElementById("overlay");

	incomeButton.addEventListener("click", function() {
		showForm();
		type = incomeButton.getAttribute('data-type');
	});

	outcomeButton.addEventListener("click", function() {
		showForm();
		type = incomeButton.getAttribute('data-type');
	});

	function showForm() {
		overlay.style.display = "block";
	}

	overlay.addEventListener("click", function(event) {
		if (event.target === overlay) {
			closeForm();
		}
	});

	function closeForm() {
		overlay.style.display = "none";
	}
});

/*async function addTransaction() {
	var amount = document.getElementById('amount').value;
	var date = document.getElementById('date').value;
	var sender = document.getElementById('sender').value;
	var reason = document.getElementById('reason').value;

	document.getElementById('amount').value = "";
	document.getElementById('date').value = "";
	document.getElementById('sender').value = "";
	document.getElementById('reason').value = "";

	var options = {
		method: 'POST'
	};
	
	try {
		var url = `inserttransactionsvlt?amount=${amount}&date=${date}&type=${type}`;
		
		if (type === "income") {
			console.log("tipo INCOME");
			url += `&sender=${sender}`;
		} else {
			console.log("tipo OUTCOME");
			url += `&reason=${reason}`;
		}
		
		var response = await fetch(url, options);
		
		if (response.ok) {
			alert('Transaction successfully added!');
			window.location.replace("home.jsp");
		} else {
			alert('There was an error during the adding of the transaction.');
		}
	} catch (error) {
		console.error('Network or server error:', error);
		alert('There was a network or server error.');
	}
}*/

async function addTransaction(){
	
	$.ajax({
		url: 'inserttransactionsvlt',
		type: 'POST',
		data:{
			amount: $("#amount").val(),
			date: $("#date").val(),
			sender: $("#sender").val(),
			reason: $("#reason").val(),
			type: type
		},
		async: false,
		success: function() {
			document.getElementById('amount').value = "";
			document.getElementById('date').value = "";
			document.getElementById('sender').value = "";
			document.getElementById('reason').value = "";
			
			alert('Transaction successfully added!');
			window.location.replace(home.jsp);
		},
		error: function() {
			alert('There was an error during the adding of the transaction.');
			throw new Error('There was an error in the AJAX request');
		}
	});
	
}


async function fillTables() {

	const response = await fetch('selectalltransactions');

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
			const tdDelete = document.createElement("td");
			const tdModify = document.createElement("td");

			const DeleteForm = document.createElement("form");
			const DeleteBtn = document.createElement("button");


			DeleteBtn.setAttribute('class', 'btnDelete');
			DeleteBtn.onclick = "";
			DeleteBtn.textContent = "Delete";
			DeleteBtn.setAttribute('data-contact-id', '' + id + '');
			DeleteBtn.setAttribute('onclick', 'deleteTransaction(this)');

			DeleteForm.appendChild(DeleteBtn);

			tdDelete.appendChild(DeleteForm);

			const ModifyForm = document.createElement("form");
			const ModifyBtn = document.createElement("button");


			ModifyBtn.setAttribute('class', 'btnDelete');
			ModifyBtn.onclick = "";
			ModifyBtn.textContent = "Modify";
			ModifyBtn.setAttribute('data-contact-id', '' + id + '');
			ModifyBtn.setAttribute('onclick', 'modifyTransaction(this)');

			ModifyBtn.appendChild(DeleteBtn);

			tdModify.appendChild(DeleteForm);

			tdAmount.innerHTML = amount;
			tdSender.innerHTML = sender;
			tdDate.innerHTML = date;


			row.appendChild(tdAmount);
			row.appendChild(tdDate);
			row.appendChild(tdSender);
			row.appendChild(tdDelete);
			row.appendChild(tdModify);

			new_tbody_income.appendChild(row);

		} else {
			var reason = transaction.reason;

			const row = document.createElement("tr");
			const tdAmount = document.createElement("td");
			const tdReason = document.createElement("td");
			const tdDate = document.createElement("td");
			const tdDelete = document.createElement("td");
			const tdModify = document.createElement("td");

			const DeleteForm = document.createElement("form");
			const DeleteBtn = document.createElement("button");


			DeleteBtn.setAttribute('class', 'btnDelete');
			DeleteBtn.onclick = "";
			DeleteBtn.textContent = "Delete";
			DeleteBtn.setAttribute('data-contact-id', '' + id + '');
			DeleteBtn.setAttribute('onclick', 'deleteTransaction(this)');

			DeleteForm.appendChild(DeleteBtn);

			tdDelete.appendChild(DeleteForm);

			const ModifyForm = document.createElement("form");
			const ModifyBtn = document.createElement("button");


			ModifyBtn.setAttribute('class', 'btnDelete');
			ModifyBtn.onclick = "";
			ModifyBtn.textContent = "Modify";
			ModifyBtn.setAttribute('data-contact-id', '' + id + '');
			ModifyBtn.setAttribute('onclick', 'modifyTransaction(this)');

			ModifyBtn.appendChild(DeleteBtn);

			tdModify.appendChild(DeleteForm);

			tdAmount.innerHTML = amount;
			tdReason.innerHTML = reason;
			tdDate.innerHTML = date;


			row.appendChild(tdAmount);
			row.appendChild(tdDate);
			row.appendChild(tdReason);
			row.appendChild(tdDelete);
			row.appendChild(tdModify);

			old_tbody_outcome.appendChild(row);
		}

	}

	incomeTable.replaceChild(new_tbody_income, old_tbody_income);
	new_tbody_income.id = 'old_tbody_income';

	outcomeTable.replaceChild(new_tbody_outcome, old_tbody_outcome);
	new_tbody_outcome.id = 'old_tbody_outcome';
}

/*async function deleteTransaction(btn) {
	var id = btn.getAttribute('data-contact-id');

	var options = {
		method: 'POST'
	};
	
	const response = await fetch('NOMESVLT?id=' + id, options);
	if (response.ok) {

		alert('Transaction successfully deleted!');
		await fillTables();
	} else {
		alert('There was an error during the elimination of the transaction.');
		throw new Error('Errore nella richiesta AJAX');
	}
}

async function modifyTransaction(btn) {
	var id = btn.getAttribute('data-contact-id');

	var options = {
		method: 'POST'
	};

	const response = await fetch('NOMESVLT?id=' + id, options);
	if (response.ok) {
		transaction = await response.json();




	} else {
		alert('Errore durante l\'eliminamento del contatto.');
		throw new Error('Errore nella richiesta AJAX');
	}
}*/


