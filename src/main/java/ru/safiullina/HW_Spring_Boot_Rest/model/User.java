package ru.safiullina.HW_Spring_Boot_Rest.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class User {

    @NotBlank
    @Size(min = 2, max = 20)
    private String user;

    @NotBlank
    @Size(min = 4)
    private String password;

    public User() {
    }

    public User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user1 = (User) o;
        return Objects.equals(getUser(), user1.getUser()) && Objects.equals(getPassword(), user1.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser(), getPassword());
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }


}
