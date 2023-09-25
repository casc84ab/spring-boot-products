package com.inditex.hexagonal.products.infrastructure.adapters.output.persistence.repository;

import com.inditex.hexagonal.products.infrastructure.adapters.output.persistence.entity.ProductPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPriceRepository extends JpaRepository<ProductPriceEntity, Long> {
}
