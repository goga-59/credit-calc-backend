package ru.creditcalc.backend.storage.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import ru.creditcalc.backend.model.attribute.KeyedEnum;
import ru.creditcalc.backend.util.KeyedEnumConstantFinder;

@Converter
public abstract class TemplateConverter<E extends KeyedEnum> implements AttributeConverter<E, String> {

    protected abstract E[] enumConstants();

    @Override
    public String convertToDatabaseColumn(E attribute) {
        return attribute != null ? attribute.getKey() : null;
    }

    @Override
    public E convertToEntityAttribute(String key) {
        return KeyedEnumConstantFinder.findByKey(key, enumConstants()).orElse(null);
    }

}
