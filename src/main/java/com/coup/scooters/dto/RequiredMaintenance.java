package com.coup.scooters.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown=true)
public class RequiredMaintenance {

    @NotNull
    @Size(min=1, max=100)
    private int[] scooters;

    @NotNull
    @Min(value = 1, message = "The value must be minimum 1")
    @Max(value = 999, message = "The value must be maximum 999")
    private int C;

    @NotNull
    @Min(value = 1, message = "The value must be minimum 1")
    @Max(value = 1000, message = "The value must be maximum 1000")
    private int P;
}
