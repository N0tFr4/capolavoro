
var typeT = "";


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
		typeT = incomeButton.getAttribute('data-type');
	});

	outcomeButton.addEventListener("click", function() {
		showForm();
		typeT = outcomeButton.getAttribute('data-type');
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



$(document).ready(function() {
	$('#addTrans').submit(function(e) {
		e.preventDefault();
		$.ajax({
			url: 'inserttransactionsvlt',
			type: 'POST',
			data: {
				amount: $("#amount").val(),
				date: $("#date").val(),
				sender: $("#sender").val(),
				reason: $("#reason").val(),
				typeT: typeT 
			},
			async: false,
			success: function() {
				document.getElementById('amount').value = "";
				document.getElementById('date').value = "";
				document.getElementById('sender').value = "";
				document.getElementById('reason').value = "";

				alert('Transaction successfully added!');
			},
			error: function() {
				alert('There was an error during the adding of the transaction.');
				throw new Error('There was an error in the AJAX request');
			}
		});
	});
});



