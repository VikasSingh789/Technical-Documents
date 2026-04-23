package com.saga.webapp.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saga.webapp.order.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
