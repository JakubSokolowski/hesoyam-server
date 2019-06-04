package com.hesoyam.server.models;

import com.hesoyam.server.validation.RegistrationValidateGroup;
import org.springframework.data.annotation.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

public class User {
    @Id
    @NotBlank(groups = {RegistrationValidateGroup.class}, message = "Username is required!")
    @NotEmpty(groups = {RegistrationValidateGroup.class}, message = "Username is required!~!")
    @Size(groups = {RegistrationValidateGroup.class},min = 6,
            max = 32,
            message = "Please use between 6 and 32 characters!")
    private String username;

    @NotBlank(groups = {RegistrationValidateGroup.class}, message = "Password is reuqired!")
    @NotEmpty(groups = {RegistrationValidateGroup.class}, message = "Password is required!")
    @Size(groups = {RegistrationValidateGroup.class},min = 8,
            max = 32,
            message = "Try one with at least 8 characters!")
    private String password;

    public User(){

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(password, user.password);
    }
}
