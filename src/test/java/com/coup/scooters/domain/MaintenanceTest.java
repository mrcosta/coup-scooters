package com.coup.scooters.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MaintenanceTest {

    @Test
    public void shouldReturnTheMinimumNumberOfRequiredEngineers() {
        Maintenance maintenance = new Maintenance(new int[]{15, 10}, 12, 5);

        assertThat(maintenance.getRequiredFleetEngineers(), is(3));
    }

    @Test
    public void shouldReturnTheMinimumNumberOfRequiredEngineersAnotherCase() {
        Maintenance maintenance = new Maintenance(new int[]{11, 15, 13}, 9, 5);

        assertThat(maintenance.getRequiredFleetEngineers(), is(7));
    }

    @Test
    public void anyDistrictHasEnoughNumberOfScootersForTheManagerToWork() {
        Maintenance maintenance = new Maintenance(new int[]{8, 8, 8}, 9, 5);

        assertThat(maintenance.getRequiredFleetEngineers(), is(4));
    }
}