package com.app.ecommerce.dto.request.product;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ProductUpdateRequest {

    @NotNull(message = "Product ID cannot be null")
    private int id;

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
    private int supplierId;

    @NotNull(message = "Category cannot be null")
    private int categoryId;

    @NotNull(message = "Code cannot be null")
    private int codeId;

    public ProductUpdateRequest() {
    }

    public ProductUpdateRequest(int id, String name, double prc, int stock, int supplierId, int categoryId, int codeId) {
        this.id = id;
        this.name = name;
        this.prc = prc;
        this.stock = stock;
        this.supplierId = supplierId;
        this.categoryId = categoryId;
        this.codeId = codeId;
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

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getCodeId() {
        return codeId;
    }

    public void setCodeId(int codeId) {
        this.codeId = codeId;
    }

    @Override
    public String toString() {
        return "ProductUpdateRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", prc=" + prc +
                ", stock=" + stock +
                ", supplierId=" + supplierId +
                ", categoryId=" + categoryId +
                ", codeId=" + codeId +
                '}';
    }
}
