package com.sparta.delivery99.model;

import com.sparta.delivery99.dto.RestaurantRequestDto;
import com.sparta.delivery99.validator.RestaurantValidator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
//@AllArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본 키 생성을 DB에 위임한다. Mysql에서 많이씀
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long minOrderPrice;

    @Column(nullable = false)
    private Long deliveryFee;

    public Restaurant(RestaurantRequestDto requestDto){

        RestaurantValidator.validateRestaurant(requestDto);

        this.name = requestDto.getName();
        this.minOrderPrice = requestDto.getMinOrderPrice();
        this.deliveryFee = requestDto.getDeliveryFee();
    }
}
