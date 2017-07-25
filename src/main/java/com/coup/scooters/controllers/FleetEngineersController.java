package com.coup.scooters.controllers;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.slf4j.LoggerFactory.getLogger;


@RestController
public class FleetEngineersController {

    private static final Logger logger = getLogger(FleetEngineersController.class);

    @RequestMapping("/hi")
    public String sayHi() {
        logger.info("hello booter");
        return "hi";
    }
}
