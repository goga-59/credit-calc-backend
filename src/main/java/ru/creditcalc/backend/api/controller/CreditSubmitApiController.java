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

import java.util.List;

@RestController
@RequestMapping("/api/submit")
@RequiredArgsConstructor
public class CreditSubmitApiController extends ApiControllerBase {

    private final CreditSubmitService creditSubmitService;

    @PostMapping
    public CreditSubmitModel postCreditDecision(@Valid CreditSubmitDto dto) throws ApiException {
        List<String> response = creditSubmitService.submitLoan(dto);
        return new CreditSubmitModel(response.get(0), response.get(1));
    }

}
