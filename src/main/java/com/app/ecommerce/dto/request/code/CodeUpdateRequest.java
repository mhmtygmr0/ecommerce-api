package com.app.ecommerce.dto.request.code;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CodeUpdateRequest {
    @NotNull(message = "ID cannot be null.")
    private int id;

    @NotNull(message = "Prefix cannot be null.")
    private String prefix;

    @Size(min = 5, max = 5, message = "Number must be 5 characters.")
    @NotNull(message = "Number cannot be null.")
    private String number;

    public CodeUpdateRequest() {
    }

    public CodeUpdateRequest(int id, String prefix, String number) {
        this.id = id;
        this.prefix = prefix;
        this.number = number;
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

    @Override
    public String toString() {
        return "CodeUpdateRequest{" +
                "id=" + id +
                ", prefix='" + prefix + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
