$(document).ready(function(){
	$('#userForm_submit').click(function(event) {
        $(this).prop("disabled", true);
        $.ajax({
                 type: "POST",
                 contentType: "application/json",
                 url: $('#userForm').prop("action"),
                 data: $('#userForm').serialize(),
                 success: function (data) {
                	 processResponse(data);
                     console.log("DONE");
                 },
                 error: function (e) {
                	 processResponse(e);
                     console.log("ERROR: ", e);
                     display(e);
                 }
        });
        return false;
	});
});