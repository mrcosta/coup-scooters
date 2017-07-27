package com.coup.scooters.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static java.util.Arrays.stream;

@AllArgsConstructor
@Getter
public class Engineers {

    private int amountOfScootersMaintainedByEngineer;

    public int getNecessaryNumberOfEngineersForRemainingScooters(int[] scootersByDistrict) {
        return stream(scootersByDistrict).map(this::getNumberOfEngineersForCurrentDistrict).sum();
    }

    private int getNumberOfEngineersForCurrentDistrict(int scootersInTheDistrict) {
        return oneEngineerIsEnoughForTheDistrict(scootersInTheDistrict) ? 1 : getRequiredNumberOfEngineers(scootersInTheDistrict);
    }

    private boolean oneEngineerIsEnoughForTheDistrict(int amountOfScootersInTheDiscrit) {
        return amountOfScootersInTheDiscrit < amountOfScootersMaintainedByEngineer && amountOfScootersInTheDiscrit > 0;
    }

    private int getRequiredNumberOfEngineers(double scootersInTheDistrict) {
        return (int) Math.ceil(scootersInTheDistrict / amountOfScootersMaintainedByEngineer);
    }
}
