package com.app.ecommerce.dto.request.category;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CategoryUpdateRequest {
    @Positive(message = "The value must be positive.")
    @NotNull(message = "Category id cannot be null")
    private int id;

    @NotNull(message = "Category name cannot be null")
    @NotEmpty(message = "Category name cannot be empty")
    private String name;

    public CategoryUpdateRequest(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryUpdateRequest() {
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

    @Override
    public String toString() {
        return "CategoryUpdateRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
