package ru.creditcalc.backend.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.creditcalc.backend.api.model.UserModel;
import ru.creditcalc.backend.api.service.UserService;
import ru.creditcalc.backend.exception.ApiException;
import ru.creditcalc.backend.storage.model.User;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserApiController extends ApiControllerBase {

    private final UserService userService;

    @GetMapping("/profile")
    public UserModel getProfile() throws ApiException {
        User currentUser = getCurrentUser(userService);
        return new UserModel(currentUser.getEmail());
    }

}
