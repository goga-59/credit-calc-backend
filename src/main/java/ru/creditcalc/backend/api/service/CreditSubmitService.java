package ru.creditcalc.backend.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.creditcalc.backend.model.attribute.EmploymentType;
import ru.creditcalc.backend.model.attribute.InterestRate;
import ru.creditcalc.backend.model.attribute.LoanPurpose;
import ru.creditcalc.backend.model.attribute.MaritalStatus;
import ru.creditcalc.backend.storage.model.Credit;
import ru.creditcalc.backend.storage.repository.CreditRepository;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditSubmitService {

    private final CreditRepository creditRepository;

    private final int MIN_SALARY = 30000;
    private final double MAX_LOAN_AMOUNT_TO_SALARY_RATIO = 5D;
    private final int MIN_AGE = 18;
    private final List<EmploymentType> RESTRICTED_EMPLOYMENT_TYPES = List.of(EmploymentType.UNEMPLOYED);

    public List<String> submitLoan(
            String name,
            String phone,
            String email,
            String address,
            LocalDate birthday,
            MaritalStatus maritalStatus,
            int salary,
            EmploymentType employmentType,
            LoanPurpose loanPurpose,
            int downPayment,
            int loanAmount,
            byte loanTerm,
            InterestRate interestRate
    ) {

        SaveCredit(new Credit(
                name,
                phone,
                email,
                address,
                birthday,
                maritalStatus,
                salary,
                employmentType,
                loanPurpose,
                downPayment,
                loanAmount,
                loanTerm,
                interestRate
        ));

        String status = "Decline";
        String reason;
        short age = CalculateAge(birthday);

        if (salary < MIN_SALARY) {
            reason = "Salary";
        } else if (RESTRICTED_EMPLOYMENT_TYPES.contains(employmentType)) {
            reason = "Employment type";
        } else if (loanAmount > MAX_LOAN_AMOUNT_TO_SALARY_RATIO * salary) {
            reason = "Loan amount";
        } else if (age < MIN_AGE) {
            reason = "Age";
        } else if (maritalStatus == MaritalStatus.DIVORCED || maritalStatus == MaritalStatus.WIDOWED) {
            status = "Approved, but with limited conditions";
            reason = "Marital status";
        } else {
            status = "Approved";
            reason = "Everything is fine";
        }

        return Arrays.asList(status, reason);
    }

    public short CalculateAge(LocalDate birthday) {
        LocalDate currentDate = LocalDate.now();
        return (short) Period.between(birthday, currentDate).getYears();
    }

    private void SaveCredit(Credit credit) {
        creditRepository.save(credit);
    }

}
