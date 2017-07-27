package com.coup.scooters.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MaintenanceTest {

    @Test
    public void shouldReturnTheMinimumNumberOfRequiredEngineers() {
        Districts districts = new Districts(new int[]{15, 10});
        Maintenance maintenance = new Maintenance(districts, 12, 5);

        assertThat(maintenance.getRequiredFleetEngineers(), is(3));
    }

    @Test
    public void shouldReturnTheMinimumNumberOfRequiredEngineersAnotherCase() {
        Districts districts = new Districts(new int[]{11, 15, 13});
        Maintenance maintenance = new Maintenance(districts, 9, 5);

        assertThat(maintenance.getRequiredFleetEngineers(), is(7));
    }

    @Test
    public void shouldReturnTheMinimumNumberOfRequiredEngineersEvenAnyDistrictHasEnoughNumberOfScootersForTheManagerToWork() {
        Districts districts = new Districts(new int[]{8, 8, 8});
        Maintenance maintenance = new Maintenance(districts, 9, 5);

        assertThat(maintenance.getRequiredFleetEngineers(), is(4));
    }

    @Test
    public void shouldReturnTheMinimumNumberOfRequiredEngineersEvenWhenManagerDistrictNeedsMoreThanOneEngineer() {
        Districts districts = new Districts(new int[]{15, 8, 8});
        Maintenance maintenance = new Maintenance(districts, 9, 5);

        assertThat(maintenance.getRequiredFleetEngineers(), is(5));
    }
}