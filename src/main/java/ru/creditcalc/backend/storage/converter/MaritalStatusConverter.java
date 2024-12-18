package ru.creditcalc.backend.storage.converter;

import jakarta.persistence.Converter;
import ru.creditcalc.backend.model.attribute.MaritalStatus;

@Converter(autoApply = true)
public class MaritalStatusConverter extends TemplateConverter<MaritalStatus> {

    @Override
    protected MaritalStatus[] enumConstants() {
        return MaritalStatus.values();
    }

}
