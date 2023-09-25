package com.inditex.hexagonal.products.domain.service;

import com.inditex.hexagonal.products.application.ports.input.GetProductPriceUseCase;
import lombok.AllArgsConstructor;

/**
 * Implementation of the input interface from application layer
 * Calls output interface in application layer
 */
@AllArgsConstructor
public class ProductPriceService implements GetProductPriceUseCase {


}
