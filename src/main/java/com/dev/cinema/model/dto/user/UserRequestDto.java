package com.dev.cinema.model.dto.user;

import com.dev.cinema.annotation.EmailConstraint;
import com.dev.cinema.annotation.PasswordsValueMatch;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@PasswordsValueMatch
public class UserRequestDto {
    @NotNull
    @EmailConstraint
    private String email;

    @NotNull
    @Size(min = 5, message = "Password too short")
    private String password;

    private String repeatPassword;

    public UserRequestDto() {

    }

    public UserRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
