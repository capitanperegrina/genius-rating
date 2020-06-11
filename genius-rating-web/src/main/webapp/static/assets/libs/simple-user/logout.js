$(document).ready(function(){
	$('#menuLink_logout').click(function(event) {
		restGet( 
				"logoutRest.do", 
				function (data) {
               	 	processResponse(data);
                },
                function (e) {
                    display(e);
                }
        );
        return false;
	});
});