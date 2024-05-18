/**
 * 
 */

 function deleteTransaction(id){

    $.ajax({
        type: "GET",
        url: "deletesvlt?id="+id,
        success: function() {
            window.alert("Transaction successfully deleted");

            var toDelete= document.getElementById("tr "+id);
            toDelete.remove();
        }
    });
}

document.getElementById("amount").addEventListener("input", function(event) {
	let valore = event.target.value;
	event.target.value = valore.replace(/\D/g, '');
});


document.addEventListener("DOMContentLoaded", function() {
    var modIncomeButtons = document.querySelectorAll(".btnModifyIncome");
    var modOutcomeButtons = document.querySelectorAll(".btnModifyOutcome");
    var overlay = document.getElementById("overlay");

    // Aggiungi event listener a tutti i pulsanti di modifica per gli Income
    modIncomeButtons.forEach(function(button) {
        button.addEventListener("click", function() {
            showForm(button);
        });
    });

    // Aggiungi event listener a tutti i pulsanti di modifica per gli Outcome
    modOutcomeButtons.forEach(function(button) {
        button.addEventListener("click", function() {
            showForm(button);
        });
    });

    function showForm(button) {
        var id = button.getAttribute('data-id');
        var amount = button.getAttribute('data-amount');
        var date = button.getAttribute('data-date');
        var sender = button.getAttribute('data-sender');
        var reason = button.getAttribute('data-reason');

        document.getElementById('amount').value = amount;
        document.getElementById('date').value = date;
		document.getElementById('transaction-id').value = id;
		
        if (sender) {
            document.getElementById('sender').value = sender;
            document.getElementById('reason').value = "";
        } else if (reason) {
            document.getElementById('reason').value = reason;
            document.getElementById('sender').value = "";
        }
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
	$('#modTrans').submit(function(e) {
		e.preventDefault();
		$.ajax({
			url: 'modifytransactionsvlt',
			type: 'POST',
			data: {
				amount: $("#amount").val(),
				date: $("#date").val(),
				sender: $("#sender").val(),
				reason: $("#reason").val(),
				id: $("#transaction-id").val()
			},
			async: false,
			success: function() {
				alert('Transaction successfully modified!');
				updateTableRow($("#transaction-id").val(), $("#amount").val(), $("#date").val(), $("#sender").val(), $("#reason").val());
				updateButtonData($("#transaction-id").val(), $("#amount").val(), $("#date").val(), $("#sender").val(), $("#reason").val());
			},
			error: function() {
				alert('There was an error during the adding of the transaction.');
				throw new Error('There was an error in the AJAX request');
			}
		});
	});
	
	function updateTableRow(id, amount, date, sender, reason) {
        var row = document.getElementById("tr " + id);
        if (row) {
            row.cells[0].innerText = amount;
            row.cells[1].innerText = date;
            if (sender) {
                row.cells[2].innerText = sender;
            } else if (reason) {
                row.cells[2].innerText = reason;
            }
        }
    }
    
    function updateButtonData(id, amount, date, sender, reason) {
        var button = document.querySelector(".btnModifyIncome[data-id='" + id + "'], .btnModifyOutcome[data-id='" + id + "']");
        if (button) {
            button.setAttribute('data-amount', amount);
            button.setAttribute('data-date', date);
            button.setAttribute('data-sender', sender || "");
            button.setAttribute('data-reason', reason || "");
        }
    }
});