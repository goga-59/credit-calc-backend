package ru.creditcalc.backend.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.creditcalc.backend.storage.model.Credit;

public interface CreditRepository extends JpaRepository<Credit, Long> {

}
