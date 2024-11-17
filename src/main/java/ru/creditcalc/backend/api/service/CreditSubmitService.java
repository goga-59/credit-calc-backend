package ru.creditcalc.backend.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.creditcalc.backend.model.attribute.EmploymentType;
import ru.creditcalc.backend.model.attribute.MaritalStatus;
import ru.creditcalc.backend.storage.repository.CreditRepository;

import java.time.LocalDate;
import java.time.Period;

@Service
@RequiredArgsConstructor
public class CreditSubmitService {

    private final CreditRepository creditRepository;

    private final int MIN_SALARY = 30000;
    private final double MAX_LOAN_AMOUNT_TO_SALARY_RATIO = 5D;
    private final int MIN_AGE = 18;
    private final EmploymentType employmentType = EmploymentType.UNEMPLOYED;

    public String[] SubmitLoan(
            int Salary,
            int loanAmount,
            LocalDate birthDate,
            MaritalStatus maritalStatus,
            EmploymentType employmentType
    ) {
        String[] submit = new String[2];
        short age = CalculateAge(birthDate);
        return submit;
    }

    public short CalculateAge(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        return (short) Period.between(birthDate, currentDate).getYears();
    }

}
