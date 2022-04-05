package com.sparta.delivery99.model;

import com.sparta.delivery99.dto.OrderedDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class FoodOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderedId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long quantity;

    @Column(nullable = false)
    private Long price;

    public FoodOrder(OrderedDto orderedDto){
        if(orderedDto.getQuantity() < 1) throw new IllegalArgumentException("최소 하나는 주문해야지");
        else if(orderedDto.getQuantity() >100) throw new IllegalArgumentException("사장님께서 주문수량 100개 이상은 따로 전화로 부탁한답니다.");

        this.name = orderedDto.getName();
        this.quantity = orderedDto.getQuantity();
        this.price = orderedDto.getPrice();
    }

}
