package ru.creditcalc.backend.model.attribute;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum InterestRate implements KeyedEnum {

    TEN_PERCENT         ("10"),
    TWELVE_PERCENT      ("12"),
    FOURTEEN_PERCENT    ("14")
    ;

    @JsonValue
    private final String key;

}
