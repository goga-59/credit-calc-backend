package ru.creditcalc.backend.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.creditcalc.backend.api.dto.CreditCalculatorDto;
import ru.creditcalc.backend.model.attribute.LoanPurpose;

@Service
@RequiredArgsConstructor
public class CreditCalculatorService {

    public double calculateMonthlyPayment(CreditCalculatorDto dto) {
        double monthlyInterestRate = dto.getInterestRate() / 100D / 12D;
        int numberOfPayments = dto.getLoanTerm() * 12;
        int loanAmount = dto.getLoanAmount();

        if (dto.getLoanPurpose() == LoanPurpose.MORTGAGE && dto.getDownPayment() != null)
            loanAmount -= dto.getDownPayment();

        if (monthlyInterestRate == 0D)
            return (double) loanAmount / numberOfPayments;

        return (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));
    }

}
