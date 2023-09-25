package com.inditex.hexagonal.products.infrastructure.adapters.output.persistence.repository;

import com.inditex.hexagonal.products.infrastructure.adapters.output.persistence.entity.ProductPriceEntity;
import com.inditex.hexagonal.products.infrastructure.adapters.output.persistence.queries.ProductQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface ProductPriceRepository extends JpaRepository<ProductPriceEntity, Long> {

  @Query(value = ProductQueries.PRODUCT_PRICE_GET, nativeQuery = true)
  Stream<ProductPriceEntity> findByProductId(String applicationDate, String productId, int brandId);

}
