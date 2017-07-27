package com.coup.scooters.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Maintenance {

    private Districts districts;
    private Manager manager;
    private Engineers engineers;

    public int getRequiredFleetEngineers() {
        int[] sortedScooters = districts.getSortedScootersByDistrict();
        int[] filteredScooters = districts.filterByScootersAmountIsNotMultipleOfEngineerWorkCapactiy(sortedScooters, engineers.getAmountOfScootersMaintainedByEngineer());
        int managerDistrictIndex = manager.getDistrictThatMaximizesItsWorkCapacity(filteredScooters);

        districts.subtractManagerWorkCapacityFromItsDistrict(sortedScooters, managerDistrictIndex, manager.getAmountOfScootersMaintainedByManager());

        return engineers.getNecessaryNumberOfEngineersForRemainingScooters(sortedScooters);
    }
}
