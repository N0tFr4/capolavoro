/** 
 * 
 */

$(document).ready(function() {
	$('#loginForm').submit(function(e){
			e.preventDefault();
			$.ajax({
				url: 'authsvlt',
				type: 'POST',
				data: {
					username: $("#username").val(),
					password: $("#password").val()
				},
				async: false,
				success: function(response) {
					$("#username").val('');
					$("#password").val('');					
					
					if(response=="trovato"){
						alert('Login successfully completed!');
						window.location.href = 'home.jsp';
					}else{
						alert('Incorrect credentials!')
					window.location.href = 'index.jsp';
					}
					
				},
				error: function() {
					alert('Error!')
				}
			});
		});
});
 