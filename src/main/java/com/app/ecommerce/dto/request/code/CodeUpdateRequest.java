package com.app.ecommerce.dto.request.code;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CodeUpdateRequest {
    @NotNull(message = "ID cannot be null.")
    private int id;

    @NotNull(message = "Group cannot be null.")
    private String group;

    @NotNull(message = "Serial cannot be null.")
    @Size(min = 6, max = 6, message = "Serial must be exactly 6 characters.")
    private String serial;

    public CodeUpdateRequest() {
    }

    public CodeUpdateRequest(int id, String group, String serial) {
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
        return "CodeUpdateRequest{" +
                "id=" + id +
                ", group='" + group + '\'' +
                ", serial='" + serial + '\'' +
                '}';
    }
}
