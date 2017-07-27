package com.coup.scooters.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import static java.util.Arrays.stream;

@NoArgsConstructor
@AllArgsConstructor
public class Maintenance {

    private Districts districts;
    private int amountOfScootersMaintainedByManager;
    private int amountOfScootersMaintainedByEngineer;

    public int getRequiredFleetEngineers() {
        int[] sortedScooters = districts.getSortedScootersByDistrict();
        int managerCityIndex = getDistrictThatMaximizesManagerWorkCapacity(sortedScooters);
        districts.subtractManagerWorkCapacityFromItsDistrict(sortedScooters, managerCityIndex, amountOfScootersMaintainedByManager);

        return getNecessaryNumberOfEngineersForRemainingScooters(sortedScooters);
    }

    private int getDistrictThatMaximizesManagerWorkCapacity(int[] sortedScooters) {
        int[] filteredScooters = districts.filterByScootersAmountIsNotMultipleOfEngineerWorkCapactiy(sortedScooters, amountOfScootersMaintainedByEngineer);
        int bestDistrictForManager = 0;
        int smallerRemainingManagerCapacityToWork = 0;

        for (int index = 0; index < filteredScooters.length; index++) {
            if (managerCapacityWillBeFullyUsedInThisDistrict(filteredScooters[index])) {
                bestDistrictForManager = index;
                break;
            } else {
                if ((getRemainingManagerCapacityToWorkForThisDistrict(filteredScooters[index]) < smallerRemainingManagerCapacityToWork) || smallerRemainingManagerCapacityToWork == 0) {
                    smallerRemainingManagerCapacityToWork = getRemainingManagerCapacityToWorkForThisDistrict(filteredScooters[index]);
                    bestDistrictForManager = index;
                }
            }
        }

        return bestDistrictForManager;
    }

    private boolean managerCapacityWillBeFullyUsedInThisDistrict(int amountOfScootersInDistrict) {
        return amountOfScootersInDistrict >= amountOfScootersMaintainedByManager;
    }

    private int getRemainingManagerCapacityToWorkForThisDistrict(int amountOfScootersInDistrict) {
        return amountOfScootersMaintainedByManager - amountOfScootersInDistrict;
    }

    private int getNecessaryNumberOfEngineersForRemainingScooters(int[] scootersByDistrict) {
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
