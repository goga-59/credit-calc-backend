package ru.creditcalc.backend.model.attribute;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.creditcalc.backend.util.KeyedEnumConstantFinder;

import java.util.Optional;

@Getter
@AllArgsConstructor
public enum EmploymentType implements KeyedEnum {

    FULL_TIME_EMPLOYMENT    ("full_time"),
    CONTRACT_EMPLOYMENT     ("contract"),
    SELF_EMPLOYMENT         ("self_employment"),
    UNEMPLOYED              ("unemployed")
    ;

    @JsonValue
    private final String key;

    public static Optional<EmploymentType> findByKey(String key) {
        return KeyedEnumConstantFinder.findByKey(key, values());
    }

}
