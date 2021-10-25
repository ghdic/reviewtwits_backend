package com.reviewtwits.repository;

import com.reviewtwits.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {
    Order save(Order order);
    Order findOrderByOrderId(int orderId);

}
