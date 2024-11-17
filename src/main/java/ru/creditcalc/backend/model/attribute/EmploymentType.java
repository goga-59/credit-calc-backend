package ru.creditcalc.backend.model.attribute;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EmploymentType implements KeyedEnum {

    FULL_TIME_EMPLOYMENT    ("fullTime"),
    CONTRACT_EMPLOYMENT     ("contract"),
    SELF_EMPLOYMENT         ("selfEmployment"),
    UNEMPLOYED              ("unemployed")
    ;

    @JsonValue
    private final String key;

}
