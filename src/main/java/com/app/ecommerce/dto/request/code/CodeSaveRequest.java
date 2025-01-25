package com.app.ecommerce.dto.request.code;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CodeSaveRequest {
    @NotNull(message = "Group cannot be null.")
    private String group;

    @NotNull(message = "Serial cannot be null.")
    @Size(min = 6, message = "Serial min 6 characters.")
    private String serial;

    public CodeSaveRequest() {
    }

    public CodeSaveRequest(String group, String serial) {
        this.group = group;
        this.serial = serial;
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
        return "CodeSaveRequest{" + "group='" + group + '\'' + ", serial='" + serial + '\'' + '}';
    }
}
