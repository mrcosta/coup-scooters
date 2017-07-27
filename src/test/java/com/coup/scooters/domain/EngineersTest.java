package com.coup.scooters.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class EngineersTest {

    @Test
    public void shouldReturnTheNumberOfRequiredEngineers() {
        Engineers engineers = new Engineers(5);
        int[] scootersByDistrict = {15, 10};

        assertThat(engineers.getNecessaryNumberOfEngineersForRemainingScooters(scootersByDistrict), is(5));
    }

    @Test
    public void shouldReturnTheNumberRoundUpOfRequiredEngineers() {
        Engineers engineers = new Engineers(5);
        int[] scootersByDistrict = {13, 10};

        assertThat(engineers.getNecessaryNumberOfEngineersForRemainingScooters(scootersByDistrict), is(5));
    }
}