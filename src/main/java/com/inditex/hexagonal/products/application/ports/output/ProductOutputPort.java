package com.inditex.hexagonal.products.application.ports.output;

import com.inditex.hexagonal.products.domain.model.ProductPrice;

/**
 *  Output interface to communicate with infrastructure layer
 */
public interface ProductOutputPort {

  ProductPrice getProductPrice(ProductPrice productPrice);

}
