package com.app.ecommerce.dto.request.code;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CodeSaveRequest {
    @NotNull(message = "Prefix cannot be null.")
    private String prefix;

    @Size(min = 5, max = 5, message = "Number must be 5 characters.")
    @NotNull(message = "Number cannot be null.")
    private String number;

    public CodeSaveRequest() {
    }

    public CodeSaveRequest(String prefix, String number) {
        this.prefix = prefix;
        this.number = number;
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
        return "CodeSaveRequest{" +
                "prefix='" + prefix + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
