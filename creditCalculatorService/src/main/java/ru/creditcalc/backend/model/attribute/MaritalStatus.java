package ru.creditcalc.backend.model.attribute;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.creditcalc.backend.util.KeyedEnumConstantFinder;

import java.util.Optional;

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

    public static Optional<MaritalStatus> findByKey(String key) {
        return KeyedEnumConstantFinder.findByKey(key, values());
    }

}
