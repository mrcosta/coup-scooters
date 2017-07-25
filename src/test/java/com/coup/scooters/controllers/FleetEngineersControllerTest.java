package com.coup.scooters.controllers;


import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.rule.OutputCapture;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FleetEngineersControllerTest {

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void shouldSayHi() {
        assertThat(new FleetEngineersController().sayHi(), is("hi"));
        this.outputCapture.expect(containsString("hello"));
    }
}