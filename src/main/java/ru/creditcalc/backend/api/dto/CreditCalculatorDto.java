package ru.creditcalc.backend.api.dto;

import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.creditcalc.backend.model.attribute.InterestRate;
import ru.creditcalc.backend.model.attribute.LoanPurpose;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class CreditCalculatorDto {

    @NotNull
    @Min(10000) @Max(1000000)
    private int loanAmount;

    @NotNull
    @Min(1) @Max(30)
    private byte loanTerm;

    @NotNull
    private LoanPurpose loanPurpose;

    @NotNull
    private InterestRate interestRate;

    @PositiveOrZero
    private int downPayment;

}
