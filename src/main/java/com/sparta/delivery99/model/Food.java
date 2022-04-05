package com.sparta.delivery99.model;

import com.sparta.delivery99.dto.FoodDto;
import com.sparta.delivery99.validator.FoodValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne( fetch = FetchType.LAZY) // 디폴트값은 FetchType.Eager
    @JoinColumn(name= "restaurantId", nullable = false)
    private Restaurant restaurant;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long price;


    public Food(Restaurant restaurant, FoodDto foodDto){

        FoodValidator.validateFood(foodDto);
        this.restaurant = restaurant;
        this.name = foodDto.getName();
        this.price = foodDto.getPrice();
    }

}
//@Getter
//@Setter
//@Entity
//@SequenceGenerator(
//        name = "FOOD_SEQ_GENERATOR",
//        sequenceName = "FOOD_SEQ", // 매핑할 데이터베이스 시퀀스 이름
//        initialValue = 1,
//        allocationSize = 1)
//@NoArgsConstructor
//public class Food {
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FOOD_SEQ_GENERATOR")
//    @Id
//    private Long id;
//    // 반드시 값을 가지도록 합니다.
//    @Column(nullable = false)
//    private String name;
//
//    @Column(nullable = false)
//    private Long price;
//
//    @ManyToOne(targetEntity = Restaurant.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "Restaurant_ID", nullable = false)
//    private Restaurant restaurant;
//
//    public Food(Restaurant restaurant, FoodDto foodDto){
//        FoodValidator.validateFood(foodDto);
//        this.name = foodDto.getName();
//        this.price = foodDto.getPrice();
//        this.restaurant = restaurant;
//    }
//}