package com.inditex.hexagonal.products.application.ports.input;

import com.inditex.hexagonal.products.domain.model.ProductPrice;

/**
 * Input interface to communicate with domain layer
 */
public interface GetProductPriceUseCase {

  ProductPrice getProductPrice(ProductPrice productPrice);

}
