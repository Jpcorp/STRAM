package com.yousoft.stram.persistence.dao.service;

import com.yousoft.stram.domain.DetailsOwners;
import com.yousoft.stram.domain.Vehicule;
import com.yousoft.stram.exception.StramException;

public interface DetailsOwnersVehiculeService {

	int insertOwnersVehicule(Vehicule vehicule) throws StramException;

	DetailsOwners findByRun(Vehicule vehicule) throws StramException;

}
