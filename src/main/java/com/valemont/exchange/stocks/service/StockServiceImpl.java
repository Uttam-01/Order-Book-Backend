package com.valemont.exchange.stocks.service;

import com.valemont.exchange.stocks.model.Stock;
import com.valemont.exchange.stocks.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    @Autowired
    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Stock createStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Stock getStockById(UUID id) {
        return stockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stock not found with id: " + id));
    }

    @Override
    public Stock getStockBySymbol(String symbol) {
        return stockRepository.findBySymbol(symbol)
                .orElseThrow(() -> new RuntimeException("Stock not found with symbol: " + symbol));
    }

    @Override
    public Stock updateStock(UUID id, Stock updatedStock) {
        Stock existing = getStockById(id);
        existing.setName(updatedStock.getName());
        existing.setPrice(updatedStock.getPrice());
        existing.setVolume(updatedStock.getVolume());
        existing.setSymbol(updatedStock.getSymbol());
        return stockRepository.save(existing);
    }

    @Override
    public void deleteStock(UUID id) {
        stockRepository.deleteById(id);
    }
}
