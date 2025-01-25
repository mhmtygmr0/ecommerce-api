package com.app.ecommerce.entity;

import jakarta.persistence.*;

@Entity
@Table(
        name = "code",
        uniqueConstraints = @UniqueConstraint(columnNames = {"code_prefix", "code_number"})
)
public class Code {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_id")
    private int id;

    @Column(name = "code_prefix")
    private String prefix;

    @Column(name = "code_number")
    private String number;

    @OneToOne(mappedBy = "code", cascade = CascadeType.ALL)
    private Product product;

    public Code() {
    }

    public Code(int id, String prefix, String number, Product product) {
        this.id = id;
        this.prefix = prefix;
        this.number = number;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Code{" +
                "id=" + id +
                ", prefix='" + prefix + '\'' +
                ", number='" + number + '\'' +
                ", product=" + product +
                '}';
    }
}
