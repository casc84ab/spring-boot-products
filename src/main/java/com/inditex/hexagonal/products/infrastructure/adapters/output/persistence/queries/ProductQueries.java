package com.inditex.hexagonal.products.infrastructure.adapters.output.persistence.queries;

public class ProductQueries {

  public static final String PRODUCT_PRICE_GET = "select * from product_price_entity " +
      "where start_date < :applicationDate and end_date > :applicationDate " +
      "and product_id = :productId " +
      "and brand_id = :brandId";
}
