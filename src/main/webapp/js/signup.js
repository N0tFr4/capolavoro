/**
 * 
 */

$(document).ready(function() {
	$('#insertForm').submit(function(e){
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
					window.location.href = '/capolavoro/index.jsp';
				},
				error: function() {
					alert("Error!");
					window.location.href = '/capolavoro/signup.jsp';
				}
			});
		});
});