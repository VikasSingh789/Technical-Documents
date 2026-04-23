package com.saga.webapp.stock.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saga.webapp.stock.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

	Stock findByItem(String item);
}
