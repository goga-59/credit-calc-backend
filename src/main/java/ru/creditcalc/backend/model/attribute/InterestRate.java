package ru.creditcalc.backend.model.attribute;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum InterestRate implements KeyedEnum {

    FOUR_PERCENT        ("4"),
    FIVE_PERCENT        ("5"),
    SIX_PERCENT         ("6"),
    EIGHT_PERCENT       ("8"),
    TEN_PERCENT         ("10"),
    TWELVE_PERCENT      ("12"),
    FOURTEEN_PERCENT    ("14")
    ;

    @JsonValue
    private final String key;

}
