package com.sparta.delivery99.repository;

import com.sparta.delivery99.model.OrderReceipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderReceiptRepository extends JpaRepository<OrderReceipt, Long> {
}
