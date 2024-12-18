package ru.creditcalc.backend.storage.converter;

import jakarta.persistence.Converter;
import ru.creditcalc.backend.model.attribute.EmploymentType;

@Converter(autoApply = true)
public class EmploymentTypeConverter extends TemplateConverter<EmploymentType> {

    @Override
    protected EmploymentType[] enumConstants() {
        return EmploymentType.values();
    }

}
