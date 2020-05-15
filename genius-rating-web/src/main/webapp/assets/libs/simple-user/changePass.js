$(document).ready(function(){
	configurePasswordFieldButton("show_hide_password1");
	configurePasswordFieldButton("show_hide_password2");
	
	$('#userForm_submit').click(function(event) {
		$(this).prop("disabled", true);
		var callback  = function(response) {
			$("#userForm_pass").val("");
			$("#userForm_recoverCode").val("");
			$('#userForm_submit').prop("disabled", false);
		}
		var formData = {
				pass : $("#userForm_pass").val(),
				recoverCode : $("#userForm_recoverCode").val(),
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