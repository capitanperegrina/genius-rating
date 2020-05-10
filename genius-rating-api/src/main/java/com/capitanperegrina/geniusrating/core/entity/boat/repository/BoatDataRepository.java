package com.capitanperegrina.geniusrating.core.entity.boat.repository;

import java.util.List;

import com.capitanperegrina.geniusrating.core.entity.boat.BoatData;

public interface BoatDataRepository {

	BoatData create(BoatData obj);

	boolean exists(BoatData obj);

	BoatData find(BoatData obj);

	void update(BoatData obj);

	void delete(BoatData obj);

	List<BoatData> findAll();

	List<BoatData> findSome(BoatData obj);

}