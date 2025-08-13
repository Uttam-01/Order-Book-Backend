package com.valemont.exchange.stocks.controller;

import com.valemont.exchange.common.exception.MessageResponse;
import com.valemont.exchange.stocks.model.Stock;
import com.valemont.exchange.stocks.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/stocks")
public class StockController {

    private final StockService stockService;

    @GetMapping
    public ResponseEntity<List<Stock>> getAllStocks() {
        return ResponseEntity.ok(stockService.getAllStocks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable String id) {
        return ResponseEntity.ok(stockService.getStockById(UUID.fromString(id)));
    }

    @PostMapping
    public ResponseEntity<MessageResponse> createStock(@RequestBody Stock stock) {
        stockService.createStock(stock);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessageResponse("Stock created successfully"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable String id, @RequestBody Stock updatedStock) {
        return ResponseEntity.ok(stockService.updateStock(UUID.fromString(id), updatedStock));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteStock(@PathVariable UUID id) {
        stockService.deleteStock(id);
        return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse("Stock deleted successfully"));
    }
}
