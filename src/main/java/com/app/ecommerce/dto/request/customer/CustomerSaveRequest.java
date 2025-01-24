package com.app.ecommerce.dto.request.customer;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class CustomerSaveRequest {
    @NotBlank(message = "Gender cannot be blank")
    private String gender;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotNull(message = "Date cannot be null")
    @Past(message = "Date must be in the past")
    private LocalDate date;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid")
    private String mail;

    public CustomerSaveRequest() {
    }

    public CustomerSaveRequest(String gender, String name, LocalDate date, String mail) {
        this.gender = gender;
        this.name = name;
        this.date = date;
        this.mail = mail;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "CustomerSaveRequest{" +
                "gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", mail='" + mail + '\'' +
                '}';
    }
}
