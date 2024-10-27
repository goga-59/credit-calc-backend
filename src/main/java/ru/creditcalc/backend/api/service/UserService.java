package ru.creditcalc.backend.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.creditcalc.backend.storage.model.User;
import ru.creditcalc.backend.storage.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public final class UserService {

    private final UserRepository userRepository;

    public Optional<User> findByEmail(String email) {
        return userRepository.findById(email);
    }

}
