package ru.creditcalc.backend.model.attribute;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.creditcalc.backend.util.KeyedEnumConstantFinder;

import java.util.Optional;

@Getter
@AllArgsConstructor
public enum LoanPurpose implements KeyedEnum {

    MORTGAGE        ("mortgage"),
    CAR_LOAN        ("car-loan"),
    CONSUMER_LOAN   ("consumer-loan")
    ;

    @JsonValue
    private final String key;

    public static Optional<LoanPurpose> findByKey(String key) {
        return KeyedEnumConstantFinder.findByKey(key, values());
    }

}
