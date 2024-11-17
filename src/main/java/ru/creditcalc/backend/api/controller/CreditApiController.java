package ru.creditcalc.backend.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.creditcalc.backend.api.dto.CreditSubmitDto;
import ru.creditcalc.backend.api.model.CreditSubmitModel;
import ru.creditcalc.backend.api.service.CreditSubmitService;
import ru.creditcalc.backend.exception.ApiException;

@RestController
@RequestMapping("/api/credit")
@RequiredArgsConstructor
public class CreditApiController extends ApiControllerBase {

    private final CreditSubmitService creditSubmitService;

    @PostMapping("/submit")
    public CreditSubmitModel sendCreditDecision(@Valid CreditSubmitDto dto) throws ApiException {
        String[] response = creditSubmitService.SubmitLoan(
                dto.getSalary(),
                dto.getLoanAmount(),
                dto.getBirthDate(),
                dto.getMaritalStatus(),
                dto.getEmploymentStatus()
        );
        return new CreditSubmitModel(response[0], response[1]);
    }

}
