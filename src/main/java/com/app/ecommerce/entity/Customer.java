package com.app.ecommerce.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;

    @Column(name = "customer_gender")
    private String gender;

    @Column(name = "customer_mail")
    private String mail;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_on_date")
    private LocalDate date;

    public Customer() {
    }

    public Customer(int id, String gender, String mail, String name, LocalDate date) {
        this.id = id;
        this.gender = gender;
        this.mail = mail;
        this.name = name;
        this.date = date;
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
        return "Customer{" +
                "id=" + id +
                ", gender='" + gender + '\'' +
                ", mail='" + mail + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
