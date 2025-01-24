package ru.creditcalc.backend.api.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import ru.creditcalc.backend.SpringBootTests;
import ru.creditcalc.backend.api.dto.CreditSubmitDto;
import ru.creditcalc.backend.model.attribute.EmploymentType;
import ru.creditcalc.backend.model.attribute.LoanPurpose;
import ru.creditcalc.backend.model.attribute.MaritalStatus;
import ru.creditcalc.backend.storage.model.Credit;
import ru.creditcalc.backend.storage.repository.CreditRepository;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

public final class CreditSubmitServiceTest extends SpringBootTests {

    @Autowired
    private CreditSubmitService creditSubmitService;
    @MockitoBean
    private CreditRepository creditRepository;

    @Test
    void contextLoads() {
        assertNotNull(creditSubmitService);
        assertNotNull(creditRepository);
    }

    @Test
    void whenNow_thenZero() {
        short age = assertDoesNotThrow(() -> creditSubmitService.calculateAge(LocalDate.now()));
        assertEquals((short) 0, age);
    }

    @Test
    void whenPastDate_thenReturnAge() {;
        short age = assertDoesNotThrow(() -> creditSubmitService.calculateAge(LocalDate.now().minusYears(15)));
        assertEquals((short) 15, age);
    }

    @Test
    void whenAgeLessThanMinAge_thenRejected() {
        CreditSubmitDto dto = new CreditSubmitDto(
                "Egor",
                "89123456781",
                "gg@mail.ru",
                "my adress is adress adress",
                LocalDate.of(2014, 4, 30),
                MaritalStatus.MARRIED,
                40000,
                EmploymentType.FULL_TIME_EMPLOYMENT,
                LoanPurpose.MORTGAGE,
                10000,
                100000,
                (byte) 3,
                (byte) 10
        );

        Credit credit = new Credit();

        Mockito.when(creditRepository.save(credit)).thenReturn(credit);

        List<String> result = assertDoesNotThrow(() -> creditSubmitService.submitLoan(dto));

        assertEquals(List.of("Rejected", "Заявка отклонена. Причина: Ваш возраст должен быть не менее 18 лет для получения кредита."), result);
        Mockito.verify(creditRepository, times(1)).save(any(Credit.class));
    }

    @Test
    void whenSalaryLessThanMinSalary_thenRejected() {
        CreditSubmitDto dto = new CreditSubmitDto(
                "Egor",
                "89123456781",
                "gg@mail.ru",
                "my adress is adress adress",
                LocalDate.of(2004, 4, 30),
                MaritalStatus.MARRIED,
                20000,
                EmploymentType.FULL_TIME_EMPLOYMENT,
                LoanPurpose.MORTGAGE,
                10000,
                100000,
                (byte) 3,
                (byte) 10
        );

        Credit credit = new Credit();
        Mockito.when(creditRepository.save(credit)).thenReturn(credit);

        List<String> result = assertDoesNotThrow(() -> creditSubmitService.submitLoan(dto));

        assertEquals(List.of("Rejected", "Заявка отклонена. Причина: Ваш доход ниже минимального для получения кредита."), result);
        Mockito.verify(creditRepository, times(1)).save(any(Credit.class));
    }

    @Test
    void whenRestrictedEmploymentType_thenRejected() {
        CreditSubmitDto dto = new CreditSubmitDto(
                "Egor",
                "89123456781",
                "gg@mail.ru",
                "my adress is adress adress",
                LocalDate.of(2004, 4, 30),
                MaritalStatus.MARRIED,
                40000,
                EmploymentType.UNEMPLOYED,
                LoanPurpose.MORTGAGE,
                10000,
                100000,
                (byte) 3,
                (byte) 10
        );

        Credit credit = new Credit();

        Mockito.when(creditRepository.save(credit)).thenReturn(credit);

        List<String> result = assertDoesNotThrow(() -> creditSubmitService.submitLoan(dto));

        assertEquals(List.of("Rejected", "Заявка отклонена. Причина: Кредит не может быть предоставлен с текущим типом занятости."), result);
        Mockito.verify(creditRepository, times(1)).save(any(Credit.class));
    }

