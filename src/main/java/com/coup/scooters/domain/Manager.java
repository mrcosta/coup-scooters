package com.coup.scooters.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Manager {

    private static final int DISTRICT_NOT_FOUND = -1;

    private int amountOfScootersMaintainedByManager;

    public int getDistrictThatMaximizesItsWorkCapacity(int[] filteredScooters) {
        int bestDistrictForManager = getDistrictWhereManagerCanWorkAtItsFullCapacity(filteredScooters);

        return bestDistrictForManager != DISTRICT_NOT_FOUND ? bestDistrictForManager : getDistrictWhereManagerWorkIsMostUsed(filteredScooters);
    }

    private Integer getDistrictWhereManagerCanWorkAtItsFullCapacity(int[] filteredScooters) {
        for (int index = 0; index < filteredScooters.length; index++) {
            if (capacityWillBeFullyUsedInThisDistrict(filteredScooters[index])) {
                return index;
            }
        }

        return DISTRICT_NOT_FOUND;
    }

    private int getDistrictWhereManagerWorkIsMostUsed(int[] filteredScooters) {
        int smallerRemainingManagerCapacityToWork = 0;
        int bestDistrictForManager = 0;

        for (int index = 0; index < filteredScooters.length; index++) {
            if (isAGoodDistrictToWork(filteredScooters[index], smallerRemainingManagerCapacityToWork)) {
                smallerRemainingManagerCapacityToWork = getRemainingCapacityToWorkForThisDistrict(filteredScooters[index]);
                bestDistrictForManager = index;
            }
        }

        return bestDistrictForManager;
    }

    private boolean capacityWillBeFullyUsedInThisDistrict(int amountOfScootersInDistrict) {
        return amountOfScootersInDistrict >= amountOfScootersMaintainedByManager;
    }

    private boolean isAGoodDistrictToWork(int scootersInDistrict, int smallerRemainingManagerCapacityToWork) {
        return (getRemainingCapacityToWorkForThisDistrict(scootersInDistrict) < smallerRemainingManagerCapacityToWork) || smallerRemainingManagerCapacityToWork == 0;
    }

    private int getRemainingCapacityToWorkForThisDistrict(int amountOfScootersInDistrict) {
        return amountOfScootersMaintainedByManager - amountOfScootersInDistrict;
    }
}
