package com.app.ecommerce.entity;

import jakarta.persistence.*;

@Entity
@Table(
        name = "code",
        uniqueConstraints = @UniqueConstraint(columnNames = {"code_group", "code_serial"})
)
public class Code {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_id")
    private int id;

    @Column(name = "code_group")
    private String group;

    @Column(name = "code_serial")
    private String serial;

    @OneToOne(mappedBy = "code", cascade = CascadeType.ALL)
    private Product product;

    public Code() {
    }

    public Code(int id, String group, String serial, Product product) {
        this.id = id;
        this.group = group;
        this.serial = serial;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
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
                ", group='" + group + '\'' +
                ", serial='" + serial + '\'' +
                ", product=" + product +
                '}';
    }
}
