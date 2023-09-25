package com.inditex.hexagonal.products.infrastructure.adapters.input.rest.mapper;

import com.inditex.hexagonal.products.domain.model.ProductPrice;
import com.inditex.hexagonal.products.infrastructure.adapters.input.rest.data.request.ProductGetPriceRequest;
import com.inditex.hexagonal.products.infrastructure.adapters.input.rest.data.response.ProductGetPriceResponse;
import org.mapstruct.Mapper;

@Mapper
public interface ProductRestMapper {

  ProductPrice toProductPrice(ProductGetPriceRequest productGetPriceRequest);

  ProductGetPriceResponse toProductGetPriceResponse(ProductPrice productPrice);


}
