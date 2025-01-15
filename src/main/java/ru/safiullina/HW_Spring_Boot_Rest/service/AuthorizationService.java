package ru.safiullina.HW_Spring_Boot_Rest.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.safiullina.HW_Spring_Boot_Rest.exception.InvalidCredentials;
import ru.safiullina.HW_Spring_Boot_Rest.exception.UnauthorizedUser;
import ru.safiullina.HW_Spring_Boot_Rest.model.Authorities;
import ru.safiullina.HW_Spring_Boot_Rest.repository.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    // Конструктор сервиса, который получает экземпляр репозитория
    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            System.out.println("User name or password is empty");
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            System.out.println("Unknown user " + user);
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }


}
