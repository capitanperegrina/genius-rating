$(document).ready(function(){
	$('#userForm_submit').click(function(event) {
		$(this).prop("disabled", true);
		var callback  = function(response) {
			$("#userForm_nick").val(response.objects.userForm.nick).focus();
			$("#userForm_mail").val(response.objects.userForm.mail);
			$("#userForm_pass").val(response.objects.userForm.pass);
			$(this).prop("disabled", true);
		}
		var formData = {
				nick : $("#userForm_nick").val(),
				mail : $("#userForm_mail").val(),
				pass : $("#userForm_pass").val(),
				operation : $("#userForm_operation").val()
		};
		restPost( 
				$('#userForm').prop("action"), 
				formData, 
				function (data) {
               	 	processResponse(data, callback);
                },
                function (e) {
                    display(e);
                }
        );
        return false;
	});
});