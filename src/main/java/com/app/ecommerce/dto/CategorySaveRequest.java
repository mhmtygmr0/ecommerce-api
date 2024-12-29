package com.app.ecommerce.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


public class CategorySaveRequest {

    @NotNull(message = "Category name cannot be null")
    @NotEmpty(message = "Category name cannot be empty")
    private String name;

    public CategorySaveRequest(String name) {
        this.name = name;
    }

    public CategorySaveRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategorySaveRequest{" +
                "name='" + name + '\'' +
                '}';
    }
}
