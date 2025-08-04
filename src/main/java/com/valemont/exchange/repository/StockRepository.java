package com.valemont.exchange.repository;

import com.valemont.exchange.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StockRepository extends JpaRepository<Stock, UUID> {
    Optional<Stock> findBySymbol(String symbol);
}