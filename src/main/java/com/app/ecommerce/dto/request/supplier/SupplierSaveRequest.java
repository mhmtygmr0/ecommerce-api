package com.app.ecommerce.dto.request.supplier;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class SupplierSaveRequest {
    @NotNull(message = "Company name cannot be null.")
    @NotEmpty(message = "Company name cannot be empty.")
    private String companyName;

    @NotNull(message = "Contact name cannot be null.")
    @NotEmpty(message = "Contact name cannot be empty.")
    private String contactName;

    @NotNull(message = "Address cannot be null.")
    @NotEmpty(message = "Address cannot be empty.")
    private String address;

    @NotNull(message = "Contact email cannot be null.")
    @NotEmpty(message = "Contact email cannot be empty.")
    @Email(message = "Contact email must be a valid email address.")
    private String contactMail;

    public SupplierSaveRequest() {
    }

    public SupplierSaveRequest(String companyName, String contactName, String address, String contactMail) {
        this.companyName = companyName;
        this.contactName = contactName;
        this.address = address;
        this.contactMail = contactMail;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactMail() {
        return contactMail;
    }

    public void setContactMail(String contactMail) {
        this.contactMail = contactMail;
    }

    @Override
    public String toString() {
        return "SupplierSaveRequest{" +
                "companyName='" + companyName + '\'' +
                ", contactName='" + contactName + '\'' +
                ", address='" + address + '\'' +
                ", contactMail='" + contactMail + '\'' +
                '}';
    }
}
