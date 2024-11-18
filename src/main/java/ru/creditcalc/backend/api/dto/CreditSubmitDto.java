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
    private String name;

    @NotBlank
    @Pattern(regexp = "^\\d{11}$")
    private String phone;

    @Email
    private String email;

    @NotBlank
    @Size(min = 10)
    private String address;

    @Past
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthday;

    @NotNull
    private MaritalStatus maritalStatus;

    @NotNull
    @PositiveOrZero
    private int salary;

    @NotNull
    private EmploymentType employmentType;

    @NotNull
    private LoanPurpose loanPurpose;

    @PositiveOrZero
    private int downPayment;

    @NotNull
    @Min(value = 10000) @Max(value = 1000000)
    private int loanAmount;

    @NotNull
    @Min(value = 1) @Max(value = 30)
    private byte loanTerm;

    @NotNull
    private InterestRate interestRate;

}
