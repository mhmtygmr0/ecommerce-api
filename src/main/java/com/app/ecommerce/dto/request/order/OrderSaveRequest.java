package com.app.ecommerce.dto.request.order;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public class OrderSaveRequest {
    @NotNull(message = "Total price cannot be null")
    @Positive(message = "Total price must be positive")
    private Double totalPrice;

    @NotNull(message = "Customer ID cannot be null")
    @Positive(message = "Customer ID must be a positive number")
    private Integer customerId;

    @NotEmpty(message = "Order product IDs cannot be empty")
    private List<@Positive(message = "Order product ID must be a positive number") Integer> orderProductIds;

    public OrderSaveRequest() {
    }

    public OrderSaveRequest(Double totalPrice, Integer customerId, List<@Positive(message = "Order product ID must be a positive number") Integer> orderProductIds) {
        this.totalPrice = totalPrice;
        this.customerId = customerId;
        this.orderProductIds = orderProductIds;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public List<Integer> getOrderProductIds() {
        return orderProductIds;
    }

    public void setOrderProductIds(List<Integer> orderProductIds) {
        this.orderProductIds = orderProductIds;
    }

    @Override
    public String toString() {
        return "OrderSaveRequest{" +
                "totalPrice=" + totalPrice +
                ", customerId=" + customerId +
                ", orderProductIds=" + orderProductIds +
                '}';
    }
}
