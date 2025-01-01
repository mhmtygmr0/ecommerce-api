package com.app.ecommerce.dto.response;

import com.app.ecommerce.entity.Category;
import com.app.ecommerce.entity.Supplier;

public class ProductResponse {

    private int id;
    private String name;
    private double prc;
    private int stock;
    private Supplier supplier;
    private Category category;

    public ProductResponse() {
    }

    public ProductResponse(int id, String name, double prc, int stock, Supplier supplier, Category category) {
        this.id = id;
        this.name = name;
        this.prc = prc;
        this.stock = stock;
        this.supplier = supplier;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrc() {
        return prc;
    }

    public void setPrc(double prc) {
        this.prc = prc;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ProductResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", prc=" + prc +
                ", stock=" + stock +
                ", supplier=" + supplier +
                ", category=" + category +
                '}';
    }
}
