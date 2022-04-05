package com.sparta.delivery99.controller;


import com.sparta.delivery99.dto.FoodOrderRequestDto;
import com.sparta.delivery99.dto.OrderReceiptDto;
import com.sparta.delivery99.dto.OrderRequestDto;
import com.sparta.delivery99.dto.OrderedDto;
import com.sparta.delivery99.model.Food;
import com.sparta.delivery99.model.OrderReceipt;
import com.sparta.delivery99.model.FoodOrder;
import com.sparta.delivery99.model.Restaurant;
import com.sparta.delivery99.repository.FoodRepository;
import com.sparta.delivery99.repository.OrderReceiptRepository;
import com.sparta.delivery99.repository.OrderedRepository;
import com.sparta.delivery99.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;
    private final OrderReceiptRepository orderReceiptRepository;
    private final OrderedRepository orderedRepository;

    @Transactional
    @PostMapping("/order/request")
    public OrderReceipt createOrder(@RequestBody OrderRequestDto orderRequestDto){

        Restaurant restaurant = restaurantRepository.findById(orderRequestDto.getRestaurantId()).orElse(null);
        List<OrderedDto> orderedDtoList = new ArrayList<>();
        long sum = 0;
        for(FoodOrderRequestDto foodOrderRequestDto: orderRequestDto.getFoods()){
            Food food = foodRepository.findById(foodOrderRequestDto.getId()).orElse(null);

            OrderedDto orderedDto = new OrderedDto(food.getName(),foodOrderRequestDto.getQuantity(),food.getPrice()* foodOrderRequestDto.getQuantity());
//            sum += food.getPrice() * foodOrderRequestDto.getQuantity();
            sum += orderedDto.getPrice();
            FoodOrder foodOrder = new FoodOrder(orderedDto);
            orderedRepository.save(foodOrder);
            orderedDtoList.add(orderedDto);
        }
//        System.out.println(restaurant.getName());
        sum += restaurant.getDeliveryFee();
        OrderReceiptDto orderReceiptDto = new OrderReceiptDto(restaurant,orderedDtoList,sum);
        OrderReceipt receipt = new OrderReceipt(orderReceiptDto);
        orderReceiptRepository.save(receipt);

        return receipt;
    }

    @Transactional
    @GetMapping("/orders")
    public List<OrderReceipt> getOrder(){
        return orderReceiptRepository.findAll();
    }
}
