package com.app.ecommerce.dto.response;

import java.time.LocalDate;

public class CustomerResponse {

    private int id;
    private String gender;
    private String mail;
    private String name;
    private LocalDate date;

    public CustomerResponse(int id, String gender, String mail, String name, LocalDate date) {
        this.id = id;
        this.gender = gender;
        this.mail = mail;
        this.name = name;
        this.date = date;
    }

    public CustomerResponse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    @Override
    public String toString() {
        return "CustomerResponse{" +
                "id=" + id +
                ", gender='" + gender + '\'' +
                ", mail='" + mail + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
