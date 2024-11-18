package ru.creditcalc.backend.model.attribute;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MaritalStatus implements KeyedEnum {

    SINGLE      ("single"),
    MARRIED     ("married"),
    DIVORCED    ("divorced"),
    WIDOWED     ("widowed")
    ;

    @JsonValue
    private final String key;

}
