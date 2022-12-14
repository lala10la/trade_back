package com.trade_accounting.models.dto.warehouse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentProductDto {
    private Long id;

    private Long productId;

    private BigDecimal amount;

    private BigDecimal price;
}
