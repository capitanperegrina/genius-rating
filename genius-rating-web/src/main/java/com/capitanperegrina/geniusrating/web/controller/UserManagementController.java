package com.capitanperegrina.geniusrating.web.controller;

import org.springframework.stereotype.Controller;

@Controller
public class UserManagementController {


}

/*

@Controller
public class DefaultBoatRaceAnalyzerController {

	@Autowired
	@Qualifier("openStreetMapHtmlGeneratorService")
	MapHtmlGeneratorService openStreetMapHtmlGeneratorService;
	
	@Autowired
	@Qualifier("navionicsHtmlGeneratorService")
	MapHtmlGeneratorService navionicsHtmlGeneratorService;

	private MapHtmlGeneratorService getMapService(final MapType mapType) {
		MapHtmlGeneratorService mapService = null;
		if ( mapType==MapType.OPEN_STREET_MAP ) {
			mapService = this.openStreetMapHtmlGeneratorService;
		} else {
			mapService = this.navionicsHtmlGeneratorService;
		}
		return mapService;
	}
	
	@GetMapping("/race")
	public String generateRaceAnalysis(
			@RequestParam(name = "m", required = true, defaultValue="1") Integer mapType,
			@RequestParam(name = "r", required = true) Integer raceId, @RequestParam(name = "l", required = true) Integer legId, Model model) {
		MapHtmlGeneratorService mapService = getMapService(MapType.valueOf(mapType));
		model.addAttribute("mapType",mapType);
		model.addAttribute("boatRaceAnalysisBean",mapService.generateBoatRaceAnalysisBean(raceId, legId));
		return "race";
	}
	
	@ResponseBody
	@GetMapping("/track.js")
	public ResponseEntity<String> generateTrackJavascriptFile(@RequestParam(name = "r", required = true) Integer raceId,
			@RequestParam(name = "l", required = true) Integer legId,
			@RequestParam(name = "t", required = true) Integer trackId, Model model) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(new MediaType("text","javascript"));
		return new ResponseEntity<>(this.navionicsHtmlGeneratorService.generateJavascriptVariableTrack(raceId, legId, trackId),
				responseHeaders, HttpStatus.CREATED);
	}
}

*/