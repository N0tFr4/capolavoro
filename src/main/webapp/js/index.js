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
						window.location.href = '/capolavoro2/home.jsp';
					}else{
						alert('Incorrect credentials!')
					window.location.href = '/capolavoro2/index.jsp';
					}
					
				},
				error: function() {
					alert('Error!')
				}
			});
		});
});
 