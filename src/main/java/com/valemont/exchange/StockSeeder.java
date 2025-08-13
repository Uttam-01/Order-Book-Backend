package com.valemont.exchange;

import com.valemont.exchange.stocks.model.Stock;
import com.valemont.exchange.stocks.repository.StockRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Component
public class StockSeeder implements CommandLineRunner {

    private final StockRepository stockRepository;

    public StockSeeder(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public void run(String... args) {
        if (stockRepository.count() == 0) {
            List<Stock> initialStocks = List.of(
                    Stock.builder()
                            .symbol("AAPL")
                            .name("Apple Inc.")
                            .price(BigDecimal.valueOf(150.0))
                            .volume(0)
                            .build(),
                    Stock.builder()
                            .symbol("GOOGL")
                            .name("Alphabet Inc.")
                            .price(BigDecimal.valueOf(2800.0))
                            .volume(0)
                            .build(),
                    Stock.builder()
                            .symbol("AMZN")
                            .name("Amazon.com Inc.")
                            .price(BigDecimal.valueOf(3400.0))
                            .volume(0)
                            .build(),
                    Stock.builder()
                            .symbol("MSFT")
                            .name("Microsoft Corporation")
                            .price(BigDecimal.valueOf(299.0))
                            .volume(0)
                            .build(),
                    Stock.builder()
                            .symbol("TSLA")
                            .name("Tesla Inc.")
                            .price(BigDecimal.valueOf(700.0))
                            .volume(0)
                            .build(),
                    Stock.builder()
                            .symbol("META")
                            .name("Meta Platforms Inc.")
                            .price(BigDecimal.valueOf(350.0))
                            .volume(0)
                            .build(),
                    Stock.builder()
                            .symbol("NFLX")
                            .name("Netflix Inc.")
                            .price(BigDecimal.valueOf(500.0))
                            .volume(0)
                            .build(),
                    Stock.builder()
                            .symbol("NVDA")
                            .name("NVIDIA Corporation")
                            .price(BigDecimal.valueOf(800.0))
                            .volume(0)
                            .build(),
                    Stock.builder()
                            .symbol("BABA")
                            .name("Alibaba Group Holding Ltd.")
                            .price(BigDecimal.valueOf(200.0))
                            .volume(0)
                            .build(),
                    Stock.builder()
                            .symbol("JPM")
                            .name("JPMorgan Chase & Co.")
                            .price(BigDecimal.valueOf(160.0))
                            .volume(0)
                            .build()
            );

            stockRepository.saveAll(initialStocks);
            System.out.println("✅ Initial stock data seeded.");
        } else {
            System.out.println("ℹ️ Stocks already present, skipping seeding.");
        }
    }
}
