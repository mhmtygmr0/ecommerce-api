package com.app.ecommerce.dto.response;

public class CodeResponse {
    private int id;
    private String prefix;
    private String number;

    public CodeResponse() {
    }

    public CodeResponse(int id, String prefix, String number) {
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
        return "CodeResponse{" +
                "id=" + id +
                ", prefix='" + prefix + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
