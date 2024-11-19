package ru.creditcalc.backend.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreditSubmitModel(
        @JsonProperty("status") String status,
        @JsonProperty("reason") String reason
) {

}
