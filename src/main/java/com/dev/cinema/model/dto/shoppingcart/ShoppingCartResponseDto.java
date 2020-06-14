package com.dev.cinema.model.dto.shoppingcart;

import java.util.List;

public class ShoppingCartResponseDto {
    private Long shoppingCartId;
    private List<Long> ticketIds;
    private Long userId;

    public ShoppingCartResponseDto() {
    }

    public ShoppingCartResponseDto(Long shoppingCartId, List<Long> ticketIds, Long userId) {
        this.shoppingCartId = shoppingCartId;
        this.ticketIds = ticketIds;
        this.userId = userId;
    }

    public Long getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Long shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public List<Long> getTicketIds() {
        return ticketIds;
    }

    public void setTicketIds(List<Long> ticketIds) {
        this.ticketIds = ticketIds;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ShoppingCartResponseDto{" + "shoppingCartId=" + shoppingCartId
                + ", ticketIds=" + ticketIds + ", userId=" + userId + '}';
    }
}
