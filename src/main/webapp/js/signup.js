
$(document).ready(function() {
	$('#insertForm').submit(function(e) {
		e.preventDefault();
		$.ajax({
			url: 'insertsvlt',
			type: 'POST',
			data: {
				firstname: $("#firstname").val(),
				surname: $("#surname").val(),
				phone_number: $("#phone_number").val(),
				username: $("#username").val(),
				password: $("#password").val()
			},
			async: false,
			success: function() {
				$("#firstname").val('');
				$("#surname").val('');
				$("#phone_number").val('');
				$("#username").val('');
				$("#password").val('');

				alert("User registered successfully!");
				window.location.href = 'index.jsp';
			},
			error: function() {
				alert("There was an error during the register");
				throw new Error('There was an error in the AJAX request');
			}
		});
	});
});