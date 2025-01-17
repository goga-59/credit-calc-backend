package ru.creditcalc.backend.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.creditcalc.backend.api.dto.CreditCalculatorDto;
import ru.creditcalc.backend.api.model.CreditCalculatorModel;
import ru.creditcalc.backend.api.service.CreditCalculatorService;

@RestController
@RequestMapping("/api/calculator")
@RequiredArgsConstructor
public class CreditCalculatorApiController extends  ApiControllerBase {

    private final CreditCalculatorService creditCalculatorService;

    @PostMapping
    public CreditCalculatorModel postCalculatorResult(@Valid CreditCalculatorDto dto) {
        return new CreditCalculatorModel(creditCalculatorService.calculateMonthlyPayment(dto));
    }

}
