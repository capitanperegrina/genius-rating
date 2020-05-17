package com.capitanperegrina.geniusrating.core.view.boatListView.repository;

import java.util.List;

import com.capitanperegrina.geniusrating.core.view.boatListView.BoatListView;

public interface BoatListRepository {

	List<BoatListView> find( Integer edition, Integer ownerId );
}
