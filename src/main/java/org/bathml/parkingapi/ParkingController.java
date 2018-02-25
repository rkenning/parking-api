package org.bathml.parkingapi;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Arrays.asList;

@RestController
public class ParkingController {

    private ParkingService service;
    private ParkingValidator validator;

    ParkingController(final ParkingService service, final ParkingValidator validator) {
        this.service = service;
        this.validator = validator;
    }

    @PostMapping("/parking")
    public ParkingResponse post(final @RequestBody ParkingRequest req) {
        validator.validate(req);
        return makeDummyResponse();
    }

    private ParkingResponse makeDummyResponse() {
        final ParkingResponse res = new ParkingResponse();
        res.setCarparkDetails(makeDummyCarparkDetails());
        res.setPrediction(makeDummyPrediction());
        return res;
    }

    private Prediction makeDummyPrediction() {
        final Prediction prediction = new Prediction();
        prediction.setBucket(5);
        prediction.setProbabilities(asList(
                9, 10, 5, 10, 3, 20, 5, 19, 5, 9, 5
        ));
        return prediction;
    }

    private CarparkDetails makeDummyCarparkDetails() {
        final CarparkDetails details = new CarparkDetails();
        details.setCapacity(128);
        details.setPostCode("BA11AB");
        return details;
    }

}
