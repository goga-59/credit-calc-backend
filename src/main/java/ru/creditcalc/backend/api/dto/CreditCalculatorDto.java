package ru.creditcalc.backend.api.dto;

import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class CreditCalculatorDto {

    @NotNull
    @Min(0)
    @Max(10000000)
    private long loanAmount;

    @NotNull
    @Min(0)
    @Max(30)
    private byte deadline;

    @NotBlank
    @Size(min = 1, max = 10)
    private String loanPurpose;

    @NotNull
    @Min(0)
    @Max(100)
    private byte interestRate;

}
