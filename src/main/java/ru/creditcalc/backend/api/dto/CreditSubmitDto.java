package ru.creditcalc.backend.api.dto;

import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;
import ru.creditcalc.backend.model.attribute.EmploymentType;
import ru.creditcalc.backend.model.attribute.InterestRate;
import ru.creditcalc.backend.model.attribute.LoanPurpose;
import ru.creditcalc.backend.model.attribute.MaritalStatus;

import java.time.LocalDate;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class CreditSubmitDto {

    @NotBlank
    @Size(min = 1, max = 64)
    private String name;

    @NotBlank
    @Size(min = 11, max = 11)
    private String phone;

    @Email
    private String email;

    @NotBlank
    @Size(min = 1, max = 64)
    private String address;

    @Past
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;

    @NotNull
    private MaritalStatus maritalStatus;

    @NotNull
    @PositiveOrZero
    private int salary;

    @NotNull
    private EmploymentType employmentStatus;

    @NotNull
    private LoanPurpose loanPurpose;

    @PositiveOrZero
    private int downPayment;

    @NotNull
    @PositiveOrZero
    private int loanAmount;

    @NotNull
    @PositiveOrZero
    private int loanTerm;

    @NotNull
    private InterestRate interestRate;

}
