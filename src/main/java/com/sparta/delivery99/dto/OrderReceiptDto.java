package com.sparta.delivery99.dto;

import com.sparta.delivery99.model.Restaurant;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderReceiptDto {

    private String restaurantName;
    private List<OrderedDto> foods;
    private Long deliveryFees;
    private Long totalPrice;
    private Long minOrderPrice;

    public OrderReceiptDto(Restaurant restaurant, List<OrderedDto> foods, Long sum){
        this.restaurantName = restaurant.getName();
        this.minOrderPrice = restaurant.getMinOrderPrice();
        this.foods = foods;
        this.deliveryFees = restaurant.getDeliveryFee();
        this.totalPrice = sum;
    }
}
