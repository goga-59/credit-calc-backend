package ru.creditcalc.backend.web.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.creditcalc.backend.model.attribute.EmploymentType;

@Component
public final class EmploymentTypeConverter implements Converter<String, EmploymentType> {

    @Override
    public EmploymentType convert(String key) {
        return EmploymentType.findByKey(key).orElse(null);
    }

}
