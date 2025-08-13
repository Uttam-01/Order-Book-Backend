package com.valemont.exchange.stocks.model;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.valemont.exchange.common.model.BaseModel;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Stock extends BaseModel {

    @Column(nullable = false, unique = true)
    private String symbol;

    private String name;

    private BigDecimal price;

    private Integer volume;
}
