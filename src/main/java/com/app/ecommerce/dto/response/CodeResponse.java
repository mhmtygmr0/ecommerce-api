package com.app.ecommerce.dto.response;

public class CodeResponse {
    private int id;
    private String group;
    private String serial;

    public CodeResponse() {
    }

    public CodeResponse(int id, String group, String serial) {
        this.id = id;
        this.group = group;
        this.serial = serial;
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

    @Override
    public String toString() {
        return "CodeResponse{" +
                "id=" + id +
                ", group='" + group + '\'' +
                ", serial='" + serial + '\'' +
                '}';
    }
}
