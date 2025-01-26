package com.app.ecommerce.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;
    @Column(name = "order_date")
    private LocalDate orderDate;
    @Column(name = "order_total_price")
    private double totalPrice;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderProduct> orderProducts;

    public Order() {
    }

    public Order(int id, LocalDate orderDate, double totalPrice, Customer customer, List<OrderProduct> orderProducts) {
        this.id = id;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.customer = customer;
        this.orderProducts = orderProducts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate='" + orderDate + '\'' +
                ", totalPrice=" + totalPrice +
                ", customer=" + customer +
                ", orderProducts=" + orderProducts +
                '}';
    }
}
