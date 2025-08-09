package com.valemont.exchange.stocks.controller;

import com.valemont.exchange.stocks.model.Stock;
import com.valemont.exchange.stocks.service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/stocks")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    // GET all stocks
    @GetMapping
    public ResponseEntity<List<Stock>> getAllStocks() {
        return ResponseEntity.ok(stockService.getAllStocks());
    }

    // GET stock by ID
    @GetMapping("/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable String id) {
        return ResponseEntity.ok(stockService.getStockById(UUID.fromString(id)));
    }

    // POST create new stock
    @PostMapping
    public ResponseEntity<Stock> createStock(@RequestBody Stock stock) {
        return ResponseEntity.ok(stockService.createStock(stock));
    }

    // PUT update stock (price or volume)
    @PutMapping("/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable String id, @RequestBody Stock updatedStock) {
        return ResponseEntity.ok(stockService.updateStock(UUID.fromString(id), updatedStock));
    }

    // DELETE a stock
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable String id) {
        stockService.deleteStock(UUID.fromString(id));
        return ResponseEntity.noContent().build();
    }
}
