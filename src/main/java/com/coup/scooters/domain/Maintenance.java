package com.coup.scooters.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import static java.util.Arrays.sort;

@AllArgsConstructor
@NoArgsConstructor
public class Maintenance {

    private int[] scootersByDistrict;
    private int amountOfScootersMaintainedByManager;
    private int amountOfScootersMaintainedByEngineer;

    public int getRequiredFleetEngineers() {
        int firstPossibleCityForManagerIndex = getBestDistrictForManagerToMaintain();
        excludeManagerWorkFromItsDistrict(firstPossibleCityForManagerIndex);

        return getNecessaryNumberOfEngineers();
    }

    private int getBestDistrictForManagerToMaintain() {
        sort(scootersByDistrict);

        for (int index = 0; index < scootersByDistrict.length; index++) {
            if (managerCanWorkInThisCity(scootersByDistrict[index])) {
                return index;
            }
        }

        return scootersByDistrict.length - 1;
    }

    private boolean managerCanWorkInThisCity(int numberOfScooters) {
        return numberOfScooters >= amountOfScootersMaintainedByManager;
    }

    private void excludeManagerWorkFromItsDistrict(int firstPossibleDistrictForManagerIndex) {
        scootersByDistrict[firstPossibleDistrictForManagerIndex]-= amountOfScootersMaintainedByManager;
    }

    private int getNecessaryNumberOfEngineers() {
        int requiredEngineers = 0;

        for (int amountOfScootersInTheDiscrit: scootersByDistrict) {
            if (oneEngineerIsEnoughForTheDistrict(amountOfScootersInTheDiscrit)) {
                requiredEngineers++;
            } else {
                requiredEngineers+= (int) Math.ceil((double) amountOfScootersInTheDiscrit / amountOfScootersMaintainedByEngineer);
            }
        }

        return requiredEngineers;
    }

    private boolean oneEngineerIsEnoughForTheDistrict(int amountOfScootersInTheDiscrit) {
        return amountOfScootersInTheDiscrit < amountOfScootersMaintainedByEngineer && amountOfScootersInTheDiscrit > 0;
    }
}
