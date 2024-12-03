package ru.creditcalc.backend.api.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.creditcalc.backend.SpringBootTests;
import ru.creditcalc.backend.api.dto.CreditCalculatorDto;
import ru.creditcalc.backend.model.attribute.LoanPurpose;

import static org.junit.jupiter.api.Assertions.*;

public final class CreditCalculatorServiceTest extends SpringBootTests {

    @Autowired private CreditCalculatorService creditCalculatorService;

    private final float eps = 0.1F;

    @Test
    void contextLoads() {
        assertNotNull(creditCalculatorService);
    }

    @Test
    void whenCalculateWithMaritalStatusMortgage_thenSuccess() {
        CreditCalculatorDto dto = new CreditCalculatorDto(
                10000,
                (byte) 3,
                LoanPurpose.MORTGAGE,
                (byte) 8,
                1000
        );

        assertTrue(Math.abs(creditCalculatorService.calculateMonthlyPayment(dto) - 282.02) < eps);
    }

    @Test
    void whenCalculateWithMaritalStatusConsumerLoan_thenSuccess() {
        CreditCalculatorDto dto = new CreditCalculatorDto(
                80000,
                (byte) 3,
                LoanPurpose.CONSUMER_LOAN,
                (byte) 10,
                0
        );

        assertTrue(Math.abs(creditCalculatorService.calculateMonthlyPayment(dto) - 2581.37) < eps);
    }

    @Test
    void whenCalculateWithMaritalStatusCarLoan_thenSuccess() {
        CreditCalculatorDto dto = new CreditCalculatorDto(
                100000,
                (byte) 5,
                LoanPurpose.CAR_LOAN,
                (byte) 10,
                0
        );

        assertTrue(Math.abs(creditCalculatorService.calculateMonthlyPayment(dto) - 2124.74) < eps);
    }

}