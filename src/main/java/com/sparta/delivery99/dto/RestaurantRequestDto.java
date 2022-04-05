package com.sparta.delivery99.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantRequestDto {
    private String name;

    private Long minOrderPrice;

    private Long deliveryFee;
}
