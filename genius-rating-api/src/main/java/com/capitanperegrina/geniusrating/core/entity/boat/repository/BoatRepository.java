package com.capitanperegrina.geniusrating.core.entity.boat.repository;

import java.util.List;

import com.capitanperegrina.geniusrating.core.entity.boat.Boat;

public interface BoatRepository {

	Boat create(Boat obj);

	boolean exists(Boat obj);

	Boat find(Boat obj);

	void update(Boat obj);

	void delete(Boat obj);

	List<Boat> findAll();

	List<Boat> findSome(Boat obj);

}