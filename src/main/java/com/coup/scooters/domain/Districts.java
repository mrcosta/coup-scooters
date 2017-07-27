package com.coup.scooters.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static java.util.Arrays.sort;
import static java.util.Arrays.stream;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Districts {

    private int[] scootersByDistrict;

    public int[] filterByScootersAmountIsNotMultipleOfEngineerWorkCapactiy(int[] scootersByDistrict, int amountOfScootersMaintainedByEngineer) {
        return stream(scootersByDistrict).filter(scootersInDistrict -> scootersInDistrict % amountOfScootersMaintainedByEngineer != 0).toArray();
    }

    public int[] getSortedScootersByDistrict() {
        int[] scootersByDisctrictCopy = scootersByDistrict.clone();
        sort(scootersByDisctrictCopy);

        return scootersByDisctrictCopy;
    }

    public void subtractManagerWorkCapacityFromItsDistrict(int[] sortedScooters, int managerCityIndex, int managerWorkCapacity) {
        sortedScooters[managerCityIndex]-= managerWorkCapacity;
    }
}
