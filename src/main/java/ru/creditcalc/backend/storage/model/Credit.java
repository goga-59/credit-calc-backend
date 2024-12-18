package ru.creditcalc.backend.storage.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.creditcalc.backend.api.dto.CreditSubmitDto;
import ru.creditcalc.backend.model.attribute.EmploymentType;
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

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "birthday", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;

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
    private byte interestRate;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    public Credit(CreditSubmitDto dto) {
        this.name = dto.getName();
        this.phone = dto.getPhone();
        this.email = dto.getEmail();
        this.address = dto.getAddress();
        this.birthDate = dto.getBirthDate();
        this.maritalStatus = dto.getMaritalStatus();
        this.salary = dto.getSalary();
        this.employmentType = dto.getEmploymentType();
        this.loanPurpose = dto.getLoanPurpose();
        this.downPayment = dto.getDownPayment();
        this.loanAmount = dto.getLoanAmount();
        this.loanTerm = dto.getLoanTerm();
        this.interestRate = dto.getInterestRate();
        this.createdAt = Instant.now();
    }



}
