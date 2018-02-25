package org.bathml.parkingapi;

import org.junit.Test;

public class ParkingValidatorTest {
    private ParkingValidator target = new ParkingValidator();
    @Test
    public void checkThatCarParksGetPrintedProperly() {
        final ParkingRequest req = new ParkingRequest();
        req.setCarpark("not a carpark");
        target.validate(req); //Just check logs and verify that you see all the valid names in there. #mvp
    }

}