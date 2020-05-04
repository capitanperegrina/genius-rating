function restPost(url, formData, functionOk, functionErr) {
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : url,
        asynt   : true,
        dataType: 'json',
		data : JSON.stringify(formData),
	}).done(function(data) {
		functionOk(data);
    }).fail(function(xhr, status, error) {
    	functionErr(xhr, status, error);
    });
}

function processResponse(response, callback) {
	console.log(response);
	if ( response.validationErrors != null && response.validationErrors.errors != null && response.validationErrors.errors.length > 0 ) { // form validation errors
		var firstControl = null;
		clearFormValidationErrors();
		$.each(response.validationErrors.errors, function (index, value) {
			if ( firstControl != null ) {
				firstControl = $("#error_" + value.fieldName);
			}
			$("#" + response.formName + "_"  + value.fieldName).addClass("is-invalid").on("blur", function() {
				$("#error_" + value.fieldName).html("");
				$(this).removeClass("is-invalid");
				$(this).off("blur");
			});
			$("#error_" + value.fieldName).html(value.message);
		});
		if ( response.validationErrors.message != null ) {
			$("#modal-message").html(response.validationErrors.message);
		};
		callback(response);
		firstControl.focus();
	} 	

	if ( response.message != null ) { // exists message
		// Text
		$("#modal-title").html(response.messageTitle);
		$("#modal-message").html(response.message);
		
		// Css
		$("#common-alert-modal-background").removeClass("modal-filled bg-success bg-danger").addClass(getModalDivClass(response.messageLevel));
		$("#common-alert-modal-icon").removeClass("text-info text-warning").addClass(getModalIconClass(response.messageLevel));
		$("#common-alert-modal-button").removeClass("btn-light btn-info btn-warning").addClass(getModalButtonClass(response.messageLevel));

		// Functions
		if ( response.urlRedirect != null ) {
			$("#common-alert-modal-button").on("click", function() {
				document.location = response.urlRedirect;
			});
			$("#common-alert-modal").modal('show');
		} else {
			$("#common-alert-modal-button").off("click");
			$("#common-alert-modal").modal('show');
			callback(response);
		}
	} else { // no message
		if ( response.urlRedirect != null ) {
			document.location = response.urlRedirect;
		}		
	}
}

function getModalDivClass( level ) {
	if ( level == "OK" ) {
		return "modal-content modal-filled bg-success";
	} else if ( level == "INFO" ) {
		return "modal-content";
	} else if ( level == "WARN" ) {
		return "modal-content";
	} else if ( level == "ERROR" ) {
		return "modal-content modal-filled bg-danger";
	} else {
		return "";
	}
}

function getModalIconClass( level ) {
	if ( level == "OK" ) {
		return "dripicons-checkmark h1";
	} else if ( level == "INFO" ) {
		return "dripicons-information h1 text-info";
	} else if ( level == "WARN" ) {
		return "dripicons-warning h1 text-warning";
	} else if ( level == "ERROR" ) {
		return "dripicons-wrong h1";
	} else {
		return "";
	}
}

function getModalButtonClass( level ) {
	if ( level == "OK" ) {
		return "btn btn-light my-2";
	} else if ( level == "INFO" ) {
		return "btn btn-info my-2";
	} else if ( level == "WARN" ) {
		return "btn btn-warning my-2";
	} else if ( level == "ERROR" ) {
		return "btn btn-light my-2";
	} else {
		return "";
	}
}

function clearFormValidationErrors() {
	$(".formError").each(function() {
		$(this).html('');
	});	
}
