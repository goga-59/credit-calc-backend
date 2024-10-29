package ru.creditcalc.backend.api.dto;

import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class CreditApplicationDto {

    @NotNull
    @Size(min = 2, max = 3)
    private String[] fullName;

    @NotNull
    @Size(min = 11, max = 11)
    private String phoneNumber;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String address;

    @Past
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;

    @NotNull
    private String familyStatus;

    @NotNull
    @Min(1)
    private long income;

    @NotNull
    private String employmentStatus;

}
