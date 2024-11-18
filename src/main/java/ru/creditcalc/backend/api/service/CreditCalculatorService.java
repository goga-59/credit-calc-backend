package ru.creditcalc.backend.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.creditcalc.backend.model.attribute.InterestRate;
import ru.creditcalc.backend.model.attribute.LoanPurpose;

@Service
@RequiredArgsConstructor
public class CreditCalculatorService {

    public double calculateMonthlyPayment(int loanAmount, int loanTerm, LoanPurpose loanPurpose, InterestRate interestRate, int downPayment) {
        double monthlyInterestRate = Double.parseDouble(interestRate.getKey()) / 100 / 12;
        int numberOfPayments = loanTerm * 12;

        if (loanPurpose == LoanPurpose.MORTGAGE)
            loanAmount -= downPayment;

        if (monthlyInterestRate == 0D)
            return (double) loanAmount / numberOfPayments;

        return (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));
    }

}
