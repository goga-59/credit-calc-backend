package ru.creditcalc.backend.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreditSubmitModel(

        @JsonProperty("status") String status,
        @JsonProperty("reject_reason") String rejectReason

) {

}
