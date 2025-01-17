package ru.creditcalc.backend.web.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.creditcalc.backend.model.attribute.MaritalStatus;

@Component
public final class MaritalStatusConverter implements Converter<String, MaritalStatus> {

    @Override
    public MaritalStatus convert(String key) {
        return MaritalStatus.findByKey(key).orElse(null);
    }

}
