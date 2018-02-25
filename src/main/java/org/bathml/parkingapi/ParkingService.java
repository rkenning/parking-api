package org.bathml.parkingapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingService {

    private ParkingDao dao;

    @Autowired
    public void setDao(ParkingDao dao) {
        this.dao = dao;
    }
}