    @Test
    void whenLoanAmountToSalaryRatioMoreThanMaxRatio_thenRejected() {
        CreditSubmitDto dto = new CreditSubmitDto(
                "Egor",
                "89123456781",
                "gg@mail.ru",
                "my adress is adress adress",
                LocalDate.of(2004, 4, 30),
                MaritalStatus.MARRIED,
                30000,
                EmploymentType.FULL_TIME_EMPLOYMENT,
                LoanPurpose.MORTGAGE,
                0,
                1000000,
                (byte) 3,
                (byte) 10
        );

        Credit credit = new Credit();

        Mockito.when(creditRepository.save(credit)).thenReturn(credit);

        List<String> result = assertDoesNotThrow(() -> creditSubmitService.submitLoan(dto));

        assertEquals(List.of("Rejected", "Заявка отклонена. Причина: Запрашивамая сумма кредита превышает допустимый лимит относительно вашего дохода."), result);
        Mockito.verify(creditRepository, times(1)).save(any(Credit.class));
    }

    @Test
    void whenMaritalStatusIsDivorced_thenApprovedWithLimits() {
        CreditSubmitDto dto = new CreditSubmitDto(
                "Egor",
                "89123456781",
                "gg@mail.ru",
                "my adress is adress adress",
                LocalDate.of(2004, 4, 30),
                MaritalStatus.DIVORCED,
                30000,
                EmploymentType.FULL_TIME_EMPLOYMENT,
                LoanPurpose.MORTGAGE,
                0,
                100000,
                (byte) 3,
                (byte) 10
        );

        Credit credit = new Credit();

        Mockito.when(creditRepository.save(credit)).thenReturn(credit);

        List<String> result = assertDoesNotThrow(() -> creditSubmitService.submitLoan(dto));

        assertEquals(List.of("Approved with limits", "Мы можем предложить вам ограниченные условия кредита."), result);
        Mockito.verify(creditRepository, times(1)).save(any(Credit.class));
    }

    @Test
    void whenMaritalStatusIsWidowed_thenApprovedWithLimits() {
        CreditSubmitDto dto = new CreditSubmitDto(
                "Egor",
                "89123456781",
                "gg@mail.ru",
                "my adress is adress adress",
                LocalDate.of(2004, 4, 30),
                MaritalStatus.WIDOWED,
                30000,
                EmploymentType.FULL_TIME_EMPLOYMENT,
                LoanPurpose.MORTGAGE,
                10000,
                20000,
                (byte) 3,
                (byte) 10
        );
        Credit credit = new Credit();

        Mockito.when(creditRepository.save(credit)).thenReturn(credit);

        List<String> result = assertDoesNotThrow(() -> creditSubmitService.submitLoan(dto));

        assertEquals(List.of("Approved with limits", "Мы можем предложить вам ограниченные условия кредита."), result);
        Mockito.verify(creditRepository, times(1)).save(any(Credit.class));
    }

    @Test
    void whenEverythingGood_thenApproved() {
        CreditSubmitDto dto = new CreditSubmitDto(
                "Egor",
                "89123456781",
                "gg@mail.ru",
                "my adress is adress adress",
                LocalDate.of(2004, 4, 30),
                MaritalStatus.MARRIED,
                30000,
                EmploymentType.FULL_TIME_EMPLOYMENT,
                LoanPurpose.MORTGAGE,
                10000,
                20000,
                (byte) 3,
                (byte) 10
        );

        Credit credit = new Credit();

        Mockito.when(creditRepository.save(credit)).thenReturn(credit);

        List<String> result = assertDoesNotThrow(() -> creditSubmitService.submitLoan(dto));

        assertEquals(List.of("Approved", "Кредит одобрен."), result);
        Mockito.verify(creditRepository, times(1)).save(any(Credit.class));
    }

}