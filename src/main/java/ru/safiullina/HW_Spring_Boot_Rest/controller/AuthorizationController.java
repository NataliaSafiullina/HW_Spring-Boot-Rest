package ru.safiullina.HW_Spring_Boot_Rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.safiullina.HW_Spring_Boot_Rest.exception.InvalidCredentials;
import ru.safiullina.HW_Spring_Boot_Rest.exception.UnauthorizedUser;
import ru.safiullina.HW_Spring_Boot_Rest.model.Authorities;
import ru.safiullina.HW_Spring_Boot_Rest.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    // Конструктор контроллера, который получает экземпляр сервиса
    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        System.out.println(user + " " + password);
        return service.getAuthorities(user, password);
    }

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> handlerInvalidCredentials (InvalidCredentials exception) {
        System.out.println("handlerInvalidCredentials");
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> handlerUnauthorizedUser (UnauthorizedUser exception) {
        System.out.println("handlerUnauthorizedUser");
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
