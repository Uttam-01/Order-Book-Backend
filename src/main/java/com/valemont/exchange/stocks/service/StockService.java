package com.valemont.exchange.stocks.service;

import com.valemont.exchange.stocks.model.Stock;

import java.util.List;
import java.util.UUID;

public interface StockService {
    Stock createStock(Stock stock);

    List<Stock> getAllStocks();

    Stock getStockById(UUID id);

    Stock getStockBySymbol(String symbol);

    Stock updateStock(UUID id, Stock updatedStock);

    void deleteStock(UUID id);
}
