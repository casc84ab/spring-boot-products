package com.inditex.hexagonal.products.infrastructure.adapters.input.rest.data.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Product Price response
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductGetPriceResponse {

    private int productId;

    private int priceList;

    private Timestamp startDate;

    private Timestamp endDate;

    private BigDecimal price;


}
