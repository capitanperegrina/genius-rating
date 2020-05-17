package com.capitanperegrina.geniusrating.core.service.boat.impl;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.capitanperegrina.geniusrating.core.service.boat.BoatService;
import com.capitanperegrina.geniusrating.core.view.boatListView.BoatListView;
import com.capitanperegrina.geniusrating.core.view.boatListView.repository.BoatListRepository;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class BoatServiceImpl implements BoatService {

	@Autowired(required=false)
	BoatListRepository boatListRepository;
	
	public List<BoatListView> findAll( Integer edition ) {
		Validate.notNull(edition);
		return this.boatListRepository.find(edition,null);
	}
	
	public List<BoatListView> findByUserId( Integer edition, Integer ownerId ) {
		Validate.notNull(edition);
		Validate.notNull(ownerId);
		return this.boatListRepository.find(edition, ownerId);
	}
}
