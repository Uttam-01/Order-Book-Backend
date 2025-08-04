// File: src/main/java/com/valemont/exchange/model/UserStockHolding.java
package com.valemont.exchange.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserStockHolding {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Stock stock;

    private Integer quantity;
}
