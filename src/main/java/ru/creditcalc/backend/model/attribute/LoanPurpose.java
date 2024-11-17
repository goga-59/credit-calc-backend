package ru.creditcalc.backend.model.attribute;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LoanPurpose implements KeyedEnum {

    MORTGAGE        ("mortgage"),
    CAR_LOAN        ("carLoan"),
    CONSUMER_LOAN   ("consumerLoan")
    ;

    @JsonValue
    private final String key;

}
