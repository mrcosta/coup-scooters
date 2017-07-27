package com.coup.scooters.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ManagerTest {

    @Test
    public void shouldReturnIndexOfTheBestDistrictForTheManagerToWork() {
        Manager manager = new Manager(9);
        int[] scootersByDistrict = {10, 15};

        assertThat(manager.getDistrictThatMaximizesItsWorkCapacity(scootersByDistrict), is(0));
    }

    @Test
    public void shouldReturnIndexOfTheBestDistrictForTheManagerToWorkEvenWhenScootersAmountIsSmallerThanItsCapacity() {
        Manager manager = new Manager(9);
        int[] scootersByDistrict = {5, 8};

        assertThat(manager.getDistrictThatMaximizesItsWorkCapacity(scootersByDistrict), is(1));
    }
}