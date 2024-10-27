package ru.creditcalc.backend.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserModel(
        @JsonProperty("email") String email
) {

}
