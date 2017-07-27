package com.coup.scooters.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MaintenanceTest {

    @Test
    public void shouldReturnTheMinimumNumberOfRequiredEngineers() {
        Districts districts = new Districts(new int[]{15, 10});
        Manager manager = new Manager(12);
        Engineers engineers = new Engineers(5);
        Maintenance maintenance = new Maintenance(districts, manager, engineers);

        assertThat(maintenance.getRequiredFleetEngineers(), is(3));
    }

    @Test
    public void shouldReturnTheMinimumNumberOfRequiredEngineersAnotherCase() {
        Districts districts = new Districts(new int[]{11, 15, 13});
        Manager manager = new Manager(9);
        Engineers engineers = new Engineers(5);
        Maintenance maintenance = new Maintenance(districts, manager, engineers);

        assertThat(maintenance.getRequiredFleetEngineers(), is(7));
    }

    @Test
    public void shouldReturnTheMinimumNumberOfRequiredEngineersEvenAnyDistrictHasEnoughNumberOfScootersForTheManagerToWork() {
        Districts districts = new Districts(new int[]{8, 8, 8});
        Manager manager = new Manager(9);
        Engineers engineers = new Engineers(5);
        Maintenance maintenance = new Maintenance(districts, manager, engineers);

        assertThat(maintenance.getRequiredFleetEngineers(), is(4));
    }

    @Test
    public void shouldReturnTheMinimumNumberOfRequiredEngineersEvenWhenManagerDistrictNeedsMoreThanOneEngineer() {
        Districts districts = new Districts(new int[]{15, 8, 8});
        Manager manager = new Manager(9);
        Engineers engineers = new Engineers(5);
        Maintenance maintenance = new Maintenance(districts, manager, engineers);

        assertThat(maintenance.getRequiredFleetEngineers(), is(5));
    }
}