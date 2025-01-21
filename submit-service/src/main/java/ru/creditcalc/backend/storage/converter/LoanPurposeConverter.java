package ru.creditcalc.backend.storage.converter;

import jakarta.persistence.Converter;
import ru.creditcalc.backend.model.attribute.LoanPurpose;

@Converter(autoApply = true)
public class LoanPurposeConverter extends ConverterTemplate<LoanPurpose> {

    @Override
    protected LoanPurpose[] enumConstants() {
        return LoanPurpose.values();
    }

}
