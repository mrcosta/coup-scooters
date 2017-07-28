package com.coup.scooters.controllers;

import com.coup.scooters.dto.RequiredMaintenance;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.rule.OutputCapture;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MaintenanceControllerTest {

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void shouldReturnRequiredEngineersNumber() {
        RequiredMaintenance requiredMaintenance = new RequiredMaintenance(new int[]{15, 10}, 12, 5);

        assertThat(new MaintenanceController().getRequiredEngineers(requiredMaintenance), is("{\"fleet_engineers\": 3 }"));
    }
}