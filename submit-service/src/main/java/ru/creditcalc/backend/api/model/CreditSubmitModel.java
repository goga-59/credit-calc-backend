package ru.creditcalc.backend.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record CreditSubmitModel(
        @JsonProperty("status") String status,
        @JsonProperty("reason") String reason
) {

    private static Builder builder() {
        return new Builder();
    }

    public static CreditSubmitModel of(List<String> response) {
        return builder()
                .status(response.getFirst())
                .reason(response.getLast())
                .build();
    }

    public static final class Builder {

        private String status;
        private String reason;

        public CreditSubmitModel build() {
            return new CreditSubmitModel(status, reason);
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder reason(String reason) {
            this.reason = reason;
            return this;
        }

    }

}