package com.inditex.hexagonal.products.domain.service;

import com.inditex.hexagonal.products.application.ports.input.GetProductPriceUseCase;
import com.inditex.hexagonal.products.application.ports.output.ProductOutputPort;
import com.inditex.hexagonal.products.domain.model.ProductPrice;
import lombok.AllArgsConstructor;

/**
 * Implementation of the input interface from application layer
 * Calls output interface in application layer
 */
@AllArgsConstructor
public class ProductPriceService implements GetProductPriceUseCase {

  private final ProductOutputPort productOutputPort;

  @Override
  public ProductPrice getProductPrice(ProductPrice productPrice) {
    productPrice = productOutputPort.getProductPrice(productPrice);
    return productPrice;
  }

}
