package ru.safiullina.HW_Spring_Boot_Rest.repository;

import org.springframework.stereotype.Repository;
import ru.safiullina.HW_Spring_Boot_Rest.model.Authorities;
import ru.safiullina.HW_Spring_Boot_Rest.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {

    protected ConcurrentHashMap<User, List<Authorities>> usersAuthorities = new ConcurrentHashMap<>();

    public User addUserAuthorities() {
        User user = new User("nata", "1234");
        List<Authorities> authorities = new ArrayList<>();
        authorities.add(Authorities.READ);
        authorities.add(Authorities.WRITE);
        usersAuthorities.put(user, authorities);
        return user;
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        return usersAuthorities.get(addUserAuthorities());
    }
}
