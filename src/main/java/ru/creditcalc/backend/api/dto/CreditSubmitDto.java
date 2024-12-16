package ru.creditcalc.backend.api.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;
import ru.creditcalc.backend.model.attribute.EmploymentType;
import ru.creditcalc.backend.model.attribute.LoanPurpose;
import ru.creditcalc.backend.model.attribute.MaritalStatus;
import ru.creditcalc.backend.validation.annotation.PhoneNumber;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public final class CreditSubmitDto {

    @NotBlank
    private String name;

    @NotBlank
    @PhoneNumber
    private String phone;

    @Email
    private String email;

    @NotBlank
    @Size(min = 10)
    private String address;

    @PastOrPresent
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;

    @NotNull
    private MaritalStatus maritalStatus;

    @NotNull
    @PositiveOrZero
    private int salary;

    @NotNull
    private EmploymentType employmentType;

    @NotNull
    private LoanPurpose loanPurpose;

    @NotNull
    @PositiveOrZero
    private int downPayment;

    @NotNull
    @Min(10000) @Max(1000000)
    private int loanAmount;

    @NotNull
    @Min(1) @Max(30)
    private byte loanTerm;

    @NotNull
    @Positive
    private byte interestRate;

}
