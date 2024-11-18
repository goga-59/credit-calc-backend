package ru.creditcalc.backend.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreditCalculatorModel(
        @JsonProperty("monthly_payment") double monthlyPayment
) {

}
