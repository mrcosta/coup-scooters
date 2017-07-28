package com.coup.scooters.controllers;

import com.coup.scooters.domain.Districts;
import com.coup.scooters.domain.Engineers;
import com.coup.scooters.domain.Maintenance;
import com.coup.scooters.domain.Manager;
import com.coup.scooters.dto.RequiredMaintenance;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/api/maintenance")
public class MaintenanceController {

    @RequestMapping(value="/required-engineers", method= POST, produces = "application/json")
    public String getRequiredEngineers(@Valid @RequestBody RequiredMaintenance requiredMaintenance) {
        Districts districts = new Districts(requiredMaintenance.getScooters());
        Manager manager = new Manager(requiredMaintenance.getC());
        Engineers engineers = new Engineers(requiredMaintenance.getP());
        Maintenance maintenance = new Maintenance(districts, manager, engineers);

        return "{\"fleet_engineers\": " + maintenance.getRequiredFleetEngineers() + " }";
    }
}
