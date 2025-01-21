package ru.creditcalc.backend.web.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.creditcalc.backend.model.attribute.LoanPurpose;

@Component
public final class LoanPurposeConverter implements Converter<String, LoanPurpose> {

    @Override
    public LoanPurpose convert(String key) {
        return LoanPurpose.findByKey(key).orElse(null);
    }

}
