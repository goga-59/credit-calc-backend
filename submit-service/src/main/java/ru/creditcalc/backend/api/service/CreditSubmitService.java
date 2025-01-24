package ru.creditcalc.backend.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.creditcalc.backend.api.dto.CreditSubmitDto;
import ru.creditcalc.backend.model.attribute.EmploymentType;
import ru.creditcalc.backend.model.attribute.MaritalStatus;
import ru.creditcalc.backend.storage.model.Credit;
import ru.creditcalc.backend.storage.repository.CreditRepository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditSubmitService {

    private final CreditRepository creditRepository;

    private final int MIN_SALARY = 30000;
    private final double MAX_LOAN_AMOUNT_TO_SALARY_RATIO = 5D;
    private final int MIN_AGE = 18;
    private final List<EmploymentType> RESTRICTED_EMPLOYMENT_TYPES = List.of(EmploymentType.UNEMPLOYED);
    private static final String rejection = "Заявка отклонена. Причина: ";

    public List<String> submitLoan(CreditSubmitDto dto) {
        creditRepository.save(new Credit(dto));

        short age = calculateAge(dto.getBirthDate());

        if (dto.getSalary() < MIN_SALARY)
            return List.of("Rejected", rejection + "Ваш доход ниже минимального для получения кредита.");

        if (age < MIN_AGE)
            return List.of("Rejected", rejection + "Ваш возраст должен быть не менее 18 лет для получения кредита.");

        if (RESTRICTED_EMPLOYMENT_TYPES.contains(dto.getEmploymentType()))
            return List.of("Rejected", rejection + "Кредит не может быть предоставлен с текущим типом занятости.");

        if (dto.getLoanAmount() > MAX_LOAN_AMOUNT_TO_SALARY_RATIO * dto.getSalary())
            return List.of("Rejected", rejection + "Запрашивамая сумма кредита превышает допустимый лимит относительно вашего дохода.");

        if (dto.getMaritalStatus() == MaritalStatus.DIVORCED || dto.getMaritalStatus() == MaritalStatus.WIDOWED)
            return List.of("Approved with limits", "Мы можем предложить вам ограниченные условия кредита.");

        return List.of("Approved", "Кредит одобрен.");
    }

    public short calculateAge(LocalDate birthDate) {
        return (short) ChronoUnit.YEARS.between(birthDate, LocalDate.now());
    }

}
