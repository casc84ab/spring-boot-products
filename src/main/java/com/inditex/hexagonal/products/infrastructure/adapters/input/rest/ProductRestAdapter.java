package com.inditex.hexagonal.products.infrastructure.adapters.input.rest;

import com.inditex.hexagonal.products.application.ports.input.GetProductPriceUseCase;
import com.inditex.hexagonal.products.domain.model.ProductPrice;
import com.inditex.hexagonal.products.infrastructure.adapters.input.rest.data.request.ProductGetPriceRequest;
import com.inditex.hexagonal.products.infrastructure.adapters.input.rest.data.response.ProductGetPriceResponse;
import com.inditex.hexagonal.products.infrastructure.adapters.input.rest.mapper.ProductRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Input rest adapter to receive Product calls
 */
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class ProductRestAdapter {

  private final GetProductPriceUseCase getProductPriceUseCase;
  private final ProductRestMapper productRestMapper;

  @PostMapping(value = "/products")
  public ResponseEntity<ProductGetPriceResponse> createProduct(@RequestBody @Valid ProductGetPriceRequest productGetPriceRequest){
    // Request to domain
    ProductPrice productPrice = productRestMapper.toProductPrice(productGetPriceRequest);

    productPrice = getProductPriceUseCase.getProductPrice(productPrice);

    // Domain to response
    return new ResponseEntity<>(productRestMapper.toProductGetPriceResponse(productPrice), HttpStatus.CREATED);
  }

}
