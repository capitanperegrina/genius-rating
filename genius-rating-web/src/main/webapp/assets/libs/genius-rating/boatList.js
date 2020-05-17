
function boatTableSetup( lang ) {
	if ( lang == "es" ) {
		$("#boatListTable").DataTable({
			"language": {
	            "url": "assets/extra-libs/datatables.net/translations/spanish.json"
	        }
	    });		
	} else {
		$("#boatListTable").DataTable();
	}
}

