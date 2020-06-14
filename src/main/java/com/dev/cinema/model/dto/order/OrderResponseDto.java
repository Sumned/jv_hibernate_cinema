package com.dev.cinema.model.dto.order;

import java.time.LocalDateTime;
import java.util.List;

public class OrderResponseDto {
    private Long orderId;
    private List<Long> ticketIds;
    private LocalDateTime orderDate;
    private Long userId;

    public OrderResponseDto() {
    }

    public OrderResponseDto(Long orderId, List<Long> ticketIds,
                            LocalDateTime orderDate, Long userId) {
        this.orderId = orderId;
        this.ticketIds = ticketIds;
        this.orderDate = orderDate;
        this.userId = userId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public List<Long> getTicketIds() {
        return ticketIds;
    }

    public void setTicketIds(List<Long> ticketIds) {
        this.ticketIds = ticketIds;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
