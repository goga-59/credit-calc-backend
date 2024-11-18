package ru.creditcalc.backend.storage.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.creditcalc.backend.api.dto.CreditSubmitDto;
import ru.creditcalc.backend.model.attribute.EmploymentType;
import ru.creditcalc.backend.model.attribute.InterestRate;
import ru.creditcalc.backend.model.attribute.LoanPurpose;
import ru.creditcalc.backend.model.attribute.MaritalStatus;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity @Table(name = "credit")
public class Credit {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone", nullable = false, length = 11)
    private String phone;

    @Column(name = "email", nullable = false, length = 64)
    private String email;

    @Column(name = "address", nullable = false, length = 64)
    private String address;

    @Column(name = "birthday", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate birthday;

    @Column(name = "marital_status", nullable = false)
    private MaritalStatus maritalStatus;

    @Column(name = "salary", nullable = false)
    private int salary;

    @Column(name = "employment_type", nullable = false)
    private EmploymentType employmentType;

    @Column(name = "loan_purpose", nullable = false)
    private LoanPurpose loanPurpose;

    @Column(name = "down_payment")
    private int downPayment;

    @Column(name = "loan_amount", nullable = false)
    private int loanAmount;

    @Column(name = "loan_term", nullable = false)
    private byte loanTerm;

    @Column(name = "interest_rate", nullable = false)
    private InterestRate interestRate;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    public Credit(
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
       this.name = name;
       this.phone = phone;
       this.email = email;
       this.address = address;
       this.birthday = birthday;
       this.maritalStatus = maritalStatus;
       this.salary = salary;
       this.employmentType = employmentType;
       this.loanPurpose = loanPurpose;
       this.downPayment = downPayment;
       this.loanAmount = loanAmount;
       this.loanTerm = loanTerm;
       this.interestRate = interestRate;
       this.createdAt = Instant.now();
    }

}
