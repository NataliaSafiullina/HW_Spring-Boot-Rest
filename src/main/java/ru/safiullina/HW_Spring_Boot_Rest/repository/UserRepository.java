package ru.safiullina.HW_Spring_Boot_Rest.repository;

import org.springframework.stereotype.Repository;
import ru.safiullina.HW_Spring_Boot_Rest.model.Authorities;

import java.util.List;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
        return null;
    }
}
