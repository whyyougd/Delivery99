package com.sparta.delivery99.model;

import com.sparta.delivery99.dto.OrderReceiptDto;
import com.sparta.delivery99.dto.OrderedDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class OrderReceipt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long receiptId;

    @Column(nullable = false)
    private String restaurantName;

    @OneToMany(cascade=CascadeType.ALL)    // 맞나????
//    @Column(nullable = false)
    private List<FoodOrder> foods;

    @Column(nullable = false)
    private Long deliveryFee;

    @Column(nullable = false)
    private Long totalPrice;

    public OrderReceipt(OrderReceiptDto receiptDto){
        if(receiptDto.getMinOrderPrice() > receiptDto.getTotalPrice()-receiptDto.getDeliveryFees()){
            throw new IllegalArgumentException("최소주문 가격 이상 주문 하십쇼");
        }
        List<FoodOrder> foodList = new ArrayList<>();
        for(OrderedDto orderedDto: receiptDto.getFoods()){
            FoodOrder foodOrder = new FoodOrder(orderedDto);
            foodList.add(foodOrder);
        }

        this.restaurantName = receiptDto.getRestaurantName();
        this.foods = foodList;
        this.deliveryFee = receiptDto.getDeliveryFees();
        this.totalPrice = receiptDto.getTotalPrice();
    }

}
