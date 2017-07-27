package com.coup.scooters.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MaintenanceTest {

    @Test
    public void shouldReturnTheMinimumNumberOfRequiredFleetEngineers() {
        Maintenance maintenance = new Maintenance(new int[]{15, 10}, 12, 5);

        assertThat(maintenance.getRequiredFleetEngineers(), is(3));
    }

    @Test
    public void shouldReturnTheMinimumNumberOfRequiredFleetEngineersAnotherCase() {
        Maintenance maintenance = new Maintenance(new int[]{11, 15, 13}, 9, 5);

        assertThat(maintenance.getRequiredFleetEngineers(), is(7));
    }
}