$(document).ready(function(){
	$('#userForm_submit').click(function(event) {
		$(this).prop("disabled", true);
		var callback  = function(response) {
			$('#userForm_submit').prop("disabled", false);
		}
		var formData = {
				mail : $("#userForm_mail").val(),
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