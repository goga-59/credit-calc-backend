package ru.creditcalc.backend.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.creditcalc.backend.storage.model.User;

public interface UserRepository extends JpaRepository<User, String> {

}
