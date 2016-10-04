package com.yousoft.stram.persistence.dao.service.impl;

import org.apache.log4j.Logger;

import com.yousoft.stram.domain.DetailsOwners;
import com.yousoft.stram.domain.OwnersVehicule;
import com.yousoft.stram.domain.Vehicule;
import com.yousoft.stram.exception.StramException;
import com.yousoft.stram.persistence.dao.DetailsOwnersMapper;
import com.yousoft.stram.persistence.dao.service.DetailsOwnersVehiculeService;

public class DetailsOwnersVehiculeServiceImpl implements DetailsOwnersVehiculeService {

    private static final Logger logger = Logger.getLogger(DetailsOwnersVehiculeServiceImpl.class);

    private static final String NO_INSERT = "Can't insert details ownsers";

    private static final String NO_DATA_FOUND = "Can't search by id details ownsers";

    DetailsOwnersMapper detailsOwnersMapper;

    public void setDetailsOwnersMapper(DetailsOwnersMapper detailsOwnersMapper) {
        this.detailsOwnersMapper = detailsOwnersMapper;
    }

    @Override
    public int insertOwnersVehicule(Vehicule vehicule) throws StramException {
        int result = 0;
        try {
            detailsOwnersMapper.insertDetailsOwners(vehicule);
            result = 1;
        } catch (Exception e) {
            logger.error(NO_INSERT, e);
            throw new StramException(NO_INSERT, e);
        }
        return result;
    }

    @Override
    public DetailsOwners findByRun(Vehicule vehicule) throws StramException {
        DetailsOwners detailsOwners = null;
        try {
            detailsOwners = detailsOwnersMapper.findById(vehicule);
            if (detailsOwners != null) {
                OwnersVehicule ownersVehicule = vehicule.getDetailsOwners().getOwnersVehicule();
                detailsOwners.setOwnersVehicule(ownersVehicule);
                vehicule.setDetailsOwners(detailsOwners);
            }
        } catch (Exception e) {
            logger.error(NO_DATA_FOUND, e);
            throw new StramException(NO_DATA_FOUND, e);
        }

        return detailsOwners;
    }

}
