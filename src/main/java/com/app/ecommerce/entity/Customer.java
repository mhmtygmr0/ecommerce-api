package com.app.ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.time.LocalDate;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "customer_gender")
    private Gender gender;

    @Email
    @Column(name = "customer_email", unique = true)
    private String email;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_registered_date")
    private LocalDate registeredDate = LocalDate.now();

    enum Gender {
        MALE, FEMALE, OTHER
    }

    public Customer() {
    }

    public Customer(int id, Gender gender, String email, String name, LocalDate registeredDate) {
        this.id = id;
        this.gender = gender;
        this.email = email;
        this.name = name;
        this.registeredDate = registeredDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", registeredDate=" + registeredDate +
                '}';
    }
}
