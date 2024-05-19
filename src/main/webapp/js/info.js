
$(document).ready(function() {
	$('#modUser').submit(function(e) {
		e.preventDefault();
		$.ajax({
			url: 'modifyusersvlt',
			type: 'POST',
			data: {
				firstname: $("#firstname").val(),
				surname: $("#surname").val(),
				phoneNumber: $("#phone_number").val()
			},
			async: false,
			success: function() {
				alert('User successfully modified!');
			},
			error: function() {
				alert('There was an error during the modify of the user.');
				throw new Error('There was an error in the AJAX request');
			}
		});
	});
});