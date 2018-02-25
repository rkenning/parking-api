package org.bathml.parkingapi;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
class ParkingValidator {
    private static final List<String> CARPARKS = Arrays.asList(
            "Odd Down P+R",
            "SouthGate Rail CP",
            "Lansdown P+R",
            "Charlotte Street CP",
            "Podium CP",
            "Avon Street CP",
            "SouthGate General CP",
            "Newbridge P+R");

    void validate(final ParkingRequest req) {
        validateCarpark(req.getCarpark());
        validateCityEvents(req.getCityEvents());
        validateRugby(req.getRugby(), req.getRugbyHomeWin());
        validateTimeOfDay(req.getTimeOfDay());
        validateWeather(req.getWeather());
        validateWeekDay(req.getWeekDay());
        validateWeekNumber(req.getWeekNumber());
    }

    private void validateWeekNumber(final Integer weekNumber) {
        if (weekNumber == null)
            throw new ParkingValidationException("weekNumber must be specified");
        if (weekNumber < 1 || weekNumber > 53)
            throw new ParkingValidationException("Week number must be between 1 and 53");
    }

    private void validateWeekDay(final Integer weekDay) {
        if (weekDay == null) throw new ParkingValidationException("weekDay must be specified");
        if (weekDay < 1 || weekDay > 7) throw new ParkingValidationException("weekDay must be between 1 and 7");
    }

    private void validateWeather(Weather weather) {
        //Intentionally don't do any weather validation right now.
        //This may not be implemented as part of an MVP
    }

    private void validateTimeOfDay(final Float timeOfDay) {
        if (timeOfDay == null) {
            throw new ParkingValidationException("timeOfDay must be specified");
        }
        if (timeOfDay < 0 || timeOfDay >= 24.0)
            throw new ParkingValidationException("timeOfDay must be between 0 and 23.99");
    }

    private void validateRugby(final Boolean rugby, final Boolean rugbyHomeWin) {
        if (rugby == null ^ rugbyHomeWin == null)
            throw new ParkingValidationException("rugby and rugbyHomeWin must be specified whenever the other is specified");
    }

    private void validateCityEvents(final Integer cityEvents) {
        //Intentionally not validating this field as it may not be easily identifiable in an MVP
    }

    private void validateCarpark(final String carpark) {
        if (!CARPARKS.contains(carpark))
            throw new ParkingValidationException("Carpark not recognised. Please use one of " + CARPARKS);
    }
}
