package com.inditex.hexagonal.products.infrastructure.adapters.output.persistence;

import com.inditex.hexagonal.products.application.ports.output.ProductOutputPort;
import com.inditex.hexagonal.products.domain.exception.ProductNotFound;
import com.inditex.hexagonal.products.domain.model.ProductPrice;
import com.inditex.hexagonal.products.infrastructure.adapters.output.persistence.entity.ProductPriceEntity;
import com.inditex.hexagonal.products.infrastructure.adapters.output.persistence.mapper.ProductPersistenceMapper;
import com.inditex.hexagonal.products.infrastructure.adapters.output.persistence.repository.ProductPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;

/**
 * Implementation of the output interface from application layer
 */
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements ProductOutputPort {

  private final ProductPriceRepository productPriceRepository;

  private final ProductPersistenceMapper productPersistenceMapper;

  /**
   * Gets the product final price. If more than 1 price is returned then returns the max priority price
   * Returns a ProductNotFound if there is no price on db
   * @param productPrice the ProductPrice
   * @return the final ProductPrice
   */
  @Override
  @Transactional(readOnly = true)
  public ProductPrice getProductPrice(ProductPrice productPrice) {
    return productPersistenceMapper
        .toProduct(productPriceRepository
            .findByProductId(productPrice.getApplicationDate(), productPrice.getProductId(), productPrice.getBrandId())
            .max(Comparator.comparing(ProductPriceEntity::getPriority))
            .orElseThrow(() -> new ProductNotFound("Product Price not found for: " + productPrice.getApplicationDate())));
  }


}
