package com.example.mod2lab2.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Student {

    private String id;

    @NotNull
    @Size(min=3, max=50)
    private String name;
    @NotNull
    @Email(message="{invalid.email}")
    private String email;
    @NotNull
    @Size(min=6, max=50)
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}   