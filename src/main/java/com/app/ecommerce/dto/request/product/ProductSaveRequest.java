package com.app.ecommerce.dto.request.product;

import com.app.ecommerce.entity.Category;
import com.app.ecommerce.entity.Supplier;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ProductSaveRequest {

    @NotNull(message = "Product name cannot be null")
    @NotEmpty(message = "Product name cannot be empty")
    private String name;

    @NotNull(message = "Price cannot be null")
    @Positive(message = "Price must be greater than zero")
    private double prc;

    @NotNull(message = "Stock cannot be null")
    @Positive(message = "Stock must be greater than zero")
    private int stock;

    @NotNull(message = "Supplier cannot be null")
    private Supplier supplier;

    @NotNull(message = "Category cannot be null")
    private Category category;

    public ProductSaveRequest() {
    }

    public ProductSaveRequest(String name, double prc, int stock, Supplier supplier, Category category) {
        this.name = name;
        this.prc = prc;
        this.stock = stock;
        this.supplier = supplier;
        this.category = category;
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
        return "ProductSaveRequest{" +
                "name='" + name + '\'' +
                ", prc=" + prc +
                ", stock=" + stock +
                ", supplier=" + supplier +
                ", category=" + category +
                '}';
    }
}
