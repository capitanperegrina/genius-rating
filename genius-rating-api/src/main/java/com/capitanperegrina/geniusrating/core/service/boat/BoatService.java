package com.capitanperegrina.geniusrating.core.service.boat;

import java.util.List;

import com.capitanperegrina.geniusrating.core.view.boatListView.BoatListView;

public interface BoatService {

	List<BoatListView> findAll( Integer edition );
	
	List<BoatListView> findByUserId( Integer edition, Integer ownerId );
}
