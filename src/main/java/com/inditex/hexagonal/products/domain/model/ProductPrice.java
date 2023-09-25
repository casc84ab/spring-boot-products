package com.inditex.hexagonal.products.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductPrice {

    private Long id;

    private int brandId;

    private Timestamp startDate;

    private Timestamp endDate;

    private int priceList;

    private String productId;

    private int priority;

    private BigDecimal price;

    private String currency;

    private String applicationDate;

}
