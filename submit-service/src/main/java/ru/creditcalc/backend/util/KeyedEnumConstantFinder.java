package ru.creditcalc.backend.util;

import lombok.experimental.UtilityClass;
import ru.creditcalc.backend.model.attribute.KeyedEnum;

import java.util.Optional;

@UtilityClass
public class KeyedEnumConstantFinder {

    public <E extends KeyedEnum> Optional<E> findByKey(String key, E[] values) {
        if (key != null && !key.isEmpty())
            for (E value : values)
                if (key.equalsIgnoreCase(value.getKey()))
                    return Optional.of(value);

        return Optional.empty();
    }

}
