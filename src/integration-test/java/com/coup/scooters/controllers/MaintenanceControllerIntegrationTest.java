package com.coup.scooters.controllers;

import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static javax.servlet.http.HttpServletResponse.SC_BAD_REQUEST;
import static javax.servlet.http.HttpServletResponse.SC_OK;
import static org.hamcrest.CoreMatchers.equalTo;

public class MaintenanceControllerIntegrationTest {

    public static final String MAINTENANCE_REQUIRED_ENGINEERS_ENDPOINT = "/api/maintenance/required-engineers";

    @Test
    public void shouldGetRequiredEngineers() {
        String requiredMaintenance = "{\"scooters\": [15, 10]," +
                           "\"C\": 12," +
                           "\"P\": 5}";

        given().contentType("application/json").body(requiredMaintenance).
        when().post(MAINTENANCE_REQUIRED_ENGINEERS_ENDPOINT).
        then().statusCode(SC_OK).body("fleet_engineers", equalTo(3));
    }

    @Test
    public void shouldReturnErrorWhenNotSendingOneOfTheRequiredInformation() {
        String requiredMaintenance = "{\"scooters\": null," +
                           "\"C\": 12," +
                           "\"P\": 5}";

        given().contentType("application/json").body(requiredMaintenance).
        when().post(MAINTENANCE_REQUIRED_ENGINEERS_ENDPOINT).
        then().statusCode(SC_BAD_REQUEST);
    }

    @Test
    public void shouldReturnErrorWhenSendingAParameterOutOfTheRange() {
        String requiredMaintenance = "{\"scooters\": [15, 10]," +
                           "\"C\": 0," +
                           "\"P\": 5}";

        given().contentType("application/json").body(requiredMaintenance).
        when().post(MAINTENANCE_REQUIRED_ENGINEERS_ENDPOINT).
        then().statusCode(SC_BAD_REQUEST);
    }
}
