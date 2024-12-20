package ru.creditcalc.backend.api.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.creditcalc.backend.model.attribute.LoanPurpose;

@Getter
@AllArgsConstructor
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
    @Positive
    private byte interestRate;

    @PositiveOrZero
    private int downPayment;

}
