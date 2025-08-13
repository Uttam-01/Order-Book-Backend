package com.valemont.exchange.stocks.service;

import com.valemont.exchange.common.exception.ResourceNotFoundException;
import com.valemont.exchange.stocks.model.Stock;
import com.valemont.exchange.stocks.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    @Override
    public void createStock(Stock stock) {
         stockRepository.save(stock);
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
        stockRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Stock not found"));
        stockRepository.deleteById(id);
    }
}
